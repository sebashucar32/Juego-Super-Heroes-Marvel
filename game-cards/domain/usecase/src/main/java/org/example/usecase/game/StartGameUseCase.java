package org.example.usecase.game;

import co.com.game.model.Game;
import co.com.game.model.gateway.GameRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;
@RequiredArgsConstructor
public class StartGameUseCase {

    private final GameRepository repository;

    public Mono<Game> gameById(String gameId) {
        return repository.findById(gameId);
    }

    public Mono<Game> startGame(Game game) {
        game.setPlaying(true);
        return repository.save(game);

    }
}
