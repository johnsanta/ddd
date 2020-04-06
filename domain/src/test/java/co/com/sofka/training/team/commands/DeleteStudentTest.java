package co.com.sofka.training.team.commands;

import co.com.sofka.training.team.values.StudentIdentity;
import co.com.sofka.training.team.values.TeamIdentity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class DeleteStudentTest {
    @Test
    void deleteStudentCommand(){
        var deleteStudent = new DeleteStudent(
                TeamIdentity.of("xxx-yyy-zzz"),
                StudentIdentity.of("yyy-fff-xxx")
        );

        Assertions.assertEquals("training.team.deletestudent", deleteStudent.type);

        Assertions.assertEquals(TeamIdentity.of("xxx-yyy-zzz"), deleteStudent.getTeamIdentity());
        Assertions.assertEquals(StudentIdentity.of("yyy-fff-xxx"), deleteStudent.getStudentIdentity());
    }
}