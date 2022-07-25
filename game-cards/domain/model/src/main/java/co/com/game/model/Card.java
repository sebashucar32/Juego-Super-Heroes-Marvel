package co.com.game.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Card {
    private String id;
    private String name;
    private String description;

    private String url;
    private double poder;

    public Card() {

    }

    public Card(String id, String name, String description, String url, double poder) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.url = url;
        this.poder = poder;
    }
}
