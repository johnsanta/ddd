package co.com.sofka.example.team;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.EventBehavior;
import co.com.sofka.domain.generic.Identity;
import co.com.sofka.example.team.events.*;
import co.com.sofka.example.team.values.*;
import co.com.sofka.generic.Name;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Team extends AggregateEvent<TeamIdentity> {
    protected Name name;
    protected Set<Student> students;

    public Team(TeamIdentity identity, Name name) {
        this(identity);
        appendChange(new CreatedTeam(name, new HashSet<>())).apply();
    }

    private Team(TeamIdentity identity){
        super(identity);
        subscribe(new TeamBehavior(this));
    }

    public static Team from(TeamIdentity aggregateId, List<DomainEvent> list){
        Team team = new Team(aggregateId);
        list.forEach(team::applyEvent);
        return team;
    }

    public void addNewStudent(Name name, Gender gender, DateOfBirth dateOfBirth) {
        StudentIdentity studentIdentity = new StudentIdentity();
        appendChange(new AddedStudent(studentIdentity, name,  gender,  dateOfBirth)).apply();
    }

    public void removeStudent(StudentIdentity studentIdentity){
        appendChange(new RemovedStudent(studentIdentity)).apply();
    }

    public void updateName(Name newName) {
        appendChange(new UpdatedName(newName)).apply();
    }

    public void updateStudentName(StudentIdentity studentIdentity, Name name) {
        appendChange(new UpdatedStudent( studentIdentity,  name)).apply();
    }

    public void applyScoreToStudent(StudentIdentity studentIdentity, Score score) {
        appendChange(new UpdateScoreOfStudent( studentIdentity, score)).apply();
    }


    public static class TeamBehavior extends EventBehavior {
        protected TeamBehavior(Team entity) {
            give((CreatedTeam event) -> {
                entity.students = event.getStudents();
                entity.name = event.getName();
            });

            give((AddedStudent event) -> {
                var student = new Student(
                        event.getStudentIdentity(),
                        event.getName(),
                        event.getGender(),
                        event.getDateOfBirth()
                );
                entity.students.add(student);
            });

            give((RemovedStudent event) -> entity.students
                    .removeIf(e -> e.identity().equals(event.getIdentity())));

            give((UpdatedName event) -> entity.name = event.getNewName());

            give((UpdatedStudent event) -> {
                 var studentUpdate = getStudentByIdentity(entity, event.getStudentIdentity());
                 studentUpdate.updateName(event.getName());
              });

            give((UpdateScoreOfStudent event) -> {
                var studentUpdate = getStudentByIdentity(entity, event.getStudentIdentity());
                studentUpdate.updateScore(event.getScore());
            });
        }

        private Student getStudentByIdentity(Team entity, Identity identity) {
            return entity.students.stream()
                    .filter(e -> e.identity().equals(identity))
                    .findFirst()
                    .orElseThrow();
        }
    }
}
