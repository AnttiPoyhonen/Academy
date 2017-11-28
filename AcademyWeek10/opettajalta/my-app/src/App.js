import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import Lomake from "./Lomake";
import LomakeTiedot from "./LomakeTiedot";

class App extends Component {
    lomakeTäytetty = (data) => {this.setState(data);}
  render() {
    return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <h1 className="App-title">Tervetuloa, React</h1>
        </header>
        <p className="App-intro">
          To get started, edit <code>src/App.js</code> and save to reload.
        </p>
          <hr/>
          <Lomake callback={this.lomakeTäytetty}/>
          {this.state?<LomakeTiedot hlo={this.state}/>:<LomakeTiedot/>}

      </div>
    );
  }
}

export default App;
