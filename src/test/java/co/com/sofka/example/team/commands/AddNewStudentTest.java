package co.com.sofka.example.team.commands;

import co.com.sofka.example.team.values.Gender;
import co.com.sofka.example.team.values.TeamIdentity;
import co.com.sofka.generic.Name;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddNewStudentTest {

    @Test
    void addNewStudentCommand(){
        var addNewStudent = new AddNewStudent(
                TeamIdentity.of("xxx-yyy-zzz"),
                new Name("raul andres alzate"),
                new Gender(Gender.Type.M)
        );

        Assertions.assertEquals("training.team.addnewstudent", addNewStudent.type);

        Assertions.assertEquals(TeamIdentity.of("xxx-yyy-zzz"), addNewStudent.getTeamIdentity());
        Assertions.assertEquals("raul andres alzate", addNewStudent.getName().value());
        Assertions.assertEquals("M", addNewStudent.getGender().value());
    }
}