package co.com.sofka.training.team.queries;


import co.com.sofka.training.team.values.StudentIdentity;
import co.com.sofka.training.team.values.TeamIdentity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ByStudentIdentityTest {

    @Test
    public void byStudentIdentityQuery(){
        var byStudentIdentity = new ByStudentIdentity();
        byStudentIdentity.setStudentIdentity(StudentIdentity.of("aaaaa"));
        byStudentIdentity.setTeamIdentity(TeamIdentity.of("bbbbb"));

        Assertions.assertEquals("aaaaa", byStudentIdentity.getStudentIdentity().value());
        Assertions.assertEquals("bbbbb", byStudentIdentity.getTeamIdentity().value());
    }
}