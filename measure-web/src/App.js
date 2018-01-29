import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';

import Login from './components/login/Login';
import Register from './components/login/Register';
import Restablecer from './components/login/Restablecer';
import Menu from './components/menu/Menu';
import Home from './components/views/Home';

import {
  BrowserRouter as Router,
  Route
} from 'react-router-dom'

class App extends Component {
  render() {
    return (
      <Router>
          <div>
          <header className="App-header">
            <img src={logo} className="App-logo" alt="logo" />
            <h1 className="App-title">Sistema de Mediciones</h1>
          </header>
            <Route exact path="/" component={Login}/>
            <Route path="/menu" component={Menu}/>
            <Route path="/register" component={Register}/>
            <Route path="/restablecer" component={Restablecer}/>
          </div>
        </Router>
    );
  }
}

export default App;
