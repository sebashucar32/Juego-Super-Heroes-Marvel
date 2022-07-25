package org.example.adapters.game;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

public interface GameDBRepository extends ReactiveMongoRepository<GameDocument, String>, ReactiveQueryByExampleExecutor<GameDocument> {
}
