import React, { Component } from 'react';
import './QuoteList.css';
import Quote from "./Quote";


class QuoteList extends Component {
  render() {
    var sanontaoliot = this.props.sanonnat.map(function(sanonta){
      return <Quote sanonta={sanonta} key={sanonta.id}/>
    });
    return (
      <div className="quotelist">
        <ul>
          {sanontaoliot}
        </ul>
      </div>
    );
  }
}

export default QuoteList;
