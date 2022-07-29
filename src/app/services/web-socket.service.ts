import { Injectable } from '@angular/core';

import * as Stomp from 'stompjs';
import * as SockJS from 'sockjs-client';
import { PinComponent } from '../pages/pin/pin.component';
import { JuegoComponent } from '../pages/juego/juego.component';

@Injectable({
  providedIn: 'root'
})

export class WebSocketService {
  webSocketEndPoint: string = 'http://localhost:8080/ws';
  topic: string = "/topic/superHeroes";
  stompClient: any;

  constructor() { 
  }

  _connect() {
    console.log("Inicializa el webSocket de conexion con el servidor");
    let webSocket = new SockJS(this.webSocketEndPoint);
    this.stompClient = Stomp.over(webSocket);
    const _this = this;

    _this.stompClient.connect({}, function (frame: any) {
      _this.stompClient.subscribe(_this.topic, function (sdkEvent: any) {
        _this.onMessageReceived(sdkEvent);
      });

    }, this.errorCallBack);
  };

  // Se desconecta el cliente con el servidor por medio del webSocket
  _disconnect() {
    if (this.stompClient !== null) {
      this.stompClient.disconnect();
    }
    console.log("Disconnected");
  }

  // on error, schedule a reconnection attempt
  errorCallBack(error: string) {
    console.log("errorCallBack -> " + error)
    setTimeout(() => {
      this._connect();
    }, 5000);
  }

  _send(email: any) {
    console.log("calling logout api via web socket");
    console.log(email);
    this.stompClient.send("/app/juego", {}, JSON.stringify(email));
  }

  onMessageReceived(message: string) {
    console.log("Message Recieved from Server :: " + message);
    //this.pinComponent.handleMessage(JSON.stringify(message));
  }
}
