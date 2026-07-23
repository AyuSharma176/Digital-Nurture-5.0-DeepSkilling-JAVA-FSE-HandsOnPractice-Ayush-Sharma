import { useState } from 'react';
import ThemeContext from './ThemeContext';
import EmployeesList from './EmployeesList';

const employees = [
  { id: 1, name: 'Alice', role: 'Developer' },
  { id: 2, name: 'Bob', role: 'Designer' },
  { id: 3, name: 'Charlie', role: 'Manager' },
];

function App() {
  const [theme, setTheme] = useState('light');

  return (
    <ThemeContext.Provider value={theme}>
      <div style={{ padding: '20px', fontFamily: 'Arial' }}>
        <h1>Employee Management</h1>
        <button onClick={() => setTheme(t => t === 'light' ? 'dark' : 'light')}
                style={{ marginBottom: '16px', padding: '8px 16px' }}>
          Toggle Theme (Current: {theme})
        </button>
        <EmployeesList employees={employees} />
      </div>
    </ThemeContext.Provider>
  );
}
export default App;