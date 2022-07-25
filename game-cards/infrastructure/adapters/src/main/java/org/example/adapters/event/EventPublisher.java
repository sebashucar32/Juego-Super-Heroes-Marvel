package org.example.adapters.event;

import co.com.game.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class EventPublisher<T> {
    @Autowired
    private ApplicationEventPublisher publisher;

    public void publish(T entity) {
        publisher.publishEvent(new AuditEvent<T>(entity));
    }

    public void publish(Game game) {
        publisher.publishEvent(new AuditEvent<Game>(game));
    }
}
