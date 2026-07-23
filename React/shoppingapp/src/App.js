class Cart {
  constructor(itemname, price) {
    this.itemname = itemname;
    this.price = price;
  }
}

function OnlineShopping() {
  const items = [
    new Cart('Laptop', 55000),
    new Cart('Phone', 25000),
    new Cart('Tablet', 35000),
    new Cart('Headphones', 5000),
    new Cart('Keyboard', 3000),
  ];

  const total = items.reduce((sum, item) => sum + item.price, 0);

  return (
    <div style={{ padding: '20px' }}>
      <h1>Online Shopping Cart</h1>
      <table border="1" cellPadding="10">
        <thead>
          <tr><th>Item</th><th>Price (₹)</th></tr>
        </thead>
        <tbody>
          {items.map((item, i) => (
            <tr key={i}>
              <td>{item.itemname}</td>
              <td>{item.price}</td>
            </tr>
          ))}
        </tbody>
        <tfoot>
          <tr><td><strong>Total</strong></td><td><strong>₹{total}</strong></td></tr>
        </tfoot>
      </table>
    </div>
  );
}
export default OnlineShopping;