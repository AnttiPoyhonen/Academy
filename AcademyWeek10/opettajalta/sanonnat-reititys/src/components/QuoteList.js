import React, { Component } from 'react';
import './QuoteList.css';
import Quote from "./Quote";
import {ListGroup} from 'react-bootstrap';
import { fetchall} from '../serviceclient';


class QuoteList extends Component {
    state = {data: []}
    componentDidMount() {
        this.haedata();
    }
    haedata = () => {
        fetchall((function (sanonnat, virhe) {
            this.setState({data: sanonnat});
        }).bind(this));
    }
  render() {
      var props = this.props;
      var sanontaoliot = this.state.data.sort(function(s1, s2){
                  var s1suku = s1.author.split(" ").slice(-1)[0];
                  var s2suku = s2.author.split(" ").slice(-1)[0];
                  if (s1suku === s2suku) return 0;
                  if (s1suku > s2suku) return 1;
                  return -1;
            }).map(function(sanonta){
                return <Quote sanonta={sanonta} key={sanonta.id} className="list-group-item" {...props}/>
        });
    return (
      <div className="quotelist">
          <h1>Sanonnat</h1>
          {this.state.data.length > 0 ?
              (<ListGroup>
                  {sanontaoliot}
              </ListGroup>)
              : (<p>Ei sanontoja, luo uusi tai resetoi kotisivulta..</p>)
          }
      </div>
    );
  }
}

export default QuoteList;
