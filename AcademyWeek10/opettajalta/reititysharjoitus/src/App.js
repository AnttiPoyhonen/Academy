import React from 'react';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import { Grid } from 'react-bootstrap';
import Navigation from './Navigation';
import Home  from './components/Home';
import Samples from './components/Samples';
import Documents from './components/Documents';
import ViewDocument from './components/ViewDocument';
import NotFound from './NotFound';
import './App.css';

const App = appProps => (
  <Router>
    <div className="App">
      <Navigation/>
      <Grid>
        <Switch>
          <Route exact name="index" path="/" component={Home} />
          <Route path="/samples" component={Samples}/>
          <Route exact path="/documents" component={Documents} />
          <Route path="/documents/:_id" component={ViewDocument} />
          <Route component={NotFound} />
        </Switch>
      </Grid>
      <hr/>
    </div>
  </Router>
);

export default App;
