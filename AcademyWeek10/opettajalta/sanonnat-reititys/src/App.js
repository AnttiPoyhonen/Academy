import React, { Component } from 'react';
import {BrowserRouter as Router} from 'react-router-dom';
import './App.css';
import QuoteBox from './components/QuoteBox';

class App extends Component {
  render() {
    return (
        <Router>
          <div className="App">
            <QuoteBox/>
          </div>
        </Router>
    );
  }
}

export default App;
