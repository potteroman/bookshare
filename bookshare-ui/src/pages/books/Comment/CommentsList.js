import React, { Component } from 'react';
import CommentItem from './CommentItem';


class CommentsList extends Component {
    
    constructor() {
        super();
        console.log("[OrderList] constructor");

        this.state = {
            items: []
        };
    }

    componentDidMount() {
        setTimeout(() => {
            let initialItems = [];
            const id = this.props.announceid;
            fetch("http://localhost:8080/api/order/announce/" + this.props.announceid)
                .then(response => {
                    return response.json();

                }).then(data => {

                    initialItems = data.map((planet) => {
                        return planet;
                    });

                    this.setState({
                        items: initialItems,
                    });
                });
        }, 2000);
    }   

        onSubmit(e) {
            e.preventDefault();
        
            console.log('The form was submitted with the following data:');
             
            const id = this.props.itemid;
            console.log("OrderRequest - [onSubmit] " + id)
            fetch("http://localhost:8080/api/order/add", {
              method: "POST",
              headers: {
                "content-type": "application/json"
              },
              body: JSON.stringify({
                userId: 0,
                announceId: id,
                isActive:1,
                comment:this.state.comment
              })
            });
          }

    componentWillUnmount() {
        console.log("[OrderList] componentWillUnmount");
    }

    render() {

        console.log("[OrderList] componentDidMount 2");
        console.log(this.props)
        console.log("[OrderList] componentDidMount 2");
        return (
            <table>
                <thead>
                    <tr>
                        <td>First name</td>
                        <td>Last Name</td>
                        <td>Commment</td>
                    </tr>
                </thead>
                <tbody>
                    {
                        this.state.items.map(item => <CommentItem item={item} />)
                    }
                </tbody>
            </table >
        );
    }
}


export default CommentsList; 