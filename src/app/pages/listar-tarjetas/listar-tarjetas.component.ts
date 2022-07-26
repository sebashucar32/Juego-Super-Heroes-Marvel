import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Carta } from 'src/app/models/Carta';
import { CartaServiceService } from 'src/app/services/carta-service.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-listar-tarjetas',
  templateUrl: './listar-tarjetas.component.html',
  styleUrls: ['./listar-tarjetas.component.css']
})

export class ListarTarjetasComponent implements OnInit {
  public titulo : String = 'Listado de Cartas de super heroes marvel';
  cartas: any;
  
  constructor(private router: Router, private cartaService: CartaServiceService) { }

  ngOnInit(): void {
    this.cartaService.getCartas().subscribe(
      cartas => this.cartas = cartas
    );
  }

  deleteCarta(carta: Carta): void {
    Swal.fire({
      title: 'Esta seguro?',
      text: `¿Seguro que desea eliminar la carta`,
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Si, Eliminarlo!'
    }).then((result) => {
      if (result.isConfirmed) {
        this.cartaService.eliminarCarta(carta.id).subscribe(response => {
          this.cartas = this.cartas.filter((car: Carta) => car !== carta)
          Swal.fire(
            'Eliminado!',
            'La carta ha sido borrada.',
            'success'
          )
        })
      }
    })
  }

  cerrarSesion() {
    localStorage.removeItem("correo");
    this.router.navigateByUrl('/login');
  }
}