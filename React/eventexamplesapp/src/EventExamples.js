import { Component } from 'react';

class EventExamples extends Component {
  constructor(props) {
    super(props);
    this.state = { counter: 0, message: '' };
  }

  increment() {
    this.setState(prev => ({ counter: prev.counter + 1 }));
  }

  sayHello() {
    this.setState({ message: 'Hello! Welcome to React Events!' });
  }

  decrement() {
    this.setState(prev => ({ counter: prev.counter - 1 }));
  }

  sayWelcome(msg) {
    this.setState({ message: msg });
  }

  onPress(e) {
    alert('I was clicked — Synthetic Event: ' + e.type);
  }

  render() {
    return (
      <div style={{ padding: '20px' }}>
        <h2>Event Examples</h2>
        <p>Counter: <strong>{this.state.counter}</strong></p>
        <p>{this.state.message}</p>

        {/* Multiple methods on one click */}
        <button onClick={() => { this.increment(); this.sayHello(); }}>
          Increment + Say Hello
        </button>

        <button onClick={() => this.decrement()} style={{ marginLeft: '10px' }}>
          Decrement
        </button>

        {/* Passing argument */}
        <button onClick={() => this.sayWelcome('Welcome to React!')}
                style={{ marginLeft: '10px' }}>
          Say Welcome
        </button>

        {/* Synthetic event */}
        <button onClick={(e) => this.onPress(e)} style={{ marginLeft: '10px' }}>
          OnPress
        </button>
      </div>
    );
  }
}
export default EventExamples;