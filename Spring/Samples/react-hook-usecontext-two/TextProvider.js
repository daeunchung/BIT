import React, { createContext } from "react"

export const TextContext = createContext();

const text = "Provider에서 전달할 텍스트입니다";

function TextProvider({ children }) {
  return (
    <TextContext.Provider value={text}>
        {children}        
    </TextContext.Provider>
  );
}

export default TextProvider;