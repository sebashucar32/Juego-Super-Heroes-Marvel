package org.example.usecase.player;

import co.com.game.model.Game;
import co.com.game.model.Player;
import co.com.game.model.gateway.PlayerRepository;
import lombok.RequiredArgsConstructor;
import lombok.var;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class AddCardtoPlayerUseCase {
  private final PlayerRepository repository;

  public Mono<Player> addCard(String id, String idCard) {
    var playerToUpdate = repository.findById(id);
    return playerToUpdate.map(player -> {
      player.addPlayer(idCard);
      return player;
    });
  }
}
