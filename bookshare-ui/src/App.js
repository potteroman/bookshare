import React, { Component } from 'react';
import { Route, Link, BrowserRouter as Router, Switch } from 'react-router-dom'
import logo from './logo.svg';
import './App.css';


import BookList from './pages/books/BookList';
import DetailsBook from './pages/books/DetailsBook';
import RegistrationForm from './pages/account/RegistrationForm';
import SignInForm from './pages/account/SingInForm';
import AnnouncePublishForm from './pages/books/AnnouncePublishForm';
import Notfound from './pages/common/NotFound';

class App extends Component {

  constructor() {
    super();
    console.log("[App] constructor");
}

componentDidMount() {
  console.log("[App] componentDidMount"); 
}

componentWillUnmount() {
  console.log("[App] componentWillUnmount");
}

render() {
  console.log("[App] render");

  return (
   <Router>
      <div className="App">
        <header>
        <div>
          <tr>
            <td> <Link to="/general" class='app' type="App.css">BookList</Link></td>
            <td><Link to="/SignIn" class='app' type="App.css">SingIn</Link></td>
            <td><Link to="/register" class='app' type="App.css">Register</Link> </td>
            <td><Link to="/publish" class='app' type="App.css">Publish book</Link></td>
          </tr>
        </div>
        <Switch>
          <Route exact path="/" component={BookList} />
          <Route path="/general" component={BookList} />
          <Route path="/register" component={RegistrationForm} />
          <Route path="/SignIn" component={SignInForm} />
          <Route path="/publish" component={AnnouncePublishForm} />
          <Route path='/announce/:id' component={DetailsBook} />
          <Route component={Notfound} />          
        </Switch>
        </header>
      </div>
      </Router>
    );
}
}

export default App;