import React, { Component } from 'react';
import PropTypes from 'prop-types';


class LoginRow extends Component {

  constructor(props){
    super(props);
    this.state = {
      inputValue: ''
    }
    this.onChange = this.onChange.bind(this);
    this.getValue = this.getValue.bind(this);
  }

  onChange(e){
    this.setState({ inputValue: e.target.value });
  }

  getValue(){
    return this.state.inputValue;
  }

  render(){
      return(
        <div>
          <input
            id={ this.props.id }
            type={ this.props.inputType }
            placeholder={ this.props.placeholder }
            value={ this.state.inputValue }
            onChange={ this.onChange }
            required = {this.props.isRequired}/>
        </div>
      );
  }
}

LoginRow.propTypes = {
  id: PropTypes.string.isRequired,
  inputType: PropTypes.string.isRequired,
  placeholder: PropTypes.string.isRequired,
  isRequired: PropTypes.bool
};

export default LoginRow;
