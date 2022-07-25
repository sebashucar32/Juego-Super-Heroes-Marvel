package co.com.game.model.gateway;

import co.com.game.model.Card;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CardRepository {
    Mono<Card> save(Card card);

    Flux<Card> findAll();

    Mono<Card> findById(String id);

    Mono<Void> deleteById(String id);
}
