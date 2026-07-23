import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';
import Home from './Home';
import TrainersList from './TrainersList';
import TrainerDetails from './TrainerDetails';
import trainers from './TrainersMock';

function App() {
  return (
    <BrowserRouter>
      <nav style={{ padding: '10px', background: '#1a237e' }}>
        <Link to="/" style={{ color: 'white', marginRight: '20px' }}>Home</Link>
        <Link to="/trainers" style={{ color: 'white' }}>Trainers</Link>
      </nav>
      <div style={{ padding: '20px' }}>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/trainers" element={<TrainersList trainers={trainers} />} />
          <Route path="/trainers/:id" element={<TrainerDetails trainers={trainers} />} />
        </Routes>
      </div>
    </BrowserRouter>
  );
}
export default App;