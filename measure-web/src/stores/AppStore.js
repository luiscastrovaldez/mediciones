import Reflux from 'reflux'
import Actions from '../actions/Actions'
import * as HTTP from '../services/http'

class AppStore extends Reflux.Store {
  constructor(){
    super();
    this.listenables = Actions;
    this.state = {
      message: '',
      data: [],
      isLogged: false
    }
  }
  getUsers(){
    const self = this;
    HTTP.get('https://reqres.in/api/users?page=2')
    .then((response) => {
      self.setState({ data: response.data });
    })
  }
  postLogIn(username,password){
    console.info(username);
    console.info(password);
    const self = this;
    HTTP.postUrl('http://localhost:8181/services/user/validate',username,password)
    .then((response) => {
      self.setState({ message: response.message });
      self.setState({ isLogged: response.isLogged });
      console.info(response);
    })
  }



}

export default AppStore;
