import { useState } from 'react';

function ComplaintRegister() {
  const [name, setName] = useState('');
  const [complaint, setComplaint] = useState('');
  const [refNumber, setRefNumber] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    const ref = 'REF' + Math.floor(Math.random() * 1000000);
    setRefNumber(ref);
    alert(`Complaint submitted!\nReference Number: ${ref}`);
  };

  return (
    <div style={{ padding: '20px', maxWidth: '500px', margin: '40px auto',
                  border: '1px solid #ccc', borderRadius: '8px' }}>
      <h2>Complaint Registration</h2>
      <form onSubmit={handleSubmit}>
        <div style={{ marginBottom: '12px' }}>
          <label><strong>Employee Name:</strong></label><br />
          <input
            type="text"
            value={name}
            onChange={e => setName(e.target.value)}
            required
            style={{ width: '100%', padding: '8px', marginTop: '4px' }}
            placeholder="Enter your name"
          />
        </div>
        <div style={{ marginBottom: '12px' }}>
          <label><strong>Complaint:</strong></label><br />
          <textarea
            value={complaint}
            onChange={e => setComplaint(e.target.value)}
            required
            rows={5}
            style={{ width: '100%', padding: '8px', marginTop: '4px' }}
            placeholder="Describe your complaint"
          />
        </div>
        <button type="submit"
                style={{ padding: '10px 20px', background: '#1a237e',
                         color: 'white', border: 'none', borderRadius: '4px' }}>
          Submit Complaint
        </button>
      </form>
      {refNumber && (
        <p style={{ marginTop: '16px', color: 'green' }}>
          Your Reference Number: <strong>{refNumber}</strong>
        </p>
      )}
    </div>
  );
}
export default ComplaintRegister;