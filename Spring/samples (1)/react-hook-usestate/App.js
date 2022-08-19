import React, { useState } from "react"

/*
    hook
    (const)변수 - setter, getter
    
    기본
    useState
    useEffect
    useContext

    추가
    useMemo
    useRef
    useReducer
        :
*/

function App() {
  //state- getter  setter
  const [state, setState] = useState('클릭전');

  // state = 'click';
  // setState('click');
  console.log( state );

  //////////////////////////////////////////

  const [msg, setMsg] = useState("");

  const btnClick = () => {
    alert(msg);
  }

  return (
    <div>
      <button onClick={()=>setState('클릭후')}>
        {state}
      </button>    
      <br/>

      <button onClick={btnClick}>button</button>
      <input onChange={(event) => {setMsg(event.target.value)}} />
    </div>
  );
}

export default App;
