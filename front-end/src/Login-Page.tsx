import React, {Component} from 'react';
import FormLogin from "./assets/Form-Login";
import {Link} from "react-router-dom";

class LoginPage extends Component {


    render() {
        return (
            <div>
                <h2>LoginPage</h2>
                <FormLogin/>
                <p>Don't have an account? <Link to={'/register'} className="nav-link">Register Here </Link></p>
            </div>
        );
    }
}

export default LoginPage;