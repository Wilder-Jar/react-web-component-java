import React, { Component } from 'react';
import FormRegister from "./assets/Form-Register";

class RegisterPage extends Component {
    constructor(props: any) {
        super(props);
    }

    render() {
        return (
            <div>
                <h2>Register!</h2>
                <FormRegister/>
            </div>
        );
    }
}

export default RegisterPage;