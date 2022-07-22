import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-agregar-tarjetas',
  templateUrl: './agregar-tarjetas.component.html',
  styleUrls: ['./agregar-tarjetas.component.css']
})
export class AgregarTarjetasComponent implements OnInit {
  public titulo: String = 'Crea cartas Personalizadas de super heroes marvel';

  constructor() { }
  ngOnInit(): void {}

}
