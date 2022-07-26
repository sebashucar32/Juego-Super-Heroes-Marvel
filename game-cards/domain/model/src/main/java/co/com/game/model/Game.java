package co.com.game.model;



import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
public class Game {
    private String id;
    private Boolean playing;

    private Set<String> players;

  public void addPlayer(String player) {
    this.players.add(player);
  }

}
