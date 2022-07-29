import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Jugador } from '../models/Jugador';

@Injectable({
  providedIn: 'root'
})

export class JugadorService {
  private urlEndPoint: string = 'http://localhost:8080/player';
  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'});

  constructor(private http: HttpClient) {}

  crearJugador(jugador: Jugador): Observable<Jugador> {
    return this.http.post<Jugador>(`${this.urlEndPoint}/create`, jugador, {headers: this.httpHeaders});
  }
}
