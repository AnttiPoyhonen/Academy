import React, { Component } from 'react';
import {ListGroupItem} from 'react-bootstrap';
import './Quote.css';


class Quote extends Component {
    naytatiedot = (e) => {
        e.preventDefault();
        this.props.history.push("/details?id="+this.props.sanonta.id);
    }
    render() {
    return (
        <ListGroupItem onClick={this.naytatiedot} header={this.props.sanonta.author}>
            {this.props.sanonta.quotetext}
        </ListGroupItem>
    );
  }
}

export default Quote;
