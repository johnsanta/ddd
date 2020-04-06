package co.com.sofka.training.team.queries;

import co.com.sofka.training.team.values.TeamIdentity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ByTeamIdentityTest {
    @Test
    public void byTeamIdentityQuery(){
        var byTeamIdentity = new ByTeamIdentity();
        byTeamIdentity.setTeamIdentity(TeamIdentity.of("aaaaa"));

        Assertions.assertEquals("aaaaa", byTeamIdentity.getTeamIdentity().value());
    }
}