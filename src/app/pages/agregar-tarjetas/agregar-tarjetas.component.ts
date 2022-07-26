import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Carta } from 'src/app/models/Carta';
import { CartaServiceService } from 'src/app/services/carta-service.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-agregar-tarjetas',
  templateUrl: './agregar-tarjetas.component.html',
  styleUrls: ['./agregar-tarjetas.component.css']
})

export class AgregarTarjetasComponent implements OnInit {
  public titulo: String = 'Crea cartas Personalizadas de super heroes marvel';
  public carta: Carta = new Carta("", "", "", "", 0);

  constructor(private cartaService: CartaServiceService, private router: Router) { }
  ngOnInit(): void {}

  public crearCuenta(): void {
    let aleatorio = random(0, 1000);
    let juegoId = "jue-" + String(aleatorio);
    this.carta.id = juegoId;

    this.cartaService.crearCarta(this.carta).subscribe(
      carta => {
        this.router.navigate(['/dashboard/listar'])
        Swal.fire('Nueva Carta', `Carta ${carta.name} creada con exito!`, 'success')
      }
    )
  }
}

function random(min: number, max: number) {
  return Math.floor(Math.random() * (max - min + 1) + min);
}
