import React from "react"
import Session from "react-session-api";

function App() {

  function save(){

    // let counter = 10;
    // Session.set("counter", counter);

    // let obj = { 'id':"abc", 'pwd':"123" };
    // Session.set("obj", obj);

    let jsonObj = [ {'name':'홍길동', 'number':1001}, {'name':'성춘향', 'number':1002} ]
    Session.set("jsonObj", jsonObj);
  }

  function load(){

    // let count = Session.get("counter");
    // alert(count);

    // let obj = Session.get('obj');
    // alert(JSON.stringify(obj));
    // alert(obj.id);

    let jsonObj = Session.get("jsonObj");
    alert(jsonObj[1].name);
  }

  return (
    <div>
      <h3>session test</h3>
      
      <button type="button" onClick={save}>session 저장</button> 

      <button type="button" onClick={load}>session 불러오기</button> 

    </div>
  );
}

export default App;
