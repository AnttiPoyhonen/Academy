import React, { Component } from 'react';
import './QuoteBox.css';
import QuoteList from './QuoteList';
import QuoteForm from './QuoteForm';
import {fetchall, createquote, deletequote} from "../serviceclient";

class QuoteBox extends Component {
    constructor(props) {
        super(props);
        this.state = {data: []};
    }
    componentDidMount () {
        this.haekaikki();
    }
    haekaikki() {
        fetchall(this.kaikkihaettu);
    }
    kaikkihaettu = (sanonnat, virhe) => {
        if(virhe) {
            // virhekäsittely
        } else {
            this.setState({data: sanonnat});
        }
    }

    quotecreated = (nq) => {
        createquote(nq, this.luontivalmis)
    }

    luontivalmis = () => {
        this.haekaikki();
    }

    deletoisanonta = (id) => {
        deletequote(id).then((function(){
            this.haekaikki();
        }).bind(this));
    }
  render() {
    return (
      <div className="quotebox">
          <h1 style={{color: 'green'}} >Sanonnat</h1>
          <QuoteForm callback={this.quotecreated}/>
          <QuoteList sanonnat={this.state.data} deletefunc={this.deletoisanonta}/>
      </div>
    );
  }
}
export default QuoteBox;
