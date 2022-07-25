package co.com.game.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
public class Player {
    private String id;
    private String name;
    private String email;
    private Double points;
    private Set<Card> cards;

    public Player(String id, String name, String email, Set<Card> cards) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.points = 0.0;
        this.cards = cards;
    }
}
