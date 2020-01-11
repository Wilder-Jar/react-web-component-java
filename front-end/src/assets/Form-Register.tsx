import React, {Component} from "react";
import Axios, {AxiosResponse} from "axios";

interface IUser {
    username: string,
    password: string,
    email: string
}

interface IRegistrationResponse {
    success: boolean,
    type: string,
    message: string
}

export default class FormRegister extends Component {
    constructor(props: any) {
        super(props);
        this.onChange = this.onChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this)
    }

    state: IUser = {
        email: "",
        password: "",
        username: ""
    }

    handleSubmit(event: React.FormEvent<HTMLFormElement>) {
        event.preventDefault()
        const registerAccount = async () => {
            Axios.post('/api/user/register', this.state)
                .then(function (response: AxiosResponse<IRegistrationResponse>){
                    console.log(response);
                })
                .catch(function (error){
                    console.log(error);
                });
        }

        registerAccount();
    }

    onChange(event: React.FormEvent<HTMLInputElement>) {
        const {name, value}: any = event.target;

        switch (name) {
            case 'username':
                this.setState({
                    username: value
                });
                break;
            case 'password':
                this.setState({
                    password: value
                });
                break;
            case 'email':
                this.setState({
                    email: value
                });
                break;
        }
    }


    render() {
        return <div>
            <form onSubmit={this.handleSubmit}>
                <label>
                    Email: <input type="text" name="email" onChange={this.onChange}/>
                </label>
                <label>
                    Username: <input type="text" name="username" onChange={this.onChange}/>
                </label>
                <label>
                    Password: <input type="password" name="password" onChange={this.onChange}/>
                </label>
                <input type="submit" value="Submit"/>
            </form>
        </div>
    }
}