import React, {Component} from 'react';
import Routes from "./routes";
import TopNavigation from "./components/TopNavigation";


class App extends Component {
    render() {
        return (
            <React.Fragment>
                <TopNavigation/>
                <div>
                    <Routes/>
                </div>
            </React.Fragment>
        );
    }
}

export default App;
