package co.com.sofka.training.usecases;


import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.training.team.events.CreatedTeam;
import co.com.sofka.training.usecases.createteam.CreateTeamUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



public class CreateTeamUseCaseTest {

    @Test
    @DisplayName("a new team is created")
    public void execute(){
        var usecase = new CreateTeamUseCase();
        var request = new CreateTeamUseCase.Request("dream team");

        var response = UseCaseHandler.getInstance().syncExecutor(usecase, request);

        Assertions.assertTrue(response.isPresent());
        response.ifPresent(res -> {
            var event = (CreatedTeam)res.getDomainEvents().get(0);
            Assertions.assertEquals("dream team", event.getName().value());
        });
    }
}