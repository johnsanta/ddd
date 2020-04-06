package co.com.sofka.training.team.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.training.Name;

public class UpdatedName extends DomainEvent {
    private final Name newName;

    public Name getNewName() {
        return newName;
    }

    public UpdatedName(Name newName) {
        super("training.team.updatedname");
        this.newName = newName;
    }
}
