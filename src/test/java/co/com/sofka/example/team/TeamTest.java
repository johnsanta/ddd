package co.com.sofka.example.team;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.example.AggregateEventTest;
import co.com.sofka.example.team.events.*;
import co.com.sofka.example.team.values.*;
import co.com.sofka.generic.Name;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

public class TeamTest extends AggregateEventTest<TeamIdentity> {

    @Test
    @Order(1)
    void newTeam(){
        identity = new TeamIdentity();
        Name name = new Name("my group");
        Team team = new Team(identity, name);

        List<DomainEvent> events = saveEventsFor(team);
        setIdentity(identity);
        CreatedTeam expected = new CreatedTeam( new Name("my group"), Set.of());
        CreatedTeam createdTeam = (CreatedTeam)events.get(0);

        Assertions.assertEquals(expected.getName(), createdTeam.getName());
        Assertions.assertEquals(expected.getStudents(), createdTeam.getStudents());
    }


    @ParameterizedTest
    @Order(2)
    @MethodSource("students")
    void addNewStudent(Student student) {
        //before
        Team team = Team.from(identity, eventStore());
        var counter = Integer.valueOf(team.students.size());

        //during
        team.addNewStudent(student.name, student.gender, student.dateOfBirth);
        List<DomainEvent> events = saveEventsFor(team);
        AddedStudent addedStudent = (AddedStudent) events.get(0);

        //after
        Assertions.assertEquals(counter+1, team.students.size());
        Assertions.assertEquals(student.name, addedStudent.getName());
        Assertions.assertEquals(student.dateOfBirth, addedStudent.getDateOfBirth());
        Assertions.assertEquals(student.gender, addedStudent.getGender());
    }


    @Test
    @Order(2)
    void updateStudent_name() {
        //before
        Team team = Team.from(identity, eventStore());
        Student student = team.students.stream()
                .filter(e -> e.name.value().equals("raul alzate"))
                .findFirst().orElseThrow();
        Assertions.assertEquals("raul alzate", student.name.value());

        //during
        team.updateStudentName(student.identity(), new Name("raul"));
        List<DomainEvent> events = saveEventsFor(team);

        UpdatedStudent updatedStudent = (UpdatedStudent) events.get(0);

        //after
        Student studentUpdate = team.students.stream()
                .filter(e -> e.name.value().equals("raul"))
                .findFirst().orElseThrow();

        Assertions.assertEquals("raul", studentUpdate.name.value());
        Assertions.assertEquals("raul", updatedStudent.getName().value());
    }


    @Test
    @Order(2)
    void applyScoreToStudent(){
        //before
        Team team = Team.from(identity, eventStore());
        Student student = team.students.stream()
                .filter(e -> e.name.value().equals("raul"))
                .findFirst().orElseThrow();
        Assertions.assertEquals("raul", student.name.value());

        //during
        team.applyScoreToStudent(student.identity(), new Score(10));
        List<DomainEvent> events = saveEventsFor(team);

        UpdateScoreOfStudent updateScoreOfStudent = (UpdateScoreOfStudent) events.get(0);

        //after
        Student studentUpdate = team.students.stream()
                .filter(e -> e.name.value().equals("raul"))
                .findFirst().orElseThrow();

        Assertions.assertEquals(10, updateScoreOfStudent.getScore().value().get("point"));
        Assertions.assertEquals(10, studentUpdate.score.value().get("point"));
    }

    @Test
    @Order(3)
     void updateName(){
        //before
        Team team = Team.from(identity, eventStore());
        Assertions.assertEquals("my group", team.name.value());

        //during
        team.updateName(new Name("changed name"));
        List<DomainEvent> events = saveEventsFor(team);
        UpdatedName updatedName = (UpdatedName) events.get(0);

        //after
        Assertions.assertEquals("changed name", team.name.value());
        Assertions.assertEquals("changed name", updatedName.getNewName().value());

    }


    @Test
    @Order(4)
     void removeStudent(){
        //before
        Team team = Team.from(identity, eventStore());
        Assertions.assertEquals(3,   team.students.size());

        Student student = team.students.stream().findFirst().orElseThrow();

        //during
        team.removeStudent(student.identity());
        List<DomainEvent> events = saveEventsFor(team);
        RemovedStudent removedStudent = (RemovedStudent) events.get(0);

        //after
        Assertions.assertEquals(student.identity(), removedStudent.getIdentity());
        Assertions.assertEquals(2,   team.students.size());
    }


    private static Stream<Student> students() {
        return Stream.of(
                newStudent("raul alzate", Gender.Type.M),
                newStudent("ana", Gender.Type.F),
                newStudent("camilo", Gender.Type.F)
        );
    }

    private static Student newStudent(String name, Gender.Type type){
        var id = new StudentIdentity();
        DateOfBirth dateOfBirth = new DateOfBirth(9, 3, 1988);
        return new Student(id, new Name(name), new Gender(type), dateOfBirth);
    }


}
