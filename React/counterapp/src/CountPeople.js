import { Component } from 'react';

class CountPeople extends Component {
  constructor(props) {
    super(props);
    this.state = { entrycount: 0, exitcount: 0 };
  }

  UpdateEntry() {
    this.setState(prev => ({ entrycount: prev.entrycount + 1 }));
  }

  UpdateExit() {
    this.setState(prev => ({ exitcount: prev.exitcount + 1 }));
  }

  render() {
    return (
      <div style={{ padding: '20px' }}>
        <h1>Mall Entry/Exit Counter</h1>
        <p>People Entered: <strong>{this.state.entrycount}</strong></p>
        <p>People Exited: <strong>{this.state.exitcount}</strong></p>
        <button onClick={() => this.UpdateEntry()}
                style={{ marginRight: '10px', padding: '8px 16px' }}>
          Login (Entry)
        </button>
        <button onClick={() => this.UpdateExit()}
                style={{ padding: '8px 16px' }}>
          Exit
        </button>
      </div>
    );
  }
}
export default CountPeople;