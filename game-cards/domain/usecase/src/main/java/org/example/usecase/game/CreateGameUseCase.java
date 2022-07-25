package org.example.usecase.game;

import co.com.game.model.Game;
import co.com.game.model.gateway.GameRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CreateGameUseCase {
    private final GameRepository repository;

    public Mono<Game> createGame(Game game) {
        return repository.save(game);
    }
}
