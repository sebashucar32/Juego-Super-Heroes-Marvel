export class Game {
    id: String;
    playing: boolean;
    players: Array<String>;

    constructor(id: String, playing: boolean, players: Array<String>) {
        this.id = id;
        this.playing = playing;
        this.players = players;
    }
}