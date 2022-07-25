package org.example.adapters.game;

import co.com.game.model.Card;
import co.com.game.model.Game;
import co.com.game.model.Player;
import co.com.game.model.gateway.GameRepository;
import com.google.gson.Gson;
import org.bson.types.ObjectId;
import org.example.adapters.helper.OperationAdapter;
import org.json.JSONObject;
import org.reactivecommons.utils.ObjectMapperI;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.data.mongodb.core.aggregation.UnwindOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Predicate;
import java.util.stream.Collectors;


@Repository
public class GameRepositoryAdapter extends OperationAdapter<Game, GameDocument, String, GameDBRepository> implements GameRepository {
    private final ReactiveMongoTemplate mongoTemplate;
    private static final String COLLECTION = "gameDocument";

    public GameRepositoryAdapter(GameDBRepository repository, ObjectMapperI mapper, ReactiveMongoTemplate mongoTemplate) {
        super(repository, mapper, d -> mapper.map(d, Game.class));

        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Mono<Game> findByGameId(String gameId) {
        return null;
    }
}
