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
}
