package co.com.sofka.training.usecases.createStudent;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.training.Name;
import co.com.sofka.training.team.Team;

import co.com.sofka.training.team.values.DateOfBirth;
import co.com.sofka.training.team.values.Gender;
import co.com.sofka.training.team.values.TeamIdentity;


import java.util.List;


public class CreateStudentUseCase extends UseCase<CreateStudentRequest, ResponseEvents> {

    private final List<DomainEvent> storeEvents;

    public CreateStudentUseCase(List<DomainEvent> storeEvents){
        this.storeEvents = storeEvents;
    }

    @Override
    protected void executeUseCase(CreateStudentRequest createStudentRequest) {
        try {
            Team team;
            if(createStudentRequest.getTeamId()==null){
                var id = new TeamIdentity();
                team = new Team(id, new Name("team default"));
            } else {
                team = Team.from(TeamIdentity.of(createStudentRequest.getTeamId()), storeEvents);
            }

            team.addNewStudent(
                    new Name(createStudentRequest.getName()),
                    new Gender(Gender.Type.valueOf(createStudentRequest.getGender())),
                    new DateOfBirth(createStudentRequest.getDateOfBirthDay(), createStudentRequest.getDateOfBirthMonth(), createStudentRequest.getDateOfBirthYear())
            );

            emit().onSuccess(new ResponseEvents(team.getUncommittedChanges()));
        } catch (IllegalArgumentException e){
            emit().onError(e);
        }
    }


}
