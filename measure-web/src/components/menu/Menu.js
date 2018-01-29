import React, { Component } from 'react';

import Home from '../views/Home';
import Bio from '../views/Bio';
import Description from '../views/Description';
import Contacto from '../views/Contacto';
import NavBar from '../NavBar';

import {
  BrowserRouter as Router,
  Route
} from 'react-router-dom'

class Menu extends Component {
  render() {
    return (
      <Router>
       <div>
         <NavBar/>
         <Route exact path="/" component={Home}/>
         <Route path="/bio" component={Bio}/>
         <Route path="/description" component={Description}/>
         <Route path="/contacto" component={Contacto}/>
       </div>
     </Router>
    );
  }
}

export default Menu;
