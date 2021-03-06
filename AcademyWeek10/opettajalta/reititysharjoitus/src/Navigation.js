import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import { Navbar, Nav, NavItem, NavDropdown, MenuItem} from 'react-bootstrap';
import './App.css';

class Navigation extends Component {
  render() {
    return (
      <Navbar staticTop>
      <Navbar.Header>
        <Navbar.Brand>
          <Link to="/">Reititysesimerkki</Link>
        </Navbar.Brand>
        <Navbar.Toggle />
      </Navbar.Header>
      <Navbar.Collapse>
      <Nav>
        <NavItem href="/documents">Komponentti+alasivu</NavItem>
        <NavItem href="/samples">Esimerkkejä</NavItem>
        <NavDropdown title="Esimerkkejä - alisivu" id="basic-nav-dropdown">
          <MenuItem href="/samples/second/42">Esimerkki/kaksi, id: 42</MenuItem>
          <MenuItem href="/samples/second/105">Esimerkki/kaksi, id: 105</MenuItem>
          <MenuItem divider/>
          <MenuItem href="/samples/nosuchaddress">Not found alisivu</MenuItem>
        </NavDropdown>
      </Nav>
        <Nav pullRight>
        <NavItem href="/nosuchaddress">Not Found (404)</NavItem>
        </Nav>
    </Navbar.Collapse>
    </Navbar>
    );
  }
}

export default Navigation;
