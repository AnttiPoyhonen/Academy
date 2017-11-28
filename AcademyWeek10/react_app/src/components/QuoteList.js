import React, { Component } from 'react';
import Quote from './Quote.js';
import './Components.css';

// function QuoteList (props) {

class QuoteList extends Component {

    render() {

        // temporary var to link the props to a call inside the mapping afterwards
        // a way to pass the props to the mapping objects as props
        var deleteTemp = this.props.deleteAf;

        // Function to transform aforism list to Quote objects (as <li> list items)
        var list = this.props.aflist.map(function(quote, index) {
            return (
                <Quote quote = {quote} deleteAf = {deleteTemp} key = {index}/>
            )
        });

        // return to format the list itself
        return (
            <ul className="unstyled">
                {list}
            </ul>
        );
    }
}

export default QuoteList;