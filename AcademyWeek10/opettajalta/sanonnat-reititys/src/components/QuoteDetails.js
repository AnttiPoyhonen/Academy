import React, { Component } from 'react';
import {Form, FormGroup, ControlLabel, ButtonGroup, Button, FormControl, HelpBlock} from 'react-bootstrap';
import { fetchone, updatequote, deletequote } from '../serviceclient';
import '../App.css';

class QuoteDetails extends Component {
  constructor(props) {
    super(props);
    const queryString = require('query-string');    
    const params = queryString.parse(props.location.search);
    const id = params['id'];
    this.state = {quote: {author: '', quotetext: '', muutettu: 0, historia:[]}, id:id};
  }
  componentDidMount() {
    this.fetchdata();
  }
  fetchdata = () => {
    fetchone(this.state.id, this.dataready);
  }
  dataready = (fetcheddata, err) => {
    this.setState({quote: fetcheddata});
  }
  handleQuoteChange = (e) => {
    var q = this.state.quote;
    q.quotetext = e.target.value;
    this.setState({ quote:q});
  }
  handleNameChange = (e) => { 
    var q = this.state.quote;
    q.author = e.target.value;
    this.setState({ quote: q});
  }  
  handleUpdateClick = (e) => {
    e.preventDefault();
    if (this.state.quote.author.length===0) {
        this.state.quote.author = 'Vanhan kansan sanonta';
        //this.setState({ quote: this.state.quote});
    }
    if(this.quoteTextValidationState()!=='error')
      updatequote(this.state.quote, this.returntolist);
  }  
  handleDeleteClick = (e) => {
    e.preventDefault();
    deletequote(this.state.id)
        .then((function(){this.returntolist()}).bind(this))
  }
  handleCancelClick = (e) => {
    e.preventDefault();
    this.returntolist();
  }
  returntolist = () => {
    this.props.history.push("/quotes");
  }
    quoteTextValidationState() {
        const length = this.state.quote.quotetext.length;
        if (length > 4) return 'success';
        else if (length > 0) return 'warning';
        else if (length >= 0) return 'error';
        return null;
    }
    authorValidationState() {
        const length = this.state.quote.author.length;
        if (length >= 1) return 'success';
        else if (length >= 0) return 'warning';
        return null;
    }
  render () {
    var historyNodes = this.state.quote.historia.map(function(historydata) {
        return (
          <DetailsHistory quote={historydata} key={historydata.id}/>
        );
    });
    return (
      <div className="quoteform">
        <Form>
          <FormGroup>
            <ControlLabel>Id</ControlLabel>
            <FormControl.Static>{this.state.quote.id}</FormControl.Static>
          </FormGroup>
          <FormGroup validationState={this.quoteTextValidationState()}>
            <ControlLabel>Sanontateksti</ControlLabel>
            <FormControl
                type="textarea"
                value={this.state.quote.quotetext}
                placeholder="Sanonta/aforismi"
                onChange={this.handleQuoteChange}
            />
            <FormControl.Feedback />
              {this.quoteTextValidationState()!=='success'&&<HelpBlock>Sanonta ei saa olla tyhjä, lyhytkään ei ole hyvä.</HelpBlock>}
          </FormGroup>
          <FormGroup>
            <ControlLabel>Sanoja</ControlLabel>
            <FormControl
                type="text"
                value={this.state.quote.author}
                placeholder="Nimi"
                onChange={this.handleNameChange}
            />
            <FormControl.Feedback />
              {this.authorValidationState()!=='success'&&<HelpBlock>Tyhjä nimi => nimeksi "Vanhan kansan sanonta"</HelpBlock>}
          </FormGroup>
            <ButtonGroup justified>
                {/* Justified ButtonGroup jossa pelkkiä Buttoneita vaatii, että jokainen Button on käärittävä oman ButtonGroupinsa sisälle..*/}
              <ButtonGroup><Button bsStyle="primary" onClick={this.handleUpdateClick} >Päivitä<span className="pull-right"><span className="glyphicon glyphicon-floppy-disk"></span></span></Button></ButtonGroup>
              <ButtonGroup><Button bsStyle="warning" onClick={this.handleDeleteClick} >Poista<span className="pull-right"><span className="glyphicon glyphicon-trash"></span></span></Button></ButtonGroup>
              <ButtonGroup><Button onClick={this.handleCancelClick} >Peruuta<span className="pull-right"><span className="glyphicon glyphicon-share-alt"></span></span></Button></ButtonGroup>
            </ButtonGroup>
          </Form>
        <h2>Historia</h2>
        <ol>
          {historyNodes}
          </ol>
      </div>
    );
  }
}

const DetailsHistory = (props) => (
    <li className="historydata">
      <p>{new Date(props.quote.muutettu).toLocaleString()}</p>
      <p>{props.quote.quotetext}</p>
      <p>{props.quote.author}</p>
      </li>
)


export default QuoteDetails;
