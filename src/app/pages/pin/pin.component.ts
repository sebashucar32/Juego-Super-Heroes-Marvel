import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PinService } from 'src/app/services/pin-services';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-pin',
  templateUrl: './pin.component.html',
  styleUrls: ['./pin.component.css']
})

export class PinComponent implements OnInit {
  constructor(private router: Router, private pinService: PinService ) { }

  ngOnInit(): void {
  }

  createPin(): void {
    this.pinService.generatePin().subscribe(
      game => {
        console.log(game);
        localStorage.setItem("pin", `${game.id}`)
        Swal.fire('Nuevo Juego', `PIN: ${game.id} creado con exito!`, 'success')
        this.router.navigate(['/dashboard/juego'])
      }
    )
  }
}
