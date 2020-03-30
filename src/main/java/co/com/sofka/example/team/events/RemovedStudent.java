package co.com.sofka.example.team.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.example.team.Student;
import co.com.sofka.example.team.values.StudentIdentity;

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
