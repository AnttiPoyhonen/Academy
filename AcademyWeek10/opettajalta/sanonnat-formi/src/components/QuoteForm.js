import React, { Component } from 'react';
import '../App.css';
import './QuoteForm.css';

class QuoteForm extends Component {
    constructor(props) {
        super(props);
        this.state = { quotetext: '', author: '', formErrors: { text: '', author: '' } }
    }
    handleQuoteChange = (e) => { this.setState({ quotetext: e.target.value }) }
    handleNameChange = (e) => { this.setState({ author: e.target.value }) }
    handleCreateClick = (e) => {
        e.preventDefault();
        var formok = true;
        var auerr = '', terr = '';
        if (this.state.quotetext.length === 0) {
            formok = false;
            terr = 'Tyhjä teksti';
        }
        if (this.state.author.length === 0) {
            formok = false;
            auerr = 'Tyhjä sanoja';
        }
        if (!formok) {
            this.setState({formErrors: {text: terr, author: auerr}});
            return false;
        } else {
            this.props.callback(this.state);
            this.setState({ quotetext: '', author: '', formErrors: { text: '', author: '' } });
        }
    }
    render() {
        return (
            <div className="quoteform">
                <form className="form-horizontal">
                    <div  className="form-group">
                        <label htmlFor="form_quotetext" className="control-label col-sm-2">Sanontateksti</label>
                        <div className="col-sm-10">
                        <textarea type="text" placeholder="quote" id="form_quotetext" minLength="3"
                                  value={this.state.quotetext} onChange={this.handleQuoteChange} className="form-control"
                                  required="required"></textarea></div>
                    </div>
                    <div  className="form-group">
                        <label htmlFor="form_author" className="control-label col-sm-2">Henkilö</label>
                        <div className="col-sm-10">
                        <input type="text" placeholder="Name" id="form_author" minLength="1" className="form-control"
                               value={this.state.author} onChange={this.handleNameChange} /></div>
                    </div>
                    <div className="form-group">
                        <input type="submit" value="Create" onClick={this.handleCreateClick} className="form-control btn-primary" />
                    </div>
                </form>
                <div>
                    <FormErrors formErrors={this.state.formErrors} />
                </div>
            </div>
        );
    }
}

const FormErrors = ({ formErrors }) =>
    <div className='formerrors'>
        {Object.keys(formErrors).map((fieldName, i) => {
            if (formErrors[fieldName].length > 0) {
                return (
                    <p key={i}>{fieldName} {formErrors[fieldName]}</p>
                )
            } else {
                return '';
            }
        })}
    </div>


export default QuoteForm;
