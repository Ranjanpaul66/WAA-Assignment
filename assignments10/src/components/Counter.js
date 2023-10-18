import "../App.css"
import React, {Component} from "react";
import "./Colors"
class Counter extends Component {

    constructor(props) {
        super(props);
        this.state ={
            count:0
        }
    }
    increaseCount=()=>{
        this.setState({count:this.state.count+1})
    }
    decreaseCount=()=>{
        if(this.state.count>0)
       this.setState({count: this.state.count - 1})
    }
    render() {
        return (
            <div className={"App"}>
                <h2> Counter  {this.state.count}</h2>
                <button onClick={this.decreaseCount}>Decrease by 1 -</button>
                <button onClick={this.increaseCount}>Increase by 1 + </button>
            </div>
        );
    }
}

export default Counter;