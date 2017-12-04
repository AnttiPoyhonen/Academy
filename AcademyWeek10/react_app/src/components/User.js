import React, {Component} from 'react';

class User extends Component {

    render() {

        return(
            <li>
                ID {this.props.user.id}: {this.props.user.name} - {this.props.user.email}
            </li>
        )

    }

}

export default User;