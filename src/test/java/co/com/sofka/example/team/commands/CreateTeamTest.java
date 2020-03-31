package co.com.sofka.example.team.commands;


import co.com.sofka.generic.Name;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreateTeamTest {
    @Test
    void createTeamCommand(){
        var createTeam = new CreateTeam(
               new Name("the best team")
        );

        Assertions.assertEquals("training.team.createteam", createTeam.type);

        Assertions.assertEquals("the best team", createTeam.getName().value());
    }
}