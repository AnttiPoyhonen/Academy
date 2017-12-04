import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';

const Maa = (props) => (
    <tr>
        <td>{props.tiedot.name}</td>
        <td>{props.tiedot.population}</td>
        <td>{props.tiedot.capital&&props.tiedot.capital.name}</td>
    </tr>
);
// voisi toteuttaa myös class toteutuksena
class Maa2 extends Component {
    render() {
        return (
            <tr>
                <td>{this.props.tiedot.name}</td>
                <td>{this.props.tiedot.population}</td>
            </tr>
        );
    }
}

class App extends Component {
    state = {data: []}
    componentDidMount() {
        var minäitse = this;
        fetch('/api/maat')
            .then(function(response) {
                return response.json();
            })
            .then((function(jsonolio) {
                // var maan_nimi = jsonolio[0].name;
                this.setState({data: jsonolio});
            }).bind(this));
    }
    render() {
        var maat = this.state.data.map(function(maa){
            return (<Maa tiedot={maa} key={maa.code}/>);
        });
        return (
          <div className="App">
                {/*this.state.data? this.state.data[0].name : 'ei vielä haettu'*/}
                <table>
                    <tbody>
                    {maat}
                    </tbody>
                </table>
          </div>
        );
  }
}


export default App;
