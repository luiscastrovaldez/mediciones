import React, { Component } from 'react';
import LoginRow from './LoginRow';

import Restablecer from '../login/Restablecer';
import Register from '../login/Register';

import Reflux from 'reflux';

import AppStore from '../../stores/AppStore';
import Actions from '../../actions/Actions';
import { Link, Redirect } from 'react-router-dom';



import {
  BrowserRouter as Router,
  Route
} from 'react-router-dom'

class Login extends Reflux.Component {

  constructor(){
    super();
    this.state = {};
    this.store = AppStore;
    this.state = {
      errorUsuario:'',
      errorPassword:'',
      isLogged: false
    }
    this.onClickLogIn = this.onClickLogIn.bind(this);
    this.onSubmit = this.onSubmit.bind(this);
  }

  onClickLogIn(e){
    this.setState({errorUsuario:''});
    this.setState({errorPassword:''});

    let  username = this.refs.username.getValue();
    let  password = this.refs.password.getValue();
    if (username == ''){
      this.setState({errorUsuario:'Usuario obligatorio'});
    } else if (password == ''){
      this.setState({errorPassword:'Password obligatorio'});
    }
  }



  onSubmit(e){
    e.preventDefault();
    console.log(this.refs.username.getValue());
    console.log(this.refs.password.getValue());
    Actions.postLogIn(this.refs.username.getValue(),this.refs.password.getValue());
  }


  render(){
      return(
        <div>

          {this.state.isLogged ? <Redirect to="/menu"/> :
          <center>
          <font color="red"> {this.state.message} </font>
          <form onSubmit={ this.onSubmit }>
              <label>Inicio de Sesión</label>
              <LoginRow id="username" inputType="text" placeholder="Nombre de Usuario" isRequired={true} ref="username"/>
                <font color="red"> {this.state.errorUsuario} </font>
              <LoginRow id="password" inputType="password" isRequired={true} placeholder="Clave" ref="password"/>
                <font color="red"> {this.state.errorPassword} </font>
              <br></br>
              <button className="btn btn-primary" onClick={this.onClickLogIn} color="primary">Ingresar</button>
          </form>
            <Link to="/register" >Nuevo Usuario</Link>
            <br></br>
            <Link to="/restablecer" >Restablecer Contraseña</Link>
            </center>
          }

        </div>
      );
  }
}

export default Login;
