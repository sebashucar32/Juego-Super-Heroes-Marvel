import { Carta } from "./Carta";

export class Jugador {
    email: string;
    cartas: Set<Carta>;

    constructor(email: string, cartas: Set<Carta>) {
        this.email = email;
        this.cartas = cartas;
    }
}