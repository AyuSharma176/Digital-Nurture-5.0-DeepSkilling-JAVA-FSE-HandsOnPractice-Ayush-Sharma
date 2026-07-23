import '../Stylesheets/mystyle.css';

function CalculateScore({ name, school, total, goal }) {
  const average = (total / goal) * 100;
  return (
    <div className="container">
      <h2>Student Score Calculator</h2>
      <p><strong>Name:</strong> {name}</p>
      <p><strong>School:</strong> {school}</p>
      <p><strong>Total Marks:</strong> {total}</p>
      <p><strong>Goal:</strong> {goal}</p>
      <p className="score">Average Score: {average.toFixed(2)}%</p>
    </div>
  );
}
export default CalculateScore;