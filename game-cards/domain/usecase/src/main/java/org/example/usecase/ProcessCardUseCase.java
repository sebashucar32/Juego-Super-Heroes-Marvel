package org.example.usecase;

import co.com.game.model.Card;
import co.com.game.model.gateway.CardRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ProcessCardUseCase {
    private final CardRepository repository;
    public ProcessCardUseCase(CardRepository repository) {
        this.repository = repository;
    }

    public Mono<Card> saveCard(Card card) {
        return repository.save(card);
    }

    public Flux<Card> allCards() {
        return repository.findAll();
    }

    public Mono<Card> cardById(String id) {
        return repository.findById(id);
    }

    public Mono<String> deleteCardById(String id) {
        try {
            return repository.deleteById(id).then(Mono.just("Successfully deleted " + id));
        } catch (Exception e) {
            return Mono.just(e.getMessage());
        }
    }
}
