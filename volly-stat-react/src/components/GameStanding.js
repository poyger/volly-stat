import React, {Component} from 'react';

class GameStanding extends Component {
    render() {
        return (
            <tr>
                <th scope="row">{this.props.tableRow}</th>
                <td>{this.props.standing.player.name}</td>
                <td>{this.props.standing.playedGames}</td>
                <td>{this.props.standing.win}</td>
                <td>{this.props.standing.lose}</td>
                <td>{this.props.standing.setWin}</td>
                <td>{this.props.standing.setLose}</td>
                <td>{this.props.standing.points}</td>
            </tr>
        );
    }
}

export default GameStanding