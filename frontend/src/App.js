import React, {Component} from 'react'
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
import UserList from './components/UserList'
import './App.css'

class App extends Component {
  render() {
    return (
      <Router>
        <Switch>
          <Route path="/" exact={true} component={UserList} />
        </Switch>
      </Router>
    )
  }
}

export default App
