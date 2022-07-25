package co.com.game.model.event;

public class DomainEvent {
    private final String type;

    public DomainEvent(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }
}
