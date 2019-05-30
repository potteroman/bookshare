import React, { Component } from 'react';
import './AnnouncePublishForm.css';

class AnnouncePublishForm extends Component
{

    constructor() {
        super();
    
        this.state = {
            name: '',
            author: '',
            genre: '',
            year: '',
            description: ''
        };
    
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
    console.log(this.state);

    fetch("http://localhost:8080/api/announce/add", {
      method: "POST",
      headers: {
        "content-type": "application/json"
      },
      body: JSON.stringify(this.state)
    });
  }

  render() {
    return (
      <div className="Publish">
  
        <div>
          <form onSubmit={this.onSubmit}>
            <div className="FormField">
                  <label className="Publish" htmlFor="name">Name</label>
                  <input type="text" id="name" className="Publish" placeholder="Enter name of the book" name="name" value={this.state.name} onChange={this.handleChange} />
              </div>
              <div className="FormField">
                  <label className="Publish" htmlFor="author">Author</label>
                  <input type="text" id="author" className="Publish" placeholder="Enter author of the book" name="author" value={this.state.author} onChange={this.handleChange} />
              </div>
              <div className="FormField">
                  <label className="Publish" htmlFor="genre">Genre</label>
                  <input type="text" id="genre" className="Publish" placeholder="Enter genre of the book" name="genre" value={this.state.genre} onChange={this.handleChange} />
              </div>
              <div className="FormField">
                  <label className="Publish" htmlFor="year">Year</label>
                  <input type="text" id="year" className="Publish" placeholder="Enter the year of publishment" name="year" value={this.state.year} onChange={this.handleChange} />
              </div>
              <div className="FormField">
                  <label className="Publish" htmlFor="description">Description</label>
                  <input type="text" id="description" className="Publish" placeholder="Enter description of the book" name="description" value={this.state.description} onChange={this.handleChange} />
              </div>
              <div className="Publish">
                  <button className="publish_button">Publish</button>
              </div>
          </form>
        </div>  
  
      </div>
    );
  }
}

export default AnnouncePublishForm;

