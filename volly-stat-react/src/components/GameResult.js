import React, { Component } from 'react';

class GameResult extends Component {
  render() {
    let gameId1 = "#collapse" + this.props.gameresult.game.id;
    let gameId2 = "collapse" + this.props.gameresult.game.id;
    return (
      <>
        <div className="card">
          <div className="card-header" id="headingOne">
            <h5 className="mb-0">
              <button className="btn btn-link" data-toggle="collapse" data-target={gameId1} aria-expanded="true" aria-controls="collapseOne">
              {this.props.gameresult.game.date}
          </button>
            </h5>
          </div>

          <div id={gameId2} className="collapse hide" aria-labelledby="headingOne" data-parent="#accordion">
            <div className="card-body">
              <div className="row">
                <div className="col-md-2">{this.props.gameresult.team1.players.map(player => <p key={player.id}>{player.name}</p>)}</div>
                <div className="col-md-5">{this.props.gameresult.team2.players.map(player => <p key={player.id}>{player.name}</p>)}</div>
              </div>
            </div>
          </div>
        </div>
      </>
    );
  }
}

export default GameResult