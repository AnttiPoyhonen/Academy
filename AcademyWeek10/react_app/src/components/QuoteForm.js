import React, {Component} from 'react';

class QuoteForm extends Component {

    // handlers to handle input fields in the form / update the field values
    // as React handles their value at the moment!

    handleTextChange = (e) => {
        this.setState({text: e.target.value});
    };

    handleAuthorChange = (e) => {
        this.setState({author: e.target.value});
    };

    // handler to handle creation of a new quote and call the prop create-function
    // as well as empty the field values for further input
    handleCreateAforism = (e) => {
        e.preventDefault();
        this.props.createAf(this.state);
        this.setState({author: '', text: ''});
    };

    // original init of the field values via state
    state = {author: '', text: ''}

    render() {

        // to render the form
        return (

            <form style={{width: '40%', margin: '0% 5%'}}>
                <fieldset>

                    <legend>Add an Aforism</legend>

                    <table>
                        <tbody>

                        <tr>
                            <td style={{width: '5%'}}><label htmlFor="form_author">Sanoja</label></td>
                            <td style={{width: '10%'}}><input type="text" placeholder="Author" id="form_author"
                                       value={this.state.author} onChange={this.handleAuthorChange}/></td>
                        </tr>

                        <tr>
                            <td><label htmlFor="form_text">Sanonta</label></td>
                            <td><textarea type="text" placeholder="Text" id="form_text"
                                          value={this.state.text} onChange={this.handleTextChange}
                                          required="required"></textarea></td>
                        </tr>

                        <tr>
                            <td></td>
                            <td><input type="submit" value="Create Aforism" onClick={this.handleCreateAforism}/></td>
                        </tr>

                        </tbody>
                    </table>
                </fieldset>
            </form>

        );
    }
}

export default QuoteForm;
