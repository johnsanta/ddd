package co.com.sofka.example.team.commands;

import co.com.sofka.example.team.values.TeamIdentity;
import co.com.sofka.generic.Name;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class UpdateTeamTest {
    @Test
    void updateTeamCommand(){
        var updateTeam = new UpdateTeam(
                TeamIdentity.of("xxx-yyy-zzz"),
                new Name("the best team plus")
        );

        Assertions.assertEquals("training.team.updateteam", updateTeam.type);

        Assertions.assertEquals(TeamIdentity.of("xxx-yyy-zzz"), updateTeam.getTeamIdentity());
        Assertions.assertEquals("the best team plus", updateTeam.getName().value());
    }
}