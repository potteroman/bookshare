import React, { Component } from 'react';


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
                <td>{ item.user }</td>
                <td>{ item.book }</td>
                <td>{ item.announceTimestamp }</td>
            </tr>
        );
    }
}

export default Book;