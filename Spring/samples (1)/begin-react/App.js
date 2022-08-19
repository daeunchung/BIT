import logo from './logo.svg';
import './App.css';

function HelloReact(){
  return <div>안녕 리엑트</div>
}

function App() {
  return (
    <div>
      <HelloReact></HelloReact> 
      <HelloReact />
      <HelloReact />
    </div>
  );
}

export default App;
