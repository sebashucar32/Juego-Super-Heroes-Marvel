package org.example.adapters.player;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

public interface PlayerDBRespository extends ReactiveMongoRepository<PlayerDocument, String>,
        ReactiveQueryByExampleExecutor<PlayerDocument> {
}
