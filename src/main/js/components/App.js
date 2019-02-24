import React, {Component} from "react";
import {Route, Switch, BrowserRouter} from "react-router-dom";
import Document from './document/Document';
import Dashboard from "./dashboard/Dashboard";

export default class App extends Component {
    render() {
        return (
            <BrowserRouter>
                <Switch>
                    <Route exact path='/' component={Dashboard}/>
                    <Route path='/document/:id' component={Document}/>
                </Switch>
            </BrowserRouter>
        );
    }
}