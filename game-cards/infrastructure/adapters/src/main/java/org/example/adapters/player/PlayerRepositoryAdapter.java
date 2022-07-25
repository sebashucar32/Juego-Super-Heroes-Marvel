package org.example.adapters.player;

import co.com.game.model.Player;
import co.com.game.model.gateway.PlayerRepository;
import org.example.adapters.helper.OperationAdapter;
import org.reactivecommons.utils.ObjectMapperI;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

public class PlayerRepositoryAdapter extends OperationAdapter<Player, PlayerDocument, String, PlayerDBRespository> implements PlayerRepository {
    private final ReactiveMongoTemplate mongoTemplate;
    public PlayerRepositoryAdapter(PlayerDBRespository repository, ObjectMapperI mapper, ReactiveMongoTemplate mongoTemplate) {
        super(repository, mapper, d -> mapper.map(d, Player.class));

        this.mongoTemplate = mongoTemplate;
    }
}
