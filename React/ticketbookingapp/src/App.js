import { useState } from 'react';

function GuestPage() {
  return (
    <div>
      <h2>Available Flights</h2>
      <table border="1" cellPadding="10">
        <thead>
          <tr><th>Flight</th><th>From</th><th>To</th><th>Departure</th><th>Price</th></tr>
        </thead>
        <tbody>
          <tr><td>AI-101</td><td>Mumbai</td><td>Delhi</td><td>10:00 AM</td><td>₹4500</td></tr>
          <tr><td>AI-202</td><td>Chennai</td><td>Bangalore</td><td>2:00 PM</td><td>₹2500</td></tr>
          <tr><td>AI-303</td><td>Kolkata</td><td>Hyderabad</td><td>6:00 PM</td><td>₹5000</td></tr>
        </tbody>
      </table>
      <p style={{ color: 'red' }}>Please login to book tickets.</p>
    </div>
  );
}

function UserPage({ onLogout }) {
  return (
    <div>
      <h2>Book Your Ticket</h2>
      <p>Welcome! You can now book tickets.</p>
      <select style={{ padding: '8px', marginRight: '10px' }}>
        <option>AI-101 Mumbai → Delhi ₹4500</option>
        <option>AI-202 Chennai → Bangalore ₹2500</option>
        <option>AI-303 Kolkata → Hyderabad ₹5000</option>
      </select>
      <button style={{ padding: '8px 16px', background: 'green', color: 'white', border: 'none' }}>
        Book Now
      </button>
      <br /><br />
      <button onClick={onLogout} style={{ padding: '8px 16px' }}>Logout</button>
    </div>
  );
}

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  return (
    <div style={{ padding: '20px', fontFamily: 'Arial' }}>
      <h1>Flight Ticket Booking</h1>
      {isLoggedIn
        ? <UserPage onLogout={() => setIsLoggedIn(false)} />
        : (
          <div>
            <GuestPage />
            <button onClick={() => setIsLoggedIn(true)}
                    style={{ padding: '8px 16px', marginTop: '10px' }}>
              Login
            </button>
          </div>
        )
      }
    </div>
  );
}
export default App;