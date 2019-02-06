import React from "react";

import { Switch, Route } from "react-router-dom";

import ShowResultContainer from './containers/ShowResultContainer'
import ShowPictures from './components/ShowPictures'

export default () => (
    <Switch>
        <Route exact path="/" component={ShowResultContainer} />
        <Route exact path="/pictures" component={ShowPictures} />
    </Switch>
);
