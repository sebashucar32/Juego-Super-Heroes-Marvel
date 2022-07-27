package org.example.api.playercontroller;

import co.com.game.model.Card;
import co.com.game.model.Player;
import lombok.RequiredArgsConstructor;
import org.example.usecase.player.AddCardtoPlayerUseCase;
import org.example.usecase.player.CreatePlayerUseCase;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class PlayerHandler {
  private final CreatePlayerUseCase createPlayerUseCase;

  private final AddCardtoPlayerUseCase addCardtoPlayerUseCase;
  public Mono<ServerResponse> createPlayer(ServerRequest serverRequest) {
    return serverRequest.bodyToMono(Player.class)
      .flatMap(createPlayerUseCase::create)
      .flatMap(player -> ServerResponse.ok()
        .contentType(MediaType.APPLICATION_JSON)
        .body(BodyInserters.fromValue(player)));
  }

  public Mono<ServerResponse> getPlayer(ServerRequest serverRequest) {
    String playerId = serverRequest.pathVariable("playerId");
    Mono<Player> request = createPlayerUseCase.get(playerId);
    return request.flatMap(player -> ServerResponse.ok()
      .contentType(MediaType.APPLICATION_JSON)
      .body(BodyInserters.fromValue(player)));
  }

  public Mono<ServerResponse> addCardToPlayer(ServerRequest serverRequest) {
    String playerId = serverRequest.pathVariable("playerId");
    Card card = new Card();
    Mono<Player> request = addCardtoPlayerUseCase.addCard(playerId, card);

    return request.flatMap(player -> ServerResponse.ok()
      .contentType(MediaType.APPLICATION_JSON)
      .body(BodyInserters.fromValue(player)));
  }
}
