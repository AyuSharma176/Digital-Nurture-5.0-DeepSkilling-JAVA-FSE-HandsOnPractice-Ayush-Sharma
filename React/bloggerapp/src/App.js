import { useState } from 'react';

function BookDetails() {
  return (
    <div style={{ padding: '16px', border: '1px solid #ccc', borderRadius: '8px', marginBottom: '16px' }}>
      <h2>Book Details</h2>
      <ul>
        <li>Clean Code — Robert C. Martin</li>
        <li>The Pragmatic Programmer — Hunt & Thomas</li>
        <li>You Don't Know JS — Kyle Simpson</li>
      </ul>
    </div>
  );
}

function BlogDetails() {
  return (
    <div style={{ padding: '16px', border: '1px solid #ccc', borderRadius: '8px', marginBottom: '16px' }}>
      <h2>Blog Details</h2>
      <ul>
        <li>Understanding React Hooks</li>
        <li>Top 10 JS Tips in 2024</li>
        <li>Why TypeScript Matters</li>
      </ul>
    </div>
  );
}

function CourseDetails() {
  return (
    <div style={{ padding: '16px', border: '1px solid #ccc', borderRadius: '8px', marginBottom: '16px' }}>
      <h2>Course Details</h2>
      <ul>
        <li>React — Beginner to Advanced</li>
        <li>Node.js Full Stack</li>
        <li>Python for Data Science</li>
      </ul>
    </div>
  );
}

function App() {
  const [active, setActive] = useState('book');

  return (
    <div style={{ padding: '20px', fontFamily: 'Arial' }}>
      <h1>Blogger App</h1>

      {/* Method 1: Buttons to switch */}
      <div style={{ marginBottom: '16px' }}>
        <button onClick={() => setActive('book')}  style={{ marginRight: '8px' }}>Books</button>
        <button onClick={() => setActive('blog')}  style={{ marginRight: '8px' }}>Blogs</button>
        <button onClick={() => setActive('course')}>Courses</button>
      </div>

      {/* Method 2: if-else */}
      {(() => {
        if (active === 'book')   return <BookDetails />;
        else if (active === 'blog')  return <BlogDetails />;
        else return <CourseDetails />;
      })()}

      {/* Method 3: Ternary */}
      {active === 'book' && <p style={{ color: 'green' }}>Showing Book Details</p>}
      {active === 'blog' && <p style={{ color: 'blue' }}>Showing Blog Details</p>}
      {active === 'course' && <p style={{ color: 'orange' }}>Showing Course Details</p>}
    </div>
  );
}
export default App;