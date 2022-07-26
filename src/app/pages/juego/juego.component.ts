import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-juego',
  templateUrl: './juego.component.html',
  styleUrls: ['./juego.component.css']
})

export class JuegoComponent implements OnInit {
  public  pin = localStorage.getItem("pin");
  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  cerrarSesion() {
    localStorage.removeItem("correo");
    this.router.navigateByUrl('/login');
  }
}
