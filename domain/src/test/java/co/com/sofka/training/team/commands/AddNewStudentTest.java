package co.com.sofka.training.team.commands;

import co.com.sofka.training.team.values.DateOfBirth;
import co.com.sofka.training.team.values.Gender;
import co.com.sofka.training.team.values.TeamIdentity;
import co.com.sofka.training.Name;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddNewStudentTest {

    @Test
    void addNewStudentCommand(){
        var addNewStudent = new AddNewStudent(
                TeamIdentity.of("xxx-yyy-zzz"),
                new Name("raul andres alzate"),
                new Gender(Gender.Type.M),
                new DateOfBirth(31,01,1996)
        );

        Assertions.assertEquals("training.team.addnewstudent", addNewStudent.type);

        Assertions.assertEquals(TeamIdentity.of("xxx-yyy-zzz"), addNewStudent.getTeamIdentity());
        Assertions.assertEquals("raul andres alzate", addNewStudent.getName().value());
        Assertions.assertEquals("M", addNewStudent.getGender().value());
    }
}