import { useState } from 'react';

function Register() {
  const [form, setForm]     = useState({ name: '', email: '', password: '' });
  const [errors, setErrors] = useState({});
  const [success, setSuccess] = useState(false);

  const validate = () => {
    const newErrors = {};
    if (form.name.length < 5)
      newErrors.name = 'Name must have at least 5 characters';
    if (!form.email.includes('@') || !form.email.includes('.'))
      newErrors.email = 'Email must contain @ and .';
    if (form.password.length < 8)
      newErrors.password = 'Password must have at least 8 characters';
    return newErrors;
  };

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
    // clear error on change
    setErrors({ ...errors, [e.target.name]: '' });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    const errs = validate();
    if (Object.keys(errs).length > 0) {
      setErrors(errs);
    } else {
      setSuccess(true);
    }
  };

  const inputStyle = { width: '100%', padding: '8px', marginTop: '4px', marginBottom: '4px' };
  const errStyle   = { color: 'red', fontSize: '0.85rem' };

  return (
    <div style={{ padding: '20px', maxWidth: '400px', margin: '40px auto',
                  border: '1px solid #ccc', borderRadius: '8px' }}>
      <h2>Register</h2>
      {success && <p style={{ color: 'green' }}>Registration Successful!</p>}
      <form onSubmit={handleSubmit}>
        <div>
          <label>Name</label>
          <input name="name" value={form.name}
                 onChange={handleChange} style={inputStyle} />
          {errors.name && <p style={errStyle}>{errors.name}</p>}
        </div>
        <div>
          <label>Email</label>
          <input name="email" value={form.email}
                 onChange={handleChange} style={inputStyle} />
          {errors.email && <p style={errStyle}>{errors.email}</p>}
        </div>
        <div>
          <label>Password</label>
          <input name="password" type="password" value={form.password}
                 onChange={handleChange} style={inputStyle} />
          {errors.password && <p style={errStyle}>{errors.password}</p>}
        </div>
        <button type="submit"
                style={{ padding: '10px 20px', background: '#1a237e',
                         color: 'white', border: 'none', borderRadius: '4px',
                         marginTop: '8px', width: '100%' }}>
          Register
        </button>
      </form>
    </div>
  );
}
export default Register;