import React, {Component} from 'react';
import {Link} from "react-router-dom";
import Axios from "axios";

interface IState {
    username: string,
    password: string
}

interface IUserCredentials {
    username: string,
    password: string
}

export default class FormLogin extends Component {
    constructor(props: {}) {
        super(props);
        this.handleSubmit = this.handleSubmit.bind(this);
        this.onUserChange = this.onUserChange.bind(this);
        this.onPassChange = this.onPassChange.bind(this);
        console.log("Test");

    }

    state: IState = {
        username: "",
        password: ""
    }

    handleSubmit(event: React.FormEvent<HTMLFormElement>) {
        event.preventDefault()
        // console.log(this.state.password);
        const login = async () => {

            let bodyFormData: FormData = new FormData();
            bodyFormData.set('username', this.state.username);
            bodyFormData.set('password', this.state.password);

            Axios.post('/api/login', bodyFormData)
                .then(function (response){
                    getUsername();
                })
                .catch(function (error) {
                    console.log(error);
                });

        };

        const getUsername = async () => {
            Axios.get('/api/user/name')
                .then(function (response){
                    console.log(response.data);

                })
                .catch(function (response){
                    console.log(response);
                })
                .finally(function (){
                    window.location.replace("/");
                });

        }

        login();

    }

    onUserChange(event: React.FormEvent<HTMLInputElement>) {
        const {name, value}: any = event.target;
        this.setState({username: value});
        console.log(value);

    }

    onPassChange(event: React.FormEvent<HTMLInputElement>) {
        const {name, value}: any = event.target;
        this.setState({password: value});
        console.log(value);

    }

    render() {
        return <div>
            <form onSubmit={this.handleSubmit}>
                <label>
                    Username:
                    <input type="text" name="username" onChange={this.onUserChange}/>
                </label>
                <label>
                    Password:
                    <input type="password" name="password" onChange={this.onPassChange}/>
                </label>
                <input type="submit" value="Submit"/>
            </form>
        </div>
    }
}
