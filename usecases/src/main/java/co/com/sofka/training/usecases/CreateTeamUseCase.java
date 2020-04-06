package co.com.sofka.training.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.training.Name;
import co.com.sofka.training.team.Team;
import co.com.sofka.training.team.values.TeamIdentity;

public class CreateTeamUseCase extends UseCase<CreateTeamUseCase.Request, ResponseEvents> {


    @Override
    public void executeUseCase(Request request) {
        try {
            var id = new TeamIdentity();
            var name = new Name(request.getName());
            var team = new Team(id, name);

            emit().onSuccess(new ResponseEvents(team.getUncommittedChanges()));
        }catch (RuntimeException e){
            emit().onError(new NullPointerException(""));
        }
    }

    public static class Request implements UseCase.RequestValues{

        private String name;


        public Request(String name){
            this.name = name;
        }


        public String getName() {
            return name;
        }
    }

}
