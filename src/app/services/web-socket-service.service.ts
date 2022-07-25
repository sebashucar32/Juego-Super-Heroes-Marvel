import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})

export class WebSocketServiceService {
  webSocket: WebSocket;
  
  constructor() { 
    this.webSocket = new WebSocket('ws://localhost:8080/chat');
  }

  public openWebSocket() {
    this.webSocket.onopen = (event) => {
      console.log('Open', event);
    }

    this.webSocket.onmessage = (event) => {
      const messageJuedoDto = JSON.parse(event.data);
    }

    this.webSocket.onclose = (event) => {
      console.log('Close', event);
    }
  }

  public closeWebSocket() {
    this.webSocket.close();
  }
}
