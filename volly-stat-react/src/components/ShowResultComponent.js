import React, {Component} from 'react';
import GameResult from './GameResult'
import GameStanding from './GameStanding'
import {Table} from 'reactstrap';

class ShowResultComponent extends Component {
    render() {
        return (
            <>
                <Table striped dark size="sm">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Namn</th>
                        <th>Spelade</th>
                        <th>Vinst</th>
                        <th>Förlust</th>
                        <th>Set</th>
                        <th>Diff</th>
                        <th>Poäng (3P för vinst 1P för set vinst)</th>
                    </tr>
                    </thead>
                    <tbody>
                    {this.props.standing.map((standing, i) =>
                        <GameStanding standing={standing} tableRow={i + 1} key={standing.player.id} />)}

                    </tbody>
                </Table>
                <div id="accordion">
                    {this.props.results.map((result, i) =>
                        <GameResult gameresult={result} isLast={i === 0} key={result.id}/>)}
                </div>
            </>
        );
    }
}

export default ShowResultComponent