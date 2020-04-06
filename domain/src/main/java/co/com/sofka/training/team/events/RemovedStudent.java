package co.com.sofka.training.team.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.training.team.values.StudentIdentity;

public class RemovedStudent extends DomainEvent {

    private final StudentIdentity identity;

    public RemovedStudent(StudentIdentity identity) {
        super("training.team.removedstudent");
        this.identity = identity;
    }

    public StudentIdentity getIdentity() {
        return identity;
    }
}
