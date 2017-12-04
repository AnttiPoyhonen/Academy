import React, { Component } from 'react';
import './QuoteBox.css';
import { BrowserRouter as Router, Link, Route, Switch } from 'react-router-dom';
import { Navbar, Nav, NavItem } from 'react-bootstrap';
import QuoteList from './QuoteList';
import QuoteForm from './QuoteForm';
import QuoteDetails from './QuoteDetails';
import Home from './Home';

class QuoteBox extends Component {
  render() {
    return (
        <Router>
            <div>
                <Navigation />
                <div className="content">
                <Switch>
                    <Route exact path="/" component={Home} />
                    <Route path="/quotes" component={QuoteList} />
                    {/* <Route path="/create" render={(props) =>
              <QuoteForm {...props} />}
            /> */}
                    <Route path="/create" component={QuoteForm}/>
                    <Route path="/details" component={QuoteDetails}/>
                </Switch>
                </div>
            </div>
        </Router>
    );
  }
}

class Navigation extends Component {
    render() {
        return (
            <Navbar>
                <Navbar.Header>
                    <Navbar.Brand>
                        <Link to="/">Sanonta-harjoitus</Link>
                    </Navbar.Brand>
                    <Navbar.Toggle />
                </Navbar.Header>
                <Navbar.Collapse>
                    <Nav>
                        <NavItem href="/quotes">Sanonnat</NavItem>
                        <NavItem href="/create">Uusi sanonta</NavItem>
                    </Nav>
                </Navbar.Collapse>
            </Navbar>
        );
    }
}


export default QuoteBox;
