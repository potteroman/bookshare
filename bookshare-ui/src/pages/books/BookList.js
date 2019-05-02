import React, { Component } from 'react';
import Book from './Book';

class BookList extends Component {

    constructor() {
        super();
        this.state = {
            items:[]
        };
        console.log("[ BookList] constructor");
    }

    componentDidMount() {
        console.log("[ BookList] componentDidMount");
        let initialItems = [];
        fetch('http://localhost:8080/api/announce')
            .then(response => {
                return response.json();
                
            }).then(data => {
                initialItems = data.map((planet) => {
                console.log(planet)
                return planet
            });

            this.setState({
                items: initialItems,
            });
        });
    }
    
    componentWillUnmount() {
        console.log("[ BookList] componentWillUnmount");
    }

    render() {
        console.log("[ BookList] render");

        return (
            <table>
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>User_id</th>
                        <th>Book_id</th>
                        <th>Announce_timestamp</th>
                    </tr>
                </thead>
                <tbody>
                {
                      this.state.items.map(item => <Book item={ item } />)
                }
                </tbody>
            </table>
        );
    }
}

export default BookList;