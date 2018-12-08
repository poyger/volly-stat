import React, { Component } from 'react';
import {
    Card,
    CardText,
    CardBody,
    CardTitle,
    Collapse
} from 'reactstrap';
import { Container, Row, Col } from 'reactstrap';

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
                            <CardText tag="div">
                                <Container>
                                    <Row>
                                        <Col>
                                            <ul className="list-unstyled">
                                                <strong>{this.props.gameresult.team1SetWin}</strong>
                                                {this.props.gameresult.team1.players.map(player => <li key={player.id}>{player.name}</li>)}
                                            </ul>
                                        </Col>
                                        <Col>
                                            <ul className="list-unstyled">
                                                <strong>{this.props.gameresult.team2SetWin}</strong>
                                                {this.props.gameresult.team2.players.map(player => <li key={player.id}>{player.name}</li>)}
                                            </ul>
                                        </Col>
                                    </Row>
                                </Container>
                            </CardText>
                        </Collapse>
                    </CardBody>
                </Card>
            </div>
        );
    }
}

export default GameResult