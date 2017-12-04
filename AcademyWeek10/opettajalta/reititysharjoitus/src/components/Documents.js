import React, { Component } from 'react';
import {Button, FormGroup, ControlLabel, FormControl, Form} from 'react-bootstrap';
import '../App.css';

class Documents extends Component {
  state = {value: ''}
  tekstiVaihtunut = (e) => {
    this.setState({value: e.target.value});
  }
  siirry = (e) => {
    e.preventDefault();
    this.props.history.push('/documents/'+this.state.value);
  }
  render() {
    return (
      <div className="Docs">
        <p>Siirrytään detaljeihin, eli teksti tästä "hakee" ViewDocument komponentin kenttään syötetyn "id": perusteella</p>
        <Form inline>
          <FormGroup>
            <ControlLabel>Id (numero/teksti)</ControlLabel>
            <FormControl
                type="text"
                value={this.state.value}
                placeholder="Syötä id/text"
                onChange={this.tekstiVaihtunut}
            />
          </FormGroup>
          <Button onClick={this.siirry}>Hae</Button>
          </Form>
      </div>
    );
  }
}

export default Documents;
