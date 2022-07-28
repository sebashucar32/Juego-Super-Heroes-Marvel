package org.example.api.sockets;

import co.com.game.model.Player;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SocketController {
  List<Player> jugadores = new ArrayList<>();
  List<String> correos = new ArrayList<>();

  @MessageMapping("/hello")
  @SendTo("/topic/superHeroes")
  public void entrarSala(String correo) throws Exception {
    Thread.sleep(1000); // simulated delay
    HtmlUtils.htmlEscape(correo);
    correos.add(correo);
    correos.stream().forEach(c -> System.out.println(c));
  }
}
