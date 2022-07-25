package org.example.api.gamecontroller;

import co.com.game.model.Game;
import co.com.game.model.event.DomainEvent;
import org.example.adapters.event.EventPublisher;
import org.example.api.gamecontroller.GameHandler;
import org.example.usecase.game.CreateGameUseCase;
import org.example.usecase.game.StartGameUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Component
@RestController
@RequestMapping("/game")
public class GameController {
    @Autowired
    private final EventPublisher<DomainEvent> publisher;
   private final CreateGameUseCase createGameUseCase;

   private final StartGameUseCase startGameUseCase;


    public GameController(EventPublisher<DomainEvent> publisher, CreateGameUseCase createGameUseCase, StartGameUseCase startGameUseCase) {
        this.publisher = publisher;
        this.createGameUseCase = createGameUseCase;
        this.startGameUseCase = startGameUseCase;
    }

    @Bean
    public RouterFunction<ServerResponse> gameRouterFunction(GameHandler gameHandler) {
        return route(POST("/game"), gameHandler::createGame)
                .andRoute(POST("/game/start/{gameId}"), gameHandler::startGame);
    }
}
