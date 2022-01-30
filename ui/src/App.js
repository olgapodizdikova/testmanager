import React from 'react';
import './App.css';
import Test from './test/Test';
import TestForm from "./test/TestForm";
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';

const App = () => {
    return (
        <Router>
            <Switch>
                <Route path="/" exact={true} component={Test}></Route>
                <Route path="/new" component={TestForm}></Route>
                <Route path="*" component={NotFound}></Route>
            </Switch>
        </Router>
    )
}

export const NotFound = () => {
    return <div>This is a 404 page</div>
}

export default App;
