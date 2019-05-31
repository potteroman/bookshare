import React, { Component } from 'react';
import { Link, BrowserRouter as Router, Switch } from 'react-router-dom'


class CommentItem extends Component {

    constructor() {
        super();
        this.handleChange = this.handleChange.bind(this);
        this.onSubmit = this.onSubmit.bind(this);
        console.log("[Book] constructor");
    }

    componentDidMount() {
        console.log("[Book] componentDidMount");
    }

    componentWillUnmount() {
        console.log("[Book] componentWillUnmount");
    }
    handleChange(e) {
        let target = e.target;
        let value = target.value;
        let name = target.name;

        this.setState({
            [name]: value
        });
    }

    onSubmit(e) {
        e.preventDefault();
        setTimeout(()=>{
        console.log('The form was submitted with the following data:');
        console.log(this.props)
        console.log("OrderRequest - [onSubmit] -A-A-A " + this.props)
        fetch("http://localhost:8080/api/order/approve/" , {
            method: "POST",
            headers: {
                "content-type": "application/json"
            },
            body: JSON.stringify({
                userId: this.props.item.userId,
                announceId: this.props.item.announceId,
            })
        });
    },1000)
    }

    render() {
        console.log("[Book] render");

        const item = this.props.item;
        return (
            <tr key={item.announceId}>
                <td>{item.firstName}</td>
                <td>{item.lastName}</td>
                <td>{item.comment}</td>
                <td><form onSubmit={this.onSubmit}>
                <button className="FormField__Button mr-20">Accept</button>
                </form>
                </td>
            </tr>
        );
    }
}

export default CommentItem;