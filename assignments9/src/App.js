import React, {useState} from "react";
import './App.css';
import "./assets/Counter.css"
function App() {
    const [count, setCount] = useState(0);

    const increaseCount = () => {
        setCount(count + 1);
    };

    const decreaseCount = () => {
        if(count>0) {
            setCount(count - 1);
        }
    };
  return (
      <div className={"counter-container"}>
        <h1>Counter App</h1>
        <p>Current Count: {count}</p>
          <button onClick={decreaseCount}>Decrease by 1 -</button>
          <button onClick={increaseCount}>Increase by 1 + </button>
      </div>
  );
}

export default App;
