import React from 'react';
import {BrowserRouter as Router, Route, Switch, Link, Redirect} from 'react-router-dom';
import {ListGroup, ListGroupItem, PageHeader} from 'react-bootstrap';
import '../App.css';

const Samples = ({match}) => (
  <Router>
  <div className="Sample">
    <PageHeader>Alireitti käytössä, uusi reititys normaalin lisäksi<small>{match.url}</small></PageHeader>
    <SampleNav/>
    <Switch>
      <Route exact path={match.url} component={SampleIndex}/>
      <Route path={`${match.url}/first`} component={One}/>
      <Route path="/samples/second" exact component={Two}/>
      <Route path="/samples/second/:id" component={Detail}/>
      <Redirect from={`${match.url}/nomore`} to={`${match.url}/first`}/>
      <Route component={NoSample}/>
    </Switch>
  </div>
  </Router>
)

const SampleNav = () => (
  <ListGroup>
    <ListGroupItem><Link to="/samples/">Esimerkit indeksi - tämä + osareitti</Link></ListGroupItem>
    <ListGroupItem><Link to="/samples/first">Sivu yksi /first</Link></ListGroupItem>
    <ListGroupItem><Link to="/samples/second">Kaksi /second</Link></ListGroupItem>
    <ListGroupItem><Link to="/samples/second/12">Kaksi + 12 /second/12</Link></ListGroupItem>
    <ListGroupItem><Link to="/samples/puffthemagigdragon">Virheellinen osoite /puffthemagigdragon</Link></ListGroupItem>
    <ListGroupItem><Link to="/samples/nomore">Redirect /nomore</Link></ListGroupItem>
    </ListGroup>
)
const SampleIndex = () => (<p>Indeksi <i>oletuksena</i> tämä teksti.</p>)
const One = ({match}) => (<p>Yksi + match.url tässä komponentissa: {match.url}</p>)
const Two = () => (<p>Two</p>)
const Detail = ({ match }) => (
  <div>
    <h3>Id välitetty, eli match.params.id: {match.params.id}</h3>
  </div>
)
const NoSample = () => (<p>Virheellinen alisivu!</p>)

export default Samples;
