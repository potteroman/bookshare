import React, { Component } from 'react';
import "./AddComment.css";

class AddComment extends Component
{
  state = {
    userId: 0,
    announceId: 1,
    isActive:1,
    comment:''  
  };
    constructor() {
        super();
    
        this.handleChange = this.handleChange.bind(this);
        this.onSubmit = this.onSubmit.bind(this);

        console.log("[AnnouncePublishForm] constructor");
    }


  componentDidMount() {
    console.log("[AnnouncePublishForm] componentDidMount");
  }

  componentWillUnmount() {
    console.log("[AnnouncePublishForm] componentWillUnmount");
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

    console.log('The form was submitted with the following data:');
     
    const id = this.props.itemid;
    console.log("OrderRequest - [onSubmit] " + id)
    fetch("http://localhost:8080/api/order/add", {
      method: "POST",
      headers: {
        "content-type": "application/json"
      },
      body: JSON.stringify({
        clientId: 0,
        announceId: id,
        isActive:1,
        comment:this.state.comment
      })
    });
  }

  render() {
    console.log("in render" + this.props)

    return (
      
      <div className="Comment">
        
        <div>
          <form onSubmit={this.onSubmit}>
              
                  <label className="FormField__Label" htmlFor="comment">Order </label>
                  <input type="text" id="comment" className="Comment" placeholder="Enter comment" name="comment" value={this.state.comment} onChange={this.handleChange} />
                  <button className="comment_button">✓</button>
              

          </form>

        </div>  

      </div>
    );
  }
}

export default AddComment;