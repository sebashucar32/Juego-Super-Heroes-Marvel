import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-listar-tarjetas',
  templateUrl: './listar-tarjetas.component.html',
  styleUrls: ['./listar-tarjetas.component.css']
})
export class ListarTarjetasComponent implements OnInit {
  public titulo : String = 'Listado de Cartas de super heroes marvel';

  constructor() { }

  ngOnInit(): void {
  }

}
