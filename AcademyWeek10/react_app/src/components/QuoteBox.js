import React, {Component} from 'react';
import logo from './head.png';
import './Components_logo.css';
import QuoteList from './QuoteList';
import QuoteForm from './QuoteForm';

class QuoteBox extends Component {

    // AfList = [
    //     {id: 1, author: 'Antti', text: 'Näkemystä!'},
    //     {id: 2, author: 'Jake', text: 'Juukeli...'}
    // ];

    // init state with the array of quotes
    state = {
        AfList:
            [
                {id: 1, author: 'Antti', text: 'Näkemystä!'},
                {id: 2, author: 'Jake', text: 'Juukeli...'}
            ]
    }

    // to add a new item to the array (while adding a new id for it)
    addToList = (af) => {
        // console.log(af);
        // console.dir(this.state.AfList);

        var lastAf = this.state.AfList[this.state.AfList.length - 1];
        var nextId = lastAf.id + 1;

        af.id = nextId;
        this.state.AfList.push(af);

        this.setState(this.state);
    }

    // to delete an item from the array
    deleteFromList = (id) => {

        // console.log('to delete id: ' + id);

        //copy array to a variable
        var newData = this.state.AfList.slice();

        // loop through the array
        {for (var i = 0; i < this.state.AfList.length; i++) {
            // remove element from array if id is found
            if (this.state.AfList[i].id === id) newData.splice(i, 1);
        }}

        // update the data back to state
        this.setState({AfList: newData});
    }

    render() {

        // this adds the function call to each array item
        // unnecessary if passed as props down to QuoteList and Quote Components
        {for (var i = 0; i < this.state.AfList.length; i++) {
            this.state.AfList[i].deleteAf = this.deleteFromList;
        }}

        return (

            <div className="QuoteBox">

                <header className="App-header">
                    <img src={logo} className="App-logo" alt="logo"/>
                    <h1 className="App-title">using React to Aforism :)</h1>
                </header>

                <br/>
                <hr/>
                <br/>

                <QuoteForm createAf={this.addToList} />

                <br/>
                <hr/>
                <br/>

                <QuoteList aflist={this.state.AfList} deleteAf={this.deleteFromList} />

            </div>

        );
    }
}

export default QuoteBox;