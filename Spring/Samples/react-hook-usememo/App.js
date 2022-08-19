import React, { useState, useMemo } from "react"

/*
  useMemo : rendering이 필요부분만을 실행한다
*/

const square = (params) => {
  console.log('square 함수 실행');  
  return params * params;
}

function App() {
  const [countStateA, setCountStateA] = useState(0);
  const [countStateB, setCountStateB] = useState(0);

  const countResultA = () => {
    setCountStateA((prevCount) => prevCount + 1);
    console.log("A + 1 버튼이 클릭되었습니다");
  }
  const countResultB = () => {
    setCountStateB((prevCount) => prevCount + 1);
    console.log("B + 1 버튼이 클릭되었습니다");
  }

  //const squareArea = square(countStateB);

  const squareArea = useMemo(()=>square(countStateB), [countStateB]);

  return (
    <div>
      <p>
        계산 결과 A : {countStateA}
        <button onClick={countResultA}>계산: A + 1</button>
      </p>
      <p>
        계산 결과 B : {countStateB}
        <button onClick={countResultB}>계산: B + 1</button>
      </p>
      
      <p>정사각형의 면적</p>
      <p>계산 결과 B x 계산 결과 B = {squareArea}</p>
    </div>
  );
}

export default App;
