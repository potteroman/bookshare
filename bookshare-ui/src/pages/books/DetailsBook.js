import React, { Component } from 'react';
import { Link } from 'react-router-dom'


class DetailsBook extends Component {

    constructor() {
        super();
        console.log("[ExpenceList] constructor");
        this.state = {
            item: {}
        };
    }

    componentDidMount() {
        console.log("[ExpenceList] componentDidMount");
        let initialItems = [];
        fetch('http://localhost:8080/api/announce/' + this.props.match.params.id)
            .then(response => {
                console.log(response)
                return response.json();

            }).then(data => {
                console.log(data)
                this.setState({
                    item: data
                });
            });
    }

    componentWillUnmount() {
        console.log("[ExpenseDetails] componentWillUnmount");
    }

    render() {
        console.log("[ExpenseDetails] render");
        const item = this.state.item
        console.log(item)
        return ( 
            <div>                
            <div><strong>id</strong> <i>{item.id}</i></div>
            <div><strong>surname</strong> <i>{item.surname}</i></div>
            <div><strong>firstName</strong> <i>{item.firstName}</i></div>
            <div><strong>announceTimestamp</strong> <i>{item.announceTimestamp}</i></div>
            <div><strong>author</strong> <i>{item.author}</i></div>
            <div><strong>bookGenre</strong> <i>{item.bookGenre}</i></div>
            <div><strong>bookName</strong> <i>{item.bookName}</i></div>
            <div><strong>details</strong> <i>{item.details}</i></div>
            <div><strong>year</strong> <i>{item.year}</i></div>
        </div>
        );
    }
}

export default  DetailsBook;