package org.example.api.gamecontroller;



import co.com.game.model.Game;

import co.com.game.model.event.DomainEvent;

import lombok.RequiredArgsConstructor;
import org.example.adapters.event.EventPublisher;
import org.example.usecase.game.CreateGameUseCase;
import org.example.usecase.game.StartGameUseCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;



@Component
@RequiredArgsConstructor
public class GameHandler {
    @Autowired
    private final EventPublisher<DomainEvent> publisher;
    private final CreateGameUseCase createGameUseCase;
    private final StartGameUseCase startGameUseCase;

    public Mono<ServerResponse> createGame(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(Game.class)
                .flatMap(createGameUseCase::createGame)
                .flatMap(game -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromValue(game)));
    }

    public Mono<ServerResponse> startGame(ServerRequest serverRequest) {
        String gameId = serverRequest.pathVariable("gameId");
        Mono<Game> request = startGameUseCase.gameById(gameId)
                .flatMap(startGameUseCase::startGame);

        request.subscribe(publisher::publish);

        return request.flatMap(game -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(game)));
    }
}
