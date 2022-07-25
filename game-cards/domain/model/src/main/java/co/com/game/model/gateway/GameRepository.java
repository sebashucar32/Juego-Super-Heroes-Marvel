package co.com.game.model.gateway;

import co.com.game.model.Game;
import reactor.core.publisher.Mono;

public interface GameRepository {
    Mono<Game> save(Game game);

    Mono<Game> findById(String id);

    Mono<Game> findByGameId(String gameId);
}
