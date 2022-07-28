import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PinService } from 'src/app/services/pin-services';
import { WebSocketService } from 'src/app/services/web-socket.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-pin',
  templateUrl: './pin.component.html',
  styleUrls: ['./pin.component.css']
})

export class PinComponent implements OnInit {
  webSocketService: WebSocketService | undefined;
  saludo: any;   // Se puede quitar

  constructor(private router: Router,  private pinService: PinService) { }

  ngOnInit(): void {
    this.webSocketService = new WebSocketService(new PinComponent(this.router, this.pinService));
  }

  connect() {
    this.webSocketService?._connect();
    //this.enviarEmail();
  }

  disconnect() {
    this.webSocketService?._disconnect();
  }

  enviarEmail() {
    this.saludo = localStorage.getItem("correo");
    console.log(this.saludo);
    this.webSocketService?._send(this.saludo);
  }

  handleMessage(message: string) {
    this.saludo = message;
  }

  // logica de la pagina del pin esto es despues de la configuracion de socket
  createPin(): void {
    this.pinService.generatePin().subscribe(
      game => {
        console.log(game);
        this.connect();
        this.enviarEmail();
        localStorage.setItem("pin", `${game.id}`)
        Swal.fire('Nuevo Juego', `PIN: ${game.id} creado con exito!`, 'success')
        this.router.navigate(['/dashboard/juego'])
      }
    )
  }
}
