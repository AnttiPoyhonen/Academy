import React, { Component } from 'react';
import { Jumbotron } from 'react-bootstrap';
import {resetdata, deleteall} from '../serviceclient';

class Home extends Component {
    resetdata = (e) => {
        e.preventDefault();
        resetdata(this.donedeal);
    }
    deletedata = (e) => {
        e.preventDefault();
        deleteall(this.donedeal);
    }
    donedeal = (msg) => {
        var detail = msg ? '\n' + JSON.stringify(msg) : '';
        window.alert("Done!"+detail);
    }
    render() {
        return (
            <div>
                <Jumbotron style={{textAlign: 'center'}}>
                    <h1>Sanonta-harjoitus</h1>
                    <p>Lopullinen versio</p>
                </Jumbotron>
                <p>Sanonta-harjoitus reititys toteutettuna</p>
                <div>Tämä on ratkaisu sanontaharjoituksen viimeiseen osaan. Tässä toteutettuna siis
                    <ul>
                        <li>Projekti <code>create-react-app</code> työkalulla</li>
                        <li>Custom React komponetteja, mm. sanontojen listaus</li>
                        <li>Lomake, jolla voi luoda uusia sanontoja</li>
                        <li>Sanontojen haku ja talletus Java-palvelimelle REST-apia käyttäen</li>
                        <li>Monisivuinen toteutus <code>react-router</code>in avulla</li>
                        <li>Sivujen ulkoasua parannettu <code>react-bootstrap</code>-kirjastolla</li>
                    </ul>
                </div>
                <p>Alla pari linkkiä testailua varten. Projektin mukana tuleva Spring Boot palvelin tyhjentää
                tietokannan aina kun palvelin käynnistetään uudelleen.</p>
                <ul>
                    <li><a href="Reset" onClick={this.resetdata}>Resetoi sanonnat alkutilanteeseen</a></li>
                    <li><a href="Delete all" onClick={this.deletedata}>Poista kaikki sanonnat</a></li>
                </ul>
            </div>
        );
    }
}

export default Home;
