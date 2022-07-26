import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Carta } from '../models/Carta';

@Injectable({
  providedIn: 'root'
})

export class CartaServiceService {
  private urlEndPoint: string = 'http://localhost:8080/card';
  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'});

  constructor(private http: HttpClient) {}

  getCartas(): Observable<Carta[]> {
    return this.http.get<Carta[]>(`${this.urlEndPoint}/all`);
  }

  crearCarta(carta: Carta) : Observable<Carta> {
    return this.http.post<Carta>(`${this.urlEndPoint}/create`, carta, {headers: this.httpHeaders});
  }

  actualizarCarta(carta: Carta): Observable<Carta> {
    return this.http.put<Carta>(`${this.urlEndPoint}/${carta.id}`, carta, {headers: this.httpHeaders});
  }

  eliminarCarta(id: string): Observable<Carta> {
    return this.http.delete<Carta>(`${this.urlEndPoint}/delete/${id}`, {headers: this.httpHeaders});
  }
}
