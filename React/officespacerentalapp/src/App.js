function App() {
  const offices = [
    { name: 'Sunrise Office', rent: 45000, address: '12 MG Road, Bangalore', image: 'https://via.placeholder.com/200x150?text=Office+1' },
    { name: 'TechHub Space', rent: 75000, address: '45 Anna Salai, Chennai', image: 'https://via.placeholder.com/200x150?text=Office+2' },
    { name: 'Workzone Plus', rent: 55000, address: '8 Park Street, Kolkata', image: 'https://via.placeholder.com/200x150?text=Office+3' },
    { name: 'Elite Offices', rent: 90000, address: '22 BKC, Mumbai', image: 'https://via.placeholder.com/200x150?text=Office+4' },
  ];

  return (
    <div style={{ padding: '20px', fontFamily: 'Arial' }}>
      <h1>Office Space Rental</h1>
      {offices.map((office, i) => (
        <div key={i} style={{
          border: '1px solid #ccc', borderRadius: '8px',
          padding: '16px', marginBottom: '16px', display: 'inline-block',
          marginRight: '16px', verticalAlign: 'top', width: '220px'
        }}>
          <img src={office.image} alt={office.name} width="200" />
          <h3>{office.name}</h3>
          <p><strong>Address:</strong> {office.address}</p>
          <p style={{ color: office.rent < 60000 ? 'red' : 'green' }}>
            <strong>Rent: ₹{office.rent}</strong>
          </p>
        </div>
      ))}
    </div>
  );
}
export default App;