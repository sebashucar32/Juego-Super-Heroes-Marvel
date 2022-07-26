package org.example.usecase.game;

import co.com.game.model.Game;
import co.com.game.model.Player;
import co.com.game.model.gateway.GameRepository;
import lombok.RequiredArgsConstructor;
import lombok.var;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class AddPlayerToGameUseCase {
    private final GameRepository repository;

    public Mono<Game> addPlayer(String id,String idplayer) {
      var gameToUpdate = repository.findById(id);
      return gameToUpdate.map(game -> {
        game.addPlayer(idplayer);
        return game;
      });
    }
}
