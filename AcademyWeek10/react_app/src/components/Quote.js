import React, { Component } from 'react';

// function Quote (props) {

class Quote extends Component {

    // handler for delete-button to call the attached-to-each-quote delete function-callback-to-QuoteBox
    // deleteAf = () => {
    //     this.props.quote.deleteAf(this.props.quote.id);
    // }

    // another option would be to call the passed props-delete-function
    deleteAf = () => {
        this.props.deleteAf(this.props.quote.id);
    }

    render() {

        // without delete button, pure info
        // return (
        //     <li>
        //          ID {this.props.quote.id}: {this.props.quote.author} - <i>{this.props.quote.text}</i>
        //     </li>
        // );

        // console.log(this.props.deleteAf);

        return (
            <li>
                <button onClick={this.deleteAf}>Del</button> ID {this.props.quote.id}: {this.props.quote.author} - <i>{this.props.quote.text}</i>
            </li>
        );

    }
}

export default Quote;