import React, {Component} from 'react';
import './Lomake.css';

class Lomake extends Component {
    state = {etunimi: '', sukunimi: ''};
    btnKlikattu = (e) => {
        e.preventDefault();
        if (this.props.callback) {
            this.props.callback(this.state);
        }
        this.setState({etunimi: '', sukunimi: ''});
    }
    etuNimiMuuttunut = (e) => {this.setState({etunimi:e.target.value})}
    sukuNimiMuuttunut = (e) => {this.setState({sukunimi: e.target.value})}
    render() {
        return(
            <form className="lomakeosa form-horizontal">
                <fieldset>
                    <legend>Henkilölomake</legend>
                    <div className="form-group">
                        <label htmlFor="etunimi" className="control-label col-sm-2">Etunimi: </label>
                        <div className="col-sm-10">
                            <input value={this.state.etunimi} onChange={this.etuNimiMuuttunut} className="form-control" id="etunimi"/>
                        </div>
                    </div>
                    <div className="form-group">
                        <label htmlFor="sukunimi" className="control-label col-sm-2">Sukunimi: </label>
                        <div className="col-sm-10">
                            <input value={this.state.sukunimi} onChange={this.sukuNimiMuuttunut} id="sukunimi" className="form-control" />
                        </div>
                    </div>
                    <div className="form-group">
                        <input type="submit" onClick={this.btnKlikattu} defaultValue="Käsittele" className="form-control btn-primary"/>
                    </div>
                </fieldset>
            </form>
        );
    }
}

export default Lomake;