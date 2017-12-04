import React, { Component } from 'react';
import './Quote.css';


class Quote extends Component {
    deletequote = (e) => {
        e.preventDefault();
        console.dir(this.props);
        this.props.deletecb(this.props.sanonta.id);
    }
    render() {
    return (
        <ul className="quote">
            <li className="quotetext">{this.props.sanonta.quotetext}
                <div className="dlink" onClick={this.deletequote}>
                    (<a title="delete" href="#">Delete {this.props.sanonta.id} <span className="glyphicon glyphicon-trash"></span></a>)
                </div></li>
            <li className="quoteauthor">{this.props.sanonta.author}</li>
        </ul>
    );
  }
}

export default Quote;
