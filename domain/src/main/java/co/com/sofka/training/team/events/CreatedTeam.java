package co.com.sofka.training.team.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.training.team.Student;
import co.com.sofka.training.Name;

import java.util.Set;

public class CreatedTeam extends DomainEvent {
    private final Name name;
    private final transient Set<Student> students;

    public CreatedTeam(Name name, Set<Student> students) {
        super("training.team.createdteam");
        this.name = name;
        this.students = students;
    }

    public Name getName() {
        return name;
    }

    public Set<Student> getStudents() {
        return students;
    }
}
