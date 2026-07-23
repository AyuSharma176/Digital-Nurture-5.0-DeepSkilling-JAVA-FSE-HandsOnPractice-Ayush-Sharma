import EmployeeCard from './EmployeeCard';

function EmployeesList({ employees }) {
  return (
    <div>
      {employees.map(e => <EmployeeCard key={e.id} employee={e} />)}
    </div>
  );
}
export default EmployeesList;