function ListofPlayers() {
  const players = [
    { name: 'Rohit', score: 85 },
    { name: 'Virat', score: 120 },
    { name: 'Gill', score: 60 },
    { name: 'Pant', score: 45 },
    { name: 'Hardik', score: 75 },
    { name: 'Jadeja', score: 30 },
    { name: 'Bumrah', score: 15 },
    { name: 'Shami', score: 20 },
    { name: 'Siraj', score: 10 },
    { name: 'Kuldeep', score: 25 },
    { name: 'Ashwin', score: 55 },
  ];

  // map() to display all players
  const allPlayers = players.map((p, i) => (
    <li key={i}>{p.name} — {p.score} runs</li>
  ));

  // arrow function + filter for low scorers
  const lowScorers = players
    .filter(p => p.score < 70)
    .map((p, i) => <li key={i}>{p.name} — {p.score} runs</li>);

  return (
    <div>
      <h2>All Players</h2>
      <ul>{allPlayers}</ul>
      <h2>Players with score below 70</h2>
      <ul>{lowScorers}</ul>
    </div>
  );
}
export default ListofPlayers;