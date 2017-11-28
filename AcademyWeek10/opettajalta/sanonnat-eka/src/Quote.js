import React, { Component } from 'react';
import './Quote.css';


class Quote extends Component {
  render() {
    return (
      <li className="quote">
        <p>{this.props.sanonta.author}</p>
        <p>{this.props.sanonta.quotetext}</p>
      </li>
    );
  }
}

export default Quote;
