package org.example.adapters.player;

import co.com.game.model.Card;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.Set;

@Getter
@Setter
public class PlayerDocument {
    @Id
    private String id;
    private String name;
    private String email;
    private Double points;
    private Set<Card> cards;
}
