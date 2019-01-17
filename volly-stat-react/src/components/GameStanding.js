import React, {Component} from 'react';

class GameStanding extends Component {

    constructor(props) {
        super(props);
        this.getDiff = this.getDiff.bind(this);
    }


    getDiff() {
        const diff = (this.props.standing.setDifference);
         if (diff > 0) {
                return "+" + diff;
         }
         return diff;
    }

    render() {
        return (
            <tr>
                <th scope="row">{this.props.tableRow}</th>
                <td>{this.props.standing.player.name}</td>
                <td>{this.props.standing.playedGames}</td>
                <td>{this.props.standing.win}</td>
                <td>{this.props.standing.lose}</td>
                <td>{this.props.standing.setWin}-{this.props.standing.setLose}</td>
                <td>{this.getDiff()}</td>
                <td>{this.props.standing.points}</td>
            </tr>
        );
    }
}

export default GameStanding