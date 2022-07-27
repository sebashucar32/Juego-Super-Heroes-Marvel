package org.example.api.sockets;

import co.com.game.model.Player;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;

import java.util.ArrayList;
import java.util.List;

public class SocketController {
  List<Player> jugadores = new ArrayList<>();
  List<String> correos = new ArrayList<>();

  @MessageMapping("/InicioJuego")
  @SendTo("/app/superHeroes")
  public void entrarSala(String correo) throws Exception {
    Thread.sleep(1000); // simulated delay


  }
}
