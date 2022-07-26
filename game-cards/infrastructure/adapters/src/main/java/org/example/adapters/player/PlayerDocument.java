package org.example.adapters.player;

import co.com.game.model.Card;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Set;

@Document
@Getter
@Setter
public class PlayerDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String name;
    private String email;
    private Double points;
    private Set<Card> cards;
}
