import React from "react"

import {BrowserRouter, Link, Route, Routes, useParams} from "react-router-dom"

function App() {
  return (
    <div>
      <BrowserRouter>

        <nav>
          <ul>
            <li>
              <Link to="/">Home</Link>
            </li>
            <li>
              <Link to="/about">About</Link>
            </li>
            <li>
              <Link to="/users">Users</Link>
            </li>
            <li>
              <Link to="/topics">Topics</Link>
            </li>
            <li>
              <Link to="/topic">Topic</Link>
            </li>
          </ul>
        </nav>

        <Routes>
          <Route path="/" element={<Home />}></Route>

          <Route path="/about" element={<About />}></Route>

          <Route path="/users" element={<Users />}></Route>

          <Route path="/topics/:topicId" element={<Topics />}></Route>

          <Route path="/topic" element={<Topic />}></Route> 

          <Route path="/topic/components" element={<Components />}></Route> 
        </Routes>
      
      </BrowserRouter>      
    </div>
  );
}

function Home(){
  return <h2>Home</h2>;
}

function About(){
  return <h2>About</h2>;
}

function Users(){
  return <h2>Users</h2>;
}

function Topics(){
  let {topicId} = useParams();
  
  return <h3>topic id: {topicId}</h3>
}

function Topic(){
  return (
    <div>
      <h2>Topic</h2>

      <ul>
        <li>
         <Link to="/topic/components">Components</Link>
        </li>
        <li>
         <Link to="/topic/props-state">props-state</Link>
        </li>
      </ul>

    </div>
  );
}

function Components(){
  return <div>components!!!</div>
}

export default App;
