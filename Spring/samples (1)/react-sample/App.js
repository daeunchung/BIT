import React from "react";

function App() {

  // 소스부
  const name = '홍길동';
  // const == 상수

  var age = 24;

  let address = "서울시";

  const element = <h3>{ name } { age }</h3>;
  
  // class == className 
  return (
    <div>    
      <h1>Hello React { name } { age } {address}</h1>

      { element }

      <h2 style={ { color:'yellow', backgroundColor:'#0000ff' } }>test title</h2> 

    </div>
  );
}

export default App;
