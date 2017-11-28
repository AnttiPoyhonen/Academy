import React from 'react';

class HloLomake extends React.Component() {
    render() {

        handleCreateClick = (e) => {
            e.preventDefault(); // Ei lähetetä formia palvelimelle
            this.props.addperson(this.state); // Muutos tällä rivillä
            var newid = this.state.id + 1;
            this.setState({id: newid, name: '', email: ''});
        }

        return {
            <form>
                <input type="text" placeholder="FirstName"
                       value={this.state.firstname} onChange={this.handleFirstNameChange}/>
                <input type="text" placeholder="LastName"
                       value={this.state.lastname} onChange={this.handleLastNameChange}/>
                <input type="text" placeholder="Alias"
                       value={this.state.nimimerkki} onChange={this.handleAliasChange}/>
                <input type="submit" value="Update" onClick={this.handleCreateClick}/>
            </form>
        }
    }
}

export default HloLomake;
