import { useContext } from 'react';
import ThemeContext from './ThemeContext';

function EmployeeCard({ employee }) {
  const theme = useContext(ThemeContext);

  const btnStyle = {
    padding: '6px 14px',
    cursor: 'pointer',
    background: theme === 'dark' ? '#333' : '#fff',
    color: theme === 'dark' ? '#fff' : '#333',
    border: '1px solid #999',
    borderRadius: '4px'
  };

  return (
    <div style={{
      border: '1px solid #ccc', borderRadius: '8px',
      padding: '12px', marginBottom: '10px',
      background: theme === 'dark' ? '#555' : '#f9f9f9',
      color: theme === 'dark' ? '#fff' : '#333'
    }}>
      <h3>{employee.name}</h3>
      <p>Role: {employee.role}</p>
      <button style={btnStyle}>View Profile</button>
    </div>
  );
}
export default EmployeeCard;