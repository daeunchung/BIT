import React, {useState} from "react"

import {useCookies} from 'react-cookie';

function App() {
  const [name, setName] = useState("");

  const [cookies, setCookie] = useCookies(['name']);

  const Save = () => {
    setCookie("name", name, { path: '/' });
  }

  const Load = () => {
    alert(cookies.name);
  }

  const changeName = (e) => setName(e.target.value);

  return (
    <div>
      <h3>cookie test</h3>

      <input type="text" value={name} onChange={changeName} />

      <button type="button" onClick={Save}>cookie save</button> 
      <button type="button" onClick={Load}>cookie load</button> 
      
    </div>
  );
}

export default App;
