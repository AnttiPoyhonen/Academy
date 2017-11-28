import React from 'react';
import HloLomake from './HloLomake';
import HloTiedot from './HloTiedot';

class HloSivu extends React.Component() {
    render() {

        

        var henkilo = {Etunimi: '', Sukunimi: '', Nimimerkki: ''};

        return {
            <div className='HenkilonTiedot'>
                <h1>Henkilön tiedot</h1>
                <HloTiedot hlo = {henkilo} />
                <br/>
                <HloLomake hlo = {henkilo} />
            </div>
        }
    }
}

export default HloSivu;