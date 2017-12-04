import React, { Component } from 'react';

class QuoteMod extends Component {

    singleFetch = (id) => {

        var that = this;

        var url = '/af/' + id;

        fetch(url).then(res => {
            if (res.ok) {
                return res.json();
            }
            else console.log('Something went wrong!');
        }).then(d => {
            if(d[0] == null) return;
            that.setState({modText: d[0].text, modAuthor: d[0].author});
        })
    };

    handleModIdChange = (e) => {
        this.setState({modId: e.target.value});
    };

    handleChoice = (e) => {
        e.preventDefault();
        this.setState({idForUpdate: this.state.modId});
        this.singleFetch(this.state.modId);
    };

    handleModTextChange = (e) => {
        this.setState({modText: e.target.value});
    };

    handleModAuthorChange = (e) => {
        this.setState({modAuthor: e.target.value});
    };

    handleUpdate = (e) => {
        e.preventDefault();
        this.props.update(this.state);
        this.setState({modAuthor: '', modText: '', modId: ''});
    };

    state = {modId: '', modAuthor: '', modText: ''};

    render() {

        return (

                <fieldset>

                    <legend>Modify Aforism</legend>

                    <table>
                        <tbody>

                        <tr>
                            <td style={{width: '10%'}}><label htmlFor="mod_id">ID</label></td>
                            <td style={{width: '10%'}}><input type="text" placeholder="ID" id="mod_id"
                                                              value={this.state.modId} onChange={this.handleModIdChange}/></td>
                            <td style={{width: '5%'}}><input type="submit" value="Choose Aforism" onClick={this.handleChoice}/></td>
                        </tr>

                        <tr>
                            <td><label htmlFor="mod_author">Author</label></td>
                            <td colSpan="2"><input type="text" placeholder="Author" id="mod_author"
                                                              value={this.state.modAuthor} onChange={this.handleModAuthorChange}/></td>
                        </tr>

                        <tr>
                            <td><label htmlFor="mod_text">Quote</label></td>
                            <td colSpan="2" ><textarea type="text" placeholder="Text" id="mod_text"
                                          value={this.state.modText} onChange={this.handleModTextChange}></textarea></td>
                            <td></td>
                        </tr>

                        <tr>
                            <td></td>
                            <td><input type="submit" value="Update Aforism" onClick={this.handleUpdate}/></td>
                        </tr>

                        </tbody>
                    </table>
                </fieldset>

        );
    }
}

export default QuoteMod;