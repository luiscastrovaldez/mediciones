import React, { Component } from 'react';
import LoginRow from './LoginRow';

import AppStore from '../../stores/AppStore';
import Actions from '../../actions/Actions';
import { Link, Redirect } from 'react-router-dom';
import Reflux from 'reflux';

class Register extends Reflux.Component{

  constructor(){
    super();
    this.state = {};
    this.store = AppStore;
    this.state = {
      errorEmail:'',
      errorUser:'',
      errorPassword:'',
      isLogged: false
    }
    this.onSubmit = this.onSubmit.bind(this);
    this.onClickNew = this.onClickNew.bind(this);
  }

  onSubmit(e){
    e.preventDefault();
    Actions.createUser(this.refs.username.getValue(),this.refs.password.getValue(),this.refs.email.getValue());
  }

  onClickNew(e){

    this.setState({errorEmail:''});
    this.setState({errorUser:''});
    this.setState({errorPassword:''});

    let  username = this.refs.username.getValue();
    let  password = this.refs.password.getValue();
    let  email = this.refs.email.getValue();

    if (username == ''){
      this.setState({errorUser:'Campo obligatorio'});
    }

    if (password == ''){
      this.setState({errorPassword:'Campo obligatorio'});
    }

    if (email == ''){
      this.setState({errorEmail:'Campo obligatorio'});
    }
  }


  render(){
      return(
        <div>
          {this.state.isLogged ? <Redirect to="/menu"/> :
          <center>
            <font color="red"> {this.state.message} </font>
            <form onSubmit={ this.onSubmit }>
              <label>Nuevo Usuario</label>

              <LoginRow id="username" inputType="text" placeholder="Nombre de Usuario" isRequired={true} ref="username"/>
                <font color="red"> {this.state.errorUser} </font>
              <br></br>

              <LoginRow id="password" inputType="password" placeholder="Clave" isRequired={true} ref="password"/>
                <font color="red"> {this.state.errorPassword} </font>
              <br></br>

              <LoginRow id="email" inputType="email" placeholder="Correo" isRequired={true} ref="email"/>
                <font color="red"> {this.state.errorEmail} </font>
              <br></br>
              <button className="btn btn-primary" onClick={this.onClickNew}>Restablecer</button>
              <br></br>
              <Link to="/" >Regresar</Link>
            </form>
          </center>
          }
        </div>
      );
  }

}

export default Register;
