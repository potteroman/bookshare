import React, { Component } from 'react';
import {Link} from 'react-router-dom';

import './Account.css';

class RegistrationForm extends Component{

    constructor() {
        super();
    
        this.state = {
            username: '',
            email: '',
            password: '',
            firstName: '',
            lastName: '',
            city: '',
            phone: ''
        };
    
        this.handleChange = this.handleChange.bind(this);
        this.onSubmit = this.onSubmit.bind(this);

        console.log("[RegistrationForm] constructor");
    }

        componentDidMount() {
            console.log("[RegistrationForm] componentDidMount");
          }
        
          componentWillUnmount() {
            console.log("[RegistrationForm] componentWillUnmount");
          }
        

        handleChange(e) {
            let target = e.target;
            let value = target.value;
            let name = target.name;
      
            this.setState({
              [name]: value
            });
        }
      
        onSubmit(e) {
          e.preventDefault();
      
          console.log('The form was submitted with the following data:');
          console.log(this.state);
      
          fetch("http://localhost:8080/api/user/register", {
            method: "POST",
            headers: {
              "content-type" : "application/json"
            },
            body: JSON.stringify(this.state)
          });
        } 

        render() {
            return (
              <div className="Registration">
                <div>
                  <form onSubmit={this.onSubmit}>
                      <div>
                          <label className="Registration" htmlFor="username">Userame</label>
                          <input type="text" id="username" className="Registration" placeholder="Enter your username" name="username" value={this.state.username} onChange={this.handleChange} />
                      </div>
                      <div className="FormField">
                          <label className="Registration" htmlFor="firstName">First Name</label>
                          <input type="text" id="firstName" className="Registration" placeholder="Enter your first name" name="firstName" value={this.state.firstName} onChange={this.handleChange} />
                      </div>
                      <div className="FormField">
                          <label className="Registration" htmlFor="lastName">Last Name</label>
                          <input type="text" id="lastName" className="Registration" placeholder="Enter your last name" name="lastName" value={this.state.lastName} onChange={this.handleChange} />
                      </div>
                      <div className="FormField">
                          <label className="Registration" htmlFor="password">Password</label>
                          <input type="password" id="password" className="Registration" placeholder="Enter your password" name="password" value={this.state.password} onChange={this.handleChange} />
                      </div>
                      <div className="FormField">
                          <label className="Registration" htmlFor="email">Email</label>
                          <input type="email" id="email" className="Registration" placeholder="Enter your email" name="email" value={this.state.email} onChange={this.handleChange} />
                      </div>
                      <div className="FormField">
                          <label className="Registration" htmlFor="city">City</label>
                          <input type="text" id="city" className="Registration" placeholder="Enter your city" name="city" value={this.state.city} onChange={this.handleChange} />
                      </div>
                      <div className="FormField">
                          <label className="Registration" htmlFor="phone">Phone</label>
                          <input type="text" id="phone" className="Registration" placeholder="Enter your phone" name="phone" value={this.state.phone} onChange={this.handleChange} />
                      </div>
                      <div className="Registration">
                          <button className="register_button">Sign Up</button>
                      </div>
                  </form>
                </div>  
          
              </div>
            );
          }
        }
          
          export default RegistrationForm;
