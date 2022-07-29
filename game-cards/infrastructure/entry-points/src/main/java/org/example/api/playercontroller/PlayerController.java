package org.example.api.playercontroller;

import co.com.game.model.Player;
import org.example.usecase.player.CreatePlayerUseCase;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Component
@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/player")
public class PlayerController {
  private final CreatePlayerUseCase createPlayerUseCase;

  public PlayerController(CreatePlayerUseCase createPlayerUseCase) {
    this.createPlayerUseCase = createPlayerUseCase;
  }

  @PostMapping("/create")
  public Mono<Player> createPlayer(@RequestBody Player player) {
    return createPlayerUseCase.create(player);
  }
}
