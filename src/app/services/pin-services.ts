import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Game } from '../models/Game';

@Injectable({
  providedIn: 'root'
})

export class PinService {
    private urlEndPoint: string = 'http://localhost:8080/game';
    private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'});

    constructor(private http: HttpClient) {}

    generatePin(): Observable<Game>{
      const email = localStorage.getItem("correo");
      return this.http.post<Game>(`${this.urlEndPoint}/createpin/${email}`, {headers: this.httpHeaders});
    }
}