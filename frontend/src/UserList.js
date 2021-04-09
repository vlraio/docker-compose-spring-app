import React, {Component} from 'react'
import {Container, Table} from 'react-bootstrap'
import {Link} from 'react-router-dom'

class UserList extends Component {

  constructor(props) {
    super(props)
    this.state = {
      users: [],
      isLoading: true
    }
  }

  componentDidMount() {
    this.setState({
      isLoading: true
    })

    fetch('users')
      .then(response => response.json())
      .then(({userDtos}) => this.setState({
        users: userDtos,
        isLoading: false
      }))
  }

  render() {
    const {users, isLoading} = this.state

    if (isLoading) {
      return <p>Loading...</p>
    }

    const userList = users.map(
      user =>
        <tr key={user.id}>
          <td>{user.firstName}</td>
          <td>{user.secondName}</td>
          <td>{user.age}</td>
          <td><Link target='_blank'>{user.avatar}</Link></td>
        </tr>
    )

    return (
      <div className='mt-4'>
        <Container fluid>
          <h3>All users</h3>
          <Table className='mt-4'>
            <thead>
            <tr>
              <th width='25%'>First name</th>
              <th width='25%'>Second name</th>
              <th width='10%'>Age</th>
              <th width='40%'>Avatar link</th>
            </tr>
            </thead>
            <tbody>
            {userList}
            </tbody>
          </Table>
        </Container>
      </div>
    )
  }
}

export default UserList
