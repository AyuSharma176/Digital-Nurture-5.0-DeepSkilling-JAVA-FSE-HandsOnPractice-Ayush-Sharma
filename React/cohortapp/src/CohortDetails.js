function CohortDetails({ cohort }) {
  if (!cohort) return null;
  const color = cohort.status === 'ongoing' ? 'green' : 'blue';
  return (
    <div className="box">
      <h3 style={{ color }}>{cohort.code}</h3>
      <dl>
        <dt>Status</dt><dd>{cohort.status}</dd>
        <dt>Start</dt><dd>{cohort.startDate}</dd>
        <dt>End</dt><dd>{cohort.endDate}</dd>
      </dl>
    </div>
  );
}
export default CohortDetails;