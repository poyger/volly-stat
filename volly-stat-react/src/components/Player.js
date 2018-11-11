import React, { Component } from 'react';
class Player extends Component {
  render() {
    return (
      <li className="list-group-item">
          <span className="small">{this.props.player.name}</span>
          <button className="float-right">Home</button>
          <button className= "float-right">Away</button>
      </li>
    );
  }
}

export default Player