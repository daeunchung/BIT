import React from "react"
import Message from "./Message.js";

function App() {

  // function funcName(user){
  //   return user.name + " " + user.age;
  // }

  // function
  const funcName = (user) => {   // arrow(화살표) 함수
    return user.name + " " + user.age;
  }

  const user = {
    name: '홍길동',
    age: 24
  }

  const flg = false;

  // component -> 첫글자는 대문자로
  const Mycomponent = (props) => {  // propertys -> props
    return (
      <div>나의 컴퍼넌트 이름: { props.name } 나이: {props.age}</div>
    )
  } 

  // property

  return (
    <div>
      Hello, { funcName(user) }

      { flg && <p>flag:true</p> }
      { !flg && <p>flag:false</p> }

      <Mycomponent name="춘향" age="16"/>

      <Message height="182.3" />

    </div>
  );
}

export default App;
