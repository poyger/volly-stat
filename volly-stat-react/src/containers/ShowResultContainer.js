import React, { Component } from 'react';
import ShowResultComponent from '../components/ShowResultComponent';

class ShowResultContainer extends Component {

  constructor(props) {
    super(props);
    this.state = {
      error: null,
      isLoaded: false,
      results: []
    };
  }

  componentDidMount() {
    fetch("http://localhost:8888/getResults")
      .then(res => res.json())
      .then(
        (result) => {
          this.setState({
            isLoaded: true,
            results: result
          });
        },
        (error) => {
          this.setState({
            isLoaded: true,
            error
          });
        }
      )
  }


  render() {
    return (
      <ShowResultComponent results={this.state.results} />
    );
  }
}

export default ShowResultContainer;
