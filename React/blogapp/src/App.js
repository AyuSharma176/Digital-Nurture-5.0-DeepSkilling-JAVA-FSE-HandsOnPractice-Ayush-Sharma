import CohortDetails from './CohortDetails';

const cohorts = [
  { code: 'C001', status: 'ongoing', startDate: '2024-01-01', endDate: '2024-06-30' },
  { code: 'C002', status: 'completed', startDate: '2023-06-01', endDate: '2023-12-31' },
  { code: 'C003', status: 'ongoing', startDate: '2024-03-01', endDate: '2024-09-30' },
];

function App() {
  return (
    <div style={{ padding: '20px' }}>
      <h1>Cohort Dashboard</h1>
      {cohorts.map(c => <CohortDetails key={c.code} cohort={c} />)}
    </div>
  );
}
export default App;