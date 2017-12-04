import React, {Component} from 'react';
import logo from './head.png';
import './Components_logo.css';
import QuoteList from './QuoteList';
import QuoteForm from './QuoteForm';
import QuoteMod from './QuoteMod';

class QuoteBox extends Component {

    // init state with the array of quotes
    // state = {
    //     AfList:
    //         [
    //             {id: 1, author: 'Antti', text: 'Näkemystä!'},
    //             {id: 2, author: 'Jake', text: 'Juukeli...'}
    //         ]
    // }

    // // to add a new item to the array (while adding a new id for it)
    // addToList = (af) => {
    //     // console.log(af);
    //     // console.dir(this.state.AfList);
    //
    //     var lastAf = this.state.AfList[this.state.AfList.length - 1];
    //     var nextId = lastAf.id + 1;
    //
    //     af.id = nextId;
    //     this.state.AfList.push(af);
    //
    //     this.setState(this.state);
    // }
    //
    // // to delete an item from the array
    // deleteFromList = (id) => {
    //
    //     // console.log('to delete id: ' + id);
    //
    //     //copy array to a variable
    //     var newData = this.state.AfList.slice();
    //
    //     // loop through the array
    //     {for (var i = 0; i < this.state.AfList.length; i++) {
    //         // remove element from array if id is found
    //         if (this.state.AfList[i].id === id) newData.splice(i, 1);
    //     }}
    //
    //     // update the data back to state
    //     this.setState({AfList: newData});
    // }

    state = {AfList: null};

    componentDidMount = () => {

        var that = this;

        fetch('/af', {method: 'GET'}).then(function (response) {
            if (response.ok) {
                return response.json();
            }
            throw new Error('Something went wrong!');
        }).then(function (data) {
            that.setState({AfList: data});
        })
    }

    // componentDidUpdate = () => {
    //
    //     var that = this;
    //
    //     fetch('/af').then(function (response) {
    //         if (response.ok) {
    //             return response.json();
    //         }
    //         console.log('Something went wrong!');
    //     }).then(function (data) {
    //         that.setState({AfList: data});
    //     })
    // }

    updateFetch = () => {

        var that = this;

        fetch('/af').then(function (response) {
            if (response.ok) {
                return response.json();
            }
            console.log('Something went wrong!');
        }).then(function (data) {
            that.setState({AfList: data});
        });

    }

    addToFetch = (af) => {

        var FormData = require('form-data');
        var form = new FormData();
        form.set('text', af.text);
        form.set('author', af.author);

        var that = this;

        fetch('/af', {
            method: 'POST', body: form
        })
            .then(function (response) {
                console.log(response);
                if ('Created' === response.statusText) {
                    console.log('POST successful!');
                    that.updateFetch();
                }
                else console.log('POST failed!');
            });
    }

    updateToFetch = (af) => {

        // FormData does not get passed properly
        var FormData = require('form-data');
        var form = new FormData();
        form.set('id', af.modId);
        form.set('text', af.modText);
        form.set('author', af.modAuthor);

        var url = '/af?id=' + af.modId + '&author=' + af.modAuthor + '&text=' + af.modText;

        console.log(form);
        console.log(af.modId + ": " + af.modAuthor + " - " + af.modText);

        var that = this;

        fetch(url, {
            method: 'PUT', body: form
        })
            .then(function (response) {
                console.log(response);
                if ('Created' === response.statusText) {
                    console.log('PUT successful!');
                    that.updateFetch();
                }
                else console.log('PUT failed!');
            });
    };

    deleteFromFetch = (id) => {

        var url = '/af?id=' + id;

        var that = this;

        fetch(url, {method: 'DELETE'})
            .then(function (response) {
                console.log(response);
                if ('OK' === response.statusText) {
                    console.log('DELETE successful!');
                    that.updateFetch();
                }
                else console.log('DELETE failed!');
            });

    }

    render() {

        // this adds the function call to each array item
        // unnecessary if passed as props down to QuoteList and Quote Components
        if (this.state.AfList != null) {
            for (var i = 0; i < this.state.AfList.length; i++) {
                this.state.AfList[i].deleteAf = this.deleteFromList;
            }
        }

        return (

            <div className="QuoteBox">

                <header className="App-header">
                    <img src={logo} className="App-logo" alt="logo"/>
                    <h1 style={{marginLeft: '3%', display: 'inline', fontSize: '230%'}} className="App-title">
                        using React to Aforism :)</h1>
                </header>

                <br/>

                <form style={{width: '40%', margin: '0% 5%'}}>
                    < QuoteForm createAf={this.addToFetch} />
                    < QuoteMod mod={this.singleFetch} update={this.updateToFetch} af={this.state.af} />
                </form>

                <br/>

                <QuoteList aflist={this.state.AfList} deleteAf={this.deleteFromFetch}/>

                <br/>


            </div>

        );
    }
}

export default QuoteBox;