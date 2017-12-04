import React, { Component } from 'react';
import './QuoteList.css';
import Quote from "./Quote";


class QuoteList extends Component {
  render() {
      var callback=this.props.deletefunc;
      var sanontaoliot = this.props.sanonnat.sort(function(s1, s2){
                  var s1suku = s1.author.split(" ").slice(-1)[0];
                  var s2suku = s2.author.split(" ").slice(-1)[0];
                  if (s1suku === s2suku) return 0;
                  if (s1suku > s2suku) return 1;
                  return -1;
            }).map(function(sanonta){
                return <Quote deletecb={callback} sanonta={sanonta} key={sanonta.id} className="list-group-item"/>
        });
    return (
      <div className="quotelist">
        <ul className="list-group">
          {sanontaoliot}
        </ul>
      </div>
    );
  }
}

export default QuoteList;
