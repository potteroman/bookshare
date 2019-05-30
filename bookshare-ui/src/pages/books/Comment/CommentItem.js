import React, { Component } from 'react';
class CommentItem extends Component {

    constructor() {
        super();
        console.log("[CommentItem] constructor");
        this.onAccept = this.onAccept.bind(this);
    }

    componentDidMount() {
        console.log("[CommentItem] componentDidMount");
    }

    componentWillUnmount() {
        console.log("[CommentItem] componentWillUnmount");
    }

    onAccept(id, e) {
        e.preventDefault();

        console.log(`[CommentItem] onRemove - ${id}`);
        fetch(`http://localhost:8080/api/order/${id}`, {
          method: "PUT",
          headers: {
            "content-type" : "application/json"
          }
        }).then(function(response) {
            console.log(`[CommentItem] onRemove - fetch.then(${response})`);

        }).catch(function(error) {
            console.log(`[CommentItem] onRemove - fetch.catch(${error})`);
        });
      } 
    render() {
        console.log("[CommentItem] render");        
        const item = this.props.item;
        return (
            <tr key={ item.id }>
                <td>{ item.user }</td>
                <td>{ item.announce }</td>
                <td>{ item.comment}</td>
                <td>{ item.accept}</td>
                <td><button onClick={(e) => this.onAccept(item.id, e)}>Accept</button></td>
            </tr>
        );
    }
}
export default CommentItem;