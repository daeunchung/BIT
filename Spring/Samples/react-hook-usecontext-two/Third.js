import React, { useContext } from "react"
import { TextContext } from "./TextProvider";

function Third() {
  
  const textData = useContext(TextContext); // TextProvider로부터 전달 받음

  return (
    <div>
      <p>Third 컴퍼넌트</p>
      <b>{ textData }</b>
    </div>
  );
}

export default Third;