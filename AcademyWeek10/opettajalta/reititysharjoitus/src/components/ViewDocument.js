import React, { Component } from 'react';
import {Button} from 'react-bootstrap';
import '../App.css';

class ViewDocument extends Component {
  render() {
    return (
      <div>
        <p>Joku dokumentti #{this.props.match.params._id} voisi olla tässä</p>
        <Button onClick={()=>{this.props.history.goBack()}}>
          Takaisin
        </Button>
      </div>
    );
  }
}

export default ViewDocument;
