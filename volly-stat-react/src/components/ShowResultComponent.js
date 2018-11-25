import React, { Component } from 'react';
import GameResult from './GameResult'
class ShowResultComponent extends Component {
  render() {
    let length = this.props.results.length;
    return (
      <div id="accordion">
        {this.props.results.map((result, i) => <GameResult gameresult={result} isLast={length === i + 1} key={result.id} />)}
      </div>

    );
  }
}

export default ShowResultComponent