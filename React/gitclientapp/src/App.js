import { Component } from 'react';
import GitClient from './GitClient';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = { repos: [], loading: true, username: 'techiesyed' };
    this.client = new GitClient();
  }

  componentDidMount() {
    this.client.getRepositories(this.state.username)
      .then(repos => this.setState({ repos, loading: false }))
      .catch(err => {
        console.error(err);
        this.setState({ loading: false });
      });
  }

  render() {
    const { repos, loading, username } = this.state;
    return (
      <div style={{ padding: '20px', fontFamily: 'Arial' }}>
        <h1>GitHub Repositories for: {username}</h1>
        {loading ? <p>Loading...</p> : (
          <ul>
            {repos.map((repo, i) => <li key={i}>{repo}</li>)}
          </ul>
        )}
      </div>
    );
  }
}
export default App;