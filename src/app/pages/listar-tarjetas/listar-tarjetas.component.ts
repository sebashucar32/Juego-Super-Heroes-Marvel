import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-listar-tarjetas',
  templateUrl: './listar-tarjetas.component.html',
  styleUrls: ['./listar-tarjetas.component.css']
})

export class ListarTarjetasComponent implements OnInit {
  public titulo : String = 'Listado de Cartas de super heroes marvel';

  constructor(private router: Router) { }
  ngOnInit(): void {}

  cerrarSesion() {
    localStorage.removeItem("correo");
    this.router.navigateByUrl('/login');
  }
}
