import React, { Component } from 'react';
import LoginRow from './LoginRow';

import { Link } from 'react-router-dom';

class Restablecer extends Component{

  constructor(){
    super();
    this.state = {
      errorEmail:''
    }
    this.onRestablecer = this.onRestablecer.bind(this);
    this.onSubmit = this.onSubmit.bind(this);
  }

  onSubmit(e){
    e.preventDefault();
    //console.log(e);
  }

  onRestablecer(e){
    console.log(this.refs.email.getValue());
    this.setState({errorEmail:''});



    let  email = this.refs.email.getValue();
    if (email == ''){
      this.setState({errorEmail:'Correo obligatorio'});
    }
  }

  render(){
      return(
        <div>
          <center>
            <form onSubmit={ this.onSubmit }>
              <label>Restablecer contraseña</label>
              <LoginRow id="email" inputType="email" placeholder="Correo" isRequired={true} ref="email"/>
                <font color="red"> {this.state.errorEmail} </font>
              <br></br>
              <button className="btn btn-primary" onClick={this.onRestablecer} color="primary">Restablecer</button>
              <br></br>
              <Link to="/" >Regresar</Link>
            </form>
          </center>
        </div>
      );
  }

}

export default Restablecer;
