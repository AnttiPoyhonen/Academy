import React, {Component} from 'react';
import User from './User';

class Users extends Component {

    // state = {users: []};
    //
    // componentDidMount = () => {
    //     this.xhr = new XMLHttpRequest();
    //     this.xhr.onreadystatechange = this.onReadyStateChanged;
    //     this.xhr.open('GET', 'user/all', true);
    //     this.xhr.send();
    // }
    //
    // onReadyStateChanged = () => {
    //     if (this.xhr.readyState == 4 && this.xhr.status == 200) {
    //         this.setState({users: JSON.parse(this.xhr.responseText)});
    //     }
    // }
    //
    // render() {
    //
    //     var list = this.state.users.map(function(user, index) {
    //         return (
    //             < User user = {user} key = {index} />
    //         )
    //     });
    //
    //     console.dir(this.state.users);
    //
    //     return (
    //         <ul style={{listStyle: 'none'}}>
    //             {list}
    //         </ul>
    //     );
    //
    // }

    render() {return(<div></div>);}

}

export default Users;