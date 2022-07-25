package org.example.api;

import co.com.game.model.Card;
import org.example.usecase.ProcessCardUseCase;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RestController
@RequestMapping("/card")
public class CardController {
    private final ProcessCardUseCase processCardUseCase;

    public CardController(ProcessCardUseCase processCardUseCase) {
        this.processCardUseCase = processCardUseCase;
    }

    @PostMapping("/create")
    public Mono<Card> createCard(@RequestBody Card card) {
        return processCardUseCase.saveCard(card);
    }

    @GetMapping("/all")
    public Flux<Card> allCards() {
        return processCardUseCase.allCards();
    }

    @GetMapping("/{id}")
    public Mono<Card> cardById(@PathVariable("id") String cardId) {
        return processCardUseCase.cardById(cardId);
    }

    @PutMapping("/update")
    public Mono<Card> updateCard(@RequestBody Card card) {
        return processCardUseCase.saveCard(card);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<String> deleteCardById(@PathVariable("id") String cardId) {
        return processCardUseCase.deleteCardById(cardId);
    }
}
