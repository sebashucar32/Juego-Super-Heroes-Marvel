package org.example.adapters.game;

import co.com.game.model.Player;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Data
@Document
public class GameDocument {
    @Id
    private String id;
    private Boolean playing;
    private Set<Player> players;
}
