import { useParams, Link } from 'react-router-dom';

function TrainerDetails({ trainers }) {
  const { id } = useParams();
  const trainer = trainers.find(t => t.trainerId === parseInt(id));

  if (!trainer) return <p>Trainer not found.</p>;

  return (
    <div>
      <h2>{trainer.name}</h2>
      <p><strong>Email:</strong> {trainer.email}</p>
      <p><strong>Phone:</strong> {trainer.phone}</p>
      <p><strong>Technology:</strong> {trainer.technology}</p>
      <p><strong>Skills:</strong> {trainer.skills.join(', ')}</p>
      <Link to="/trainers">← Back to List</Link>
    </div>
  );
}
export default TrainerDetails;