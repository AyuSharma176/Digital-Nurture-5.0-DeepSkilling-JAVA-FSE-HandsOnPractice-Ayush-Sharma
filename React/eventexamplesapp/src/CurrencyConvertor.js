import { useState } from 'react';

function CurrencyConvertor() {
  const [rupees, setRupees] = useState('');
  const [euro, setEuro] = useState(null);

  const handleSubmit = (e) => {
    e.preventDefault();
    const result = (parseFloat(rupees) / 89.5).toFixed(2);
    setEuro(result);
  };

  return (
    <div style={{ padding: '20px', borderTop: '1px solid #ccc', marginTop: '20px' }}>
      <h2>Currency Convertor (₹ to €)</h2>
      <form onSubmit={handleSubmit}>
        <input
          type="number"
          value={rupees}
          onChange={e => setRupees(e.target.value)}
          placeholder="Enter amount in ₹"
          style={{ padding: '8px', marginRight: '10px' }}
        />
        <button type="submit" style={{ padding: '8px 16px' }}>Convert</button>
      </form>
      {euro && <p>₹{rupees} = €{euro}</p>}
    </div>
  );
}
export default CurrencyConvertor;