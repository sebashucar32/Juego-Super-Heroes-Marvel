package org.example.api;

import co.com.game.model.Card;
import co.com.game.model.Player;
import org.example.usecase.game.CreatePlayerUseCase;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Component
@RestController
@RequestMapping("/player")
public class PlayerController {
    private final CreatePlayerUseCase createPlayerUseCase;


    public PlayerController(CreatePlayerUseCase createPlayerUseCase) {
        this.createPlayerUseCase = createPlayerUseCase;
    }

    @PostMapping("/create")
    public Mono<Player> createCard(@RequestBody Player player) {
        return createPlayerUseCase.create(player);
    }
}
