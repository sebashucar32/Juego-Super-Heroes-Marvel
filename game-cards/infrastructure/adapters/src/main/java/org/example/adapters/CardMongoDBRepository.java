package org.example.adapters;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CardMongoDBRepository extends ReactiveCrudRepository<CardDocument, String> { }
