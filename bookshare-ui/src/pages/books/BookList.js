import React, { Component } from 'react';
import Book from './Book';
import './BookList.css';

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
            <div class="limiter">
		    <div class="container-table100">
			<div class="wrap-table100">
			<div class="table100"></div>
            <table>
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>FirstName</th>
                        <th>Lastname</th>
                        <th>BookName</th>
                        <th>BookGenre</th>
                        <th>Author</th>
                        <th>Year</th>
                        <th>Date</th>
                        <th>Details</th>
                    </tr>
                </thead>
                <tbody>
                {
                      this.state.items.map(item => <Book item={ item } />)
                }
                </tbody>
            </table>
            </div>
			</div>
		</div>
        );
    }
}

export default BookList;