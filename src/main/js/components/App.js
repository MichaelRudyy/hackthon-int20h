import React, {Component} from "react";
import {Route, BrowserRouter} from "react-router-dom";
import Document from './document/Document';
import Dashboard from "./dashboard/Dashboard";

export default class App extends Component {
    render() {
        return (
            <BrowserRouter>
                <div>
                    <Route exact path='/' component={Dashboard}/>
                    <Route path='/document' component={Document}/>
                </div>
            </BrowserRouter>
        );
    }
}