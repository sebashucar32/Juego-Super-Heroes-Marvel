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
  correo: any;

  constructor(private router: Router,  private pinService: PinService) { }

  ngOnInit(): void {
    this.webSocketService = new WebSocketService(new PinComponent(this.router, this.pinService));
  }

  connect() {
    this.webSocketService?._connect();
  }

  disconnect() {
    this.webSocketService?._disconnect();
  }

  enviarEmail() {
    this.correo = localStorage.getItem("correo");
    console.log(this.correo);
    this.webSocketService?._send(this.correo);
  }

  handleMessage(message: string) {
    this.correo = message;
  }

  // logica de la pagina del pin esto es despues de la configuracion de socket
  createPin(): void {
    this.pinService.generatePin().subscribe(
      game => {
        console.log(game);
        this.connect();

        setTimeout(() => {
          this.enviarEmail();
        }, 1000);
        
        localStorage.setItem("pin", `${game.id}`)
        Swal.fire('Nuevo Juego', `PIN: ${game.id} creado con exito!`, 'success')
        this.router.navigate(['/dashboard/juego'])
      }
    ) 
  }
}
