import React, {Component} from 'react';
import {BrowserRouter as Router, Switch, Route, Link} from 'react-router-dom';
import './App.css';
import HomePage from './Home-Page'
import LoginPage from './Login-Page'
import SecurePage from "./Secure-Page";
import UserPage from "./User-Page";

interface IState {
    loggedIn: boolean
}

class App extends Component {

    state: IState = {
        loggedIn: false
    }

    render() {
        return (
            <div className="App">
                <Router>
                    <div>
                        <nav className="navbar navbar-expand-lg navbar-light bg-light">

                            <ul className="navbar-nav mr-auto">

                                <li><Link to={'/'} className="nav-link"> Home </Link></li>
                                {this.state.loggedIn &&
                                    <li><Link to={'/user'} className="nav-link"> My Account </Link></li>
                                }
                                {this.state.loggedIn ? (
                                    <li><Link to={'/data'} className="nav-link"> Customer Data </Link></li>
                                ) : (
                                    <li><Link to={'/login'} className="nav-link"> Login </Link></li>
                                )
                                }
                            </ul>
                        </nav>


                        <hr/>

                        <Switch>
                            <Route exact path='/' component={HomePage}/>
                            <Route exact path='/user' component={UserPage}/>
                            <Route exact path='/data' component={SecurePage}/>
                            <Route exact path='/login' component={LoginPage}/>
                            <Route exact path='/register' component={HomePage}/>

                        </Switch>
                    </div>
                </Router>
            </div>
        );
    }
}

export default App;
