package org.example.usecase.player;

import co.com.game.model.Player;
import co.com.game.model.gateway.PlayerRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CreatePlayerUseCase {
    private final PlayerRepository repository;

    public Mono<Player> create(Player player) {
        return repository.save(player);
    }

    public Mono<Player> get(String id) {
      return repository.findById(id);
    }
}
