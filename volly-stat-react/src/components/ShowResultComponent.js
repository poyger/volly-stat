import React, { Component } from 'react';
import GameResult from './GameResult'
class ShowResultComponent extends Component {
  render() {
    return (
      <div id="accordion">
        {this.props.results.map((result, i) => <GameResult gameresult={result} isLast={i === 0} key={result.id} />)}
      </div>

    );
  }
}

export default ShowResultComponent