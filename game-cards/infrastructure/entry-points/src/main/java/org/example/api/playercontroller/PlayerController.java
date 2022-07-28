package org.example.api.playercontroller;

import co.com.game.model.Player;
import org.example.usecase.player.CreatePlayerUseCase;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Component
@RestController
@RequestMapping("/player")
public class PlayerController {


 /* @Bean
  public RouterFunction<ServerResponse> playerRouterFunction(PlayerHandler playerHandler) {
    return route(POST("/player"), playerHandler::createPlayer)
      .andRoute(GET("/player/{playerId}"), playerHandler::getPlayer)
      .andRoute(PUT("/player/addCard/{playerId}/{cardId}"),playerHandler::addCardToPlayer);
  }*/

  private final CreatePlayerUseCase createPlayerUseCase;

  public PlayerController(CreatePlayerUseCase createPlayerUseCase) {
    this.createPlayerUseCase = createPlayerUseCase;
  }

  @PostMapping("/create")
  public Mono<Player> createPlayer(@RequestBody Player player) {
    return createPlayerUseCase.create(player);
  }
}
