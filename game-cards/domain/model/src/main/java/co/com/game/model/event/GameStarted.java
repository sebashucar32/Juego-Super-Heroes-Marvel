package co.com.game.model.event;


import co.com.game.model.Player;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Getter
@Setter
public class GameStarted extends DomainEvent {

    private final String id;
    private final Boolean playing;
    private final Set<Player> players;

    public GameStarted(String id, Boolean playing, Set<Player> players) {
        super("co.com.game.model.event.GameStarted");
        this.id = id;
        this.playing = playing;
        this.players = players;
    }
}
