import React, { Component } from 'react';
import SubmitResultComponent from '../components/SubmitResultComponent';

const initialState = {
  players: [
    { "id": 1, "name": "Poyan" }, { "id": 2, "name": "Pejman" }, { "id": 3, "name": "Reza P" }, { "id": 4, "name": "Reza B" }, { "id": 5, "name": "Sirus" }, { "id": 6, "name": "Mohsen" }, { "id": 7, "name": "Maks" }, { "id": 8, "name": "Oskan" }, { "id": 9, "name": "Saman" }, { "id": 10, "name": "Hedi" }, { "id": 11, "name": "Zafari" }, { "id": 12, "name": "Nima" }, { "id": 13, "name": "Nuri" }, { "id": 14, "name": "Sayed" }, { "id": 15, "name": "Mahan" }, { "id": 16, "name": "Shahram" }]
}
class PlayerContainer extends Component {

  constructor(props) {
    super(props);
    this.state = initialState;
  }

  render() {
    return (
      <SubmitResultComponent players={this.state.players} />
    );
  }
}

export default PlayerContainer;
