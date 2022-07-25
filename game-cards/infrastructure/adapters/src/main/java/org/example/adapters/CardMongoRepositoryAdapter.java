package org.example.adapters;

import co.com.game.model.Card;
import co.com.game.model.Game;
import co.com.game.model.gateway.CardRepository;
import org.example.adapters.game.GameDocument;
import org.example.adapters.helper.OperationAdapter;
import org.reactivecommons.utils.ObjectMapperI;
import org.springframework.stereotype.Repository;

@Repository
public class CardMongoRepositoryAdapter extends OperationAdapter<Card, CardDocument, String, CardMongoDBRepository> implements CardRepository {

    public CardMongoRepositoryAdapter(CardMongoDBRepository cardMongoDBRepository, ObjectMapperI mapper) {
        super(cardMongoDBRepository, mapper, d -> mapper.map(d, Card.class));
    }
}
