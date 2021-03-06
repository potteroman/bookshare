import React, { Component } from 'react';
import { Route, Link, BrowserRouter as Router, Switch } from 'react-router-dom'


class Book extends Component {

    constructor() {
        super();
        console.log("[Book] constructor");
    }

    componentDidMount() {
        console.log("[Book] componentDidMount");
    }
    
    componentWillUnmount() {
        console.log("[Book] componentWillUnmount");
    }
    
    render() {
        console.log("[Book] render");        

        const item = this.props.item;
        return (
            <tr key={ item.id }>
                <td>{ item.id }</td>
                <td>{ item.firstName }</td>
                <td>{ item.lastName }</td>
                <td>{ item.bookName }</td>
                <td>{ item.bookGenre }</td>
                <td>{ item.author }</td>
                <td>{ item.year }</td>
                <td>{ item.announceTimestamp }</td>
                <td><Link to={"/announce/" + item.id} class='dd' type="List.css">Details</Link></td>
            </tr>
        );
    }
}

export default Book;