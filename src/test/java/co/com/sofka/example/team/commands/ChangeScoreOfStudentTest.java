package co.com.sofka.example.team.commands;


import co.com.sofka.example.team.values.Score;
import co.com.sofka.example.team.values.StudentIdentity;
import co.com.sofka.example.team.values.TeamIdentity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ChangeScoreOfStudentTest {

    @Test
    void changeScoreOfStudentCommand(){
        var changeScoreOfStudent = new ChangeScoreOfStudent(
                TeamIdentity.of("xxx-yyy-zzz"),
                StudentIdentity.of("yyy-fff-xxx"),
                new Score(12)
        );

        Assertions.assertEquals("training.team.changescoreofstudent", changeScoreOfStudent.type);

        Assertions.assertEquals(TeamIdentity.of("xxx-yyy-zzz"), changeScoreOfStudent.getTeamIdentity());
        Assertions.assertEquals(StudentIdentity.of("yyy-fff-xxx"), changeScoreOfStudent.getStudentIdentity());
        Assertions.assertEquals(12, changeScoreOfStudent.getScore().value().get("point"));
    }
}