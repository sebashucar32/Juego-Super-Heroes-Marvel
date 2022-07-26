package org.example.api.gamecontroller;

import co.com.game.model.Card;
import co.com.game.model.Game;
import org.example.usecase.game.CreateGameUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.HashSet;
import java.util.Set;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Component
@RestController
@CrossOrigin(origins="http://localhost:4200")
public class GameController {
private final CreateGameUseCase createGameUseCase;
    public GameController(CreateGameUseCase createGameUseCase) {
      this.createGameUseCase = createGameUseCase;
    }
  @PostMapping("/createpin/{email}")
  public Mono<Game> createPin(@PathVariable("email") String email) {
    Game game = new Game();
    Set<String> lis = new HashSet<>();
    lis.add(email);
    game.setPlaying(false);
    game.setPlayers(lis);

    return createGameUseCase.createGame(game);
  }
    @Bean
    public RouterFunction<ServerResponse> gameRouterFunction(GameHandler gameHandler) {
      return route(POST("/game"), gameHandler::createGame)
          .andRoute(GET("/game/{gameId}"), gameHandler::getGame)
          .andRoute(POST("/game/start/{gameId}"), gameHandler::startGame)
        .andRoute(PUT("game/addPlayer/{gameId}/{playerId}"),gameHandler::addPlayertoGame);
    }
}
