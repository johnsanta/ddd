package co.com.sofka.training.usecases.createteam;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.training.team.commands.CreateTeam;

import java.util.concurrent.Flow;
import java.util.function.Consumer;

public class CreateTeamHandle implements Consumer<CreateTeam> {
    private Flow.Subscriber<? super DomainEvent> subscriberEvent;

    public CreateTeamHandle(Flow.Subscriber<? super DomainEvent> subscriberEvent){
        this.subscriberEvent = subscriberEvent;
    }

    @Override
    public void accept(CreateTeam createTeam) {
        var name = createTeam.getName();
        var request = new CreateTeamUseCase.Request(name.value());
        UseCaseHandler.getInstance()
                .asyncExecutor(new CreateTeamUseCase(), request)
                .subscribe(subscriberEvent);
    }
}
