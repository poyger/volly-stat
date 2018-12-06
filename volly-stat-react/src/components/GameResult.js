import React, { Component } from 'react';
import {
    Card,
    CardText,
    CardBody,
    CardTitle,
    Collapse
} from 'reactstrap';


class GameResult extends Component {

    constructor(props) {
        super(props);
        if (props.isLast) {
            this.state = { collapsed: true };
        } else {
            this.state = { collapsed: false };
        }
        this.handleToggle = this.handleToggle.bind(this);
    }

    handleToggle() {
        console.info(this.props.isLast);
        this.setState({ collapsed: !this.state.collapsed });
    }

    render() {
        const game = this.props.gameresult.game;
        return (
            <div>
                <Card className="mb-2">
                    <CardBody onClick={this.handleToggle}>
                        <CardTitle>{game.date}</CardTitle>
                        <Collapse isOpen={this.state.collapsed}>
                            <CardText>
                                <div class="row">
                                    <div class="col-sm">
                                    {this.props.gameresult.team1SetWin}
                                    <hr/>
                                    <ul className="list-unstyled">
                                        {this.props.gameresult.team1.players.map(player => <li key={player.id}>{player.name}</li>)}
                                    </ul>
                                    </div>
                                    <div class="col-sm">
                                    {this.props.gameresult.team2SetWin}
                                    <hr/>
                                    <ul className="list-unstyled">
                                        {this.props.gameresult.team2.players.map(player => <li key={player.id}>{player.name}</li>)}
                                    </ul>
                                    </div>
                                </div>
                            </CardText>
                        </Collapse>
                    </CardBody>
                </Card>
            </div>
        );
    }
}

export default GameResult