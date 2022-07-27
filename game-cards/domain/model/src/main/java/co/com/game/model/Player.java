package co.com.game.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
public class Player {
    private String id;
    private String email;
    private Set<Card> cards;

    public void addPlayer(Card card) {
      this.cards.add(card);
    }
}
