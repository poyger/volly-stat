import React, { Component } from 'react';
import Player from './Player'
class SubmitResultComponent extends Component {
  render() {
    return (
      <ul className="list-group small">
        {this.props.players.map(player => <Player player={player} key={player.id}/>)}
      </ul>
    );
  }
}

export default SubmitResultComponent