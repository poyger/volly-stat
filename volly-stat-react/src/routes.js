import React from "react";

import { Switch, Route } from "react-router-dom";

import ShowResultContainer from './containers/ShowResultContainer'
import ShowPictures from './components/ShowPictures'

export default () => (
    <Switch>
        <Route path="/" component={ShowResultContainer} />
        <Route path="/pictures" component={ShowPictures} />
    </Switch>
);
