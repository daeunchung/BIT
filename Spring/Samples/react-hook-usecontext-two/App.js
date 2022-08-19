import React from "react"
import First from "./First";
import TextProvider from "./TextProvider";

function App() {
  return (
    <div>
      <TextProvider>
        <First />
      </TextProvider>
    </div>
  );
}

export default App;
