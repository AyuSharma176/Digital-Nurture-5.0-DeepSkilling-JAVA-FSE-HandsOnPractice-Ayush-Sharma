import { Component } from 'react';

class Getuser extends Component {
  constructor(props) {
    super(props);
    this.state = { user: null, loading: true };
  }

  async componentDidMount() {
    try {
      const res  = await fetch('https://api.randomuser.me/');
      const data = await res.json();
      this.setState({ user: data.results[0], loading: false });
    } catch (err) {
      console.error('Error fetching user:', err);
      this.setState({ loading: false });
    }
  }

  render() {
    const { user, loading } = this.state;
    if (loading) return <p>Loading user...</p>;
    if (!user)   return <p>Failed to load user.</p>;

    return (
      <div style={{ padding: '20px', textAlign: 'center', fontFamily: 'Arial' }}>
        <h1>Random User</h1>
        <img
          src={user.picture.large}
          alt="User"
          style={{ borderRadius: '50%', width: '150px' }}
        />
        <h2>{user.name.title} {user.name.first} {user.name.last}</h2>
        <p>Email: {user.email}</p>
        <p>Location: {user.location.city}, {user.location.country}</p>
      </div>
    );
  }
}
export default Getuser;