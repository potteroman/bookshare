<
import React, { Component } from 'react';
import { Link ,Route,NavLink,Router} from 'react-router-dom';

class check extends Component {
    constructor() {
        super();
        console.log("[ExpenceList] constructor");
        this.state = {
            item: {}
        };
    }

    render(){
return(
    div>
    <input type="checkbox" id="scales" name="scales" checked>
    <label for="scales">Scales</label>
    </div>
);
    }

    export default  DetailsBook;