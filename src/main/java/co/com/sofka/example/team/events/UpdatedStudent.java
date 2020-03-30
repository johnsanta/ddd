package co.com.sofka.example.team.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.generic.Name;
import co.com.sofka.example.team.values.StudentIdentity;

public class UpdatedStudent extends DomainEvent {

    private final StudentIdentity studentIdentity;
    private final Name name;

    public UpdatedStudent(StudentIdentity studentIdentity, Name name) {
        super("training.team.updatedstudent");

        this.studentIdentity = studentIdentity;
        this.name = name;
    }

    public StudentIdentity getStudentIdentity() {
        return studentIdentity;
    }

    public Name getName() {
        return name;
    }
}
