package co.com.sofka.example.team.commands;


import co.com.sofka.example.team.values.DateOfBirth;
import co.com.sofka.example.team.values.Gender;
import co.com.sofka.example.team.values.StudentIdentity;
import co.com.sofka.example.team.values.TeamIdentity;
import co.com.sofka.generic.Name;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UpdateStudentTest {
    @Test
    void updateStudentCommand(){
        var updateStudent = new UpdateStudent(
                TeamIdentity.of("xxx-yyy-zzz"),
                StudentIdentity.of("yyy-fff-xxx"),
                new Name("raul andres alzate"),
                new Gender(Gender.Type.M),
                new DateOfBirth(9,3,1988)
        );

        Assertions.assertEquals("training.team.updatestudent", updateStudent.type);

        Assertions.assertEquals(TeamIdentity.of("xxx-yyy-zzz"), updateStudent.getTeamIdentity());
        Assertions.assertEquals(StudentIdentity.of("yyy-fff-xxx"), updateStudent.getStudentIdentity());
        Assertions.assertEquals("raul andres alzate", updateStudent.getName().value());
        Assertions.assertEquals("M", updateStudent.getGender().value());
        Assertions.assertEquals("09-03-1988", updateStudent.getDateOfBirth().value());
    }

    @Test
    void updateStudentCommandForName(){
        var updateStudent = new UpdateStudent(
                TeamIdentity.of("xxx-yyy-zzz"),
                StudentIdentity.of("yyy-fff-xxx"),
                new Name("raul andres alzate")
        );

        Assertions.assertEquals("training.team.updatestudent.name", updateStudent.type);

        Assertions.assertEquals(TeamIdentity.of("xxx-yyy-zzz"), updateStudent.getTeamIdentity());
        Assertions.assertEquals(StudentIdentity.of("yyy-fff-xxx"), updateStudent.getStudentIdentity());
        Assertions.assertEquals("raul andres alzate", updateStudent.getName().value());
        Assertions.assertNull(updateStudent.getGender());
        Assertions.assertNull(updateStudent.getDateOfBirth());
    }

    @Test
    void updateStudentCommandForGender(){
        var updateStudent = new UpdateStudent(
                TeamIdentity.of("xxx-yyy-zzz"),
                StudentIdentity.of("yyy-fff-xxx"),
                new Gender(Gender.Type.M)
        );

        Assertions.assertEquals("training.team.updatestudent.gender", updateStudent.type);

        Assertions.assertEquals(TeamIdentity.of("xxx-yyy-zzz"), updateStudent.getTeamIdentity());
        Assertions.assertEquals(StudentIdentity.of("yyy-fff-xxx"), updateStudent.getStudentIdentity());
        Assertions.assertNull(updateStudent.getName());
        Assertions.assertEquals("M", updateStudent.getGender().value());
        Assertions.assertNull(updateStudent.getDateOfBirth());
    }

    @Test
    void updateStudentCommandForDateOfBirth(){
        var updateStudent = new UpdateStudent(
                TeamIdentity.of("xxx-yyy-zzz"),
                StudentIdentity.of("yyy-fff-xxx"),
                new DateOfBirth(9,3,1988)
        );

        Assertions.assertEquals("training.team.updatestudent.dateofbirth", updateStudent.type);

        Assertions.assertEquals(TeamIdentity.of("xxx-yyy-zzz"), updateStudent.getTeamIdentity());
        Assertions.assertEquals(StudentIdentity.of("yyy-fff-xxx"), updateStudent.getStudentIdentity());
        Assertions.assertNull(updateStudent.getName());
        Assertions.assertNull(updateStudent.getGender());
        Assertions.assertEquals("09-03-1988", updateStudent.getDateOfBirth().value());
    }
}