package co.com.sofka.example;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.Identity;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.ArrayList;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public abstract class AggregateEventTest<T extends Identity> {
    private static List<DomainEvent> domainEvents = new ArrayList<>();
    protected T identity;
    protected synchronized static List<DomainEvent> eventStore(){
        return domainEvents;
    }

    protected void setIdentity(T identity){
        this.identity = identity;
    }

    protected List<DomainEvent> saveEventsFor(AggregateEvent<?> team) {
        List<DomainEvent> events = team.getUncommittedChanges();
        events.forEach(eventStore()::add);//save change
        team.markChangesAsCommitted();
        return events;
    }
}
