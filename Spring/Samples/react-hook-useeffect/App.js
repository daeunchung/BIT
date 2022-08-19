import React, { useState, useEffect } from "react"

function App() {
  const [count, setCount] = useState(0)

  useEffect( () => {
    console.log("useEffect!!");
  });
  // 현재 컴포넌트가 rendering될 때마다 자동실행.
  // 무한 루프로 빠질 소지가 있음

  return (
    <div>
      <p>count: {count}</p>
      <button onClick={ () => { setCount(count + 1) } }>카운터</button>
    </div>
  );
}

export default App;
