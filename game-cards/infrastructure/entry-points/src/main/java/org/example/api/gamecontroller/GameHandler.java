package org.example.api.gamecontroller;



import co.com.game.model.Game;

import co.com.game.model.event.DomainEvent;


import lombok.RequiredArgsConstructor;
import lombok.var;
import org.example.adapters.event.EventPublisher;
import org.example.usecase.game.AddPlayerToGameUseCase;
import org.example.usecase.game.CreateGameUseCase;
import org.example.usecase.game.StartGameUseCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


@Component
@RequiredArgsConstructor
@CrossOrigin(origins={"http://localhost:4200"})
public class GameHandler {
    @Autowired
    private final EventPublisher<DomainEvent> publisher;
    private final CreateGameUseCase createGameUseCase;
    private final StartGameUseCase startGameUseCase;

    private final AddPlayerToGameUseCase addPlayerToGameUseCase;

    public Mono<ServerResponse> createGame(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(Game.class)
                .flatMap(createGameUseCase::createGame)
                .flatMap(game -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromValue(game)));
    }

    public Mono<ServerResponse> startGame(ServerRequest serverRequest) {
        String gameId = serverRequest.pathVariable("gameId");
        Mono<Game> request = startGameUseCase.gameById(gameId)
                .flatMap(startGameUseCase::startGame);

        request.subscribe(publisher::publish);

        return request.flatMap(game -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(game)));
    }

    public Mono<ServerResponse> addPlayertoGame(ServerRequest serverRequest) {
      String gameId = serverRequest.pathVariable("gameId");
      String playerId = serverRequest.pathVariable("playerId");
      Mono<Game> request = addPlayerToGameUseCase.addPlayer(gameId, playerId);

      return request.flatMap(game -> ServerResponse.ok()
        .contentType(MediaType.APPLICATION_JSON)
        .body(BodyInserters.fromValue(game)));
    }

  public Mono<ServerResponse> getGame(ServerRequest serverRequest) {
    String gameId = serverRequest.pathVariable("gameId");
    Mono<Game> request = startGameUseCase.gameById(gameId);
    return request.flatMap(game -> ServerResponse.ok()
      .contentType(MediaType.APPLICATION_JSON)
      .body(BodyInserters.fromValue(game)));
  }

  public Mono<ServerResponse> createPin(ServerRequest serverRequest) {
      String email = serverRequest.pathVariable("email");
      Game game = new Game();
      Set<String> lis = new HashSet<>();
      lis.add(email);
      game.setPlaying(false);
      game.setPlayers(lis);
      Mono<Game> request = createGameUseCase.createGame(game);
      return request
        .flatMap(game1 -> ServerResponse.ok()
          .contentType(MediaType.APPLICATION_JSON)
          .body(BodyInserters.fromValue(game1)));
  }
}
