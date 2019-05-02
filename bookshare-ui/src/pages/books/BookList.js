import React, { Component } from 'react';
import Book from './Book';

class BookList extends Component {

    constructor() {
        super();
        console.log("[ BookList] constructor");
    }

    componentDidMount() {
        console.log("[ BookList] componentDidMount");
    }
    
    componentWillUnmount() {
        console.log("[ BookList] componentWillUnmount");
    }

    render() {
        console.log("[ BookList] render");

        let items = [
            { id : 1, name : "Harry Potter 1", autor : "J.J. Rowling", genre : "Fantasy" ,publication: "London Pub",year: "1997"},
            { id : 2, name : "Harry Potter 2", autor : "J.J. Rowling", genre : "Fantasy" ,publication: "London Pub",year: "1998"},
            { id : 3, name : "Harry Potter 3", autor : "J.J. Rowling", genre : "Fantasy" ,publication: "London Pub",year: "1999"},
            { id : 4, name : "Harry Potter 4", autor : "J.J. Rowling", genre : "Fantasy" ,publication: "London Pub",year: "2000"},
            { id : 5, name : "Harry Potter 5", autor : "J.J. Rowling", genre : "Fantasy" ,publication: "London Pub",year: "2003"},
        ];    

        return (
            <table>
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Autor</th>
                        <th>Genre</th>
                        <th>Publication</th>
                        <th>Year</th>
                    </tr>
                </thead>
                <tbody>
                {
                    items.map(item => <Book item={ item } />)
                }
                </tbody>
            </table>
        );
    }
}

export default BookList;