import React from "react"

function App() {
  
  const numbers = [1, 2, 3, 4, 5];
//  console.log(numbers[1]);

  const listItems = numbers.map( (number) => 
    <li key={number.toString() }>
      {number}
    </li>
  )  

  // event
  /*
    onClick
    onSubmit
    onChange
    onMouseOver
  */
  
  return (
    <div>
      <ul>
        { listItems }
      </ul>

        <button onClick={ () => {console.log('button click')} }>button</button>

        <input onChange={(event) => {console.log(event.target.value)}}/>      
    </div>
  );
}

export default App;


