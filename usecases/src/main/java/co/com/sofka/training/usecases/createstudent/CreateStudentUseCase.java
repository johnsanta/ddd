package co.com.sofka.training.usecases.createstudent;

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
    protected void executeUseCase(CreateStudentRequest request) {
        Team team = Team.from(TeamIdentity.of(request.getTeamId()), storeEvents);
        var studentCounter = team.students().size();

        if(studentCounter >= 5){
            emit().onError(new NoMoreStudentAllowed());
        } else {
            emit().onSuccess(aNewStudentAddedFor(team));
        }
    }

    private ResponseEvents aNewStudentAddedFor(Team team) {
        team.addNewStudent(
                new Name(request().getName()),
                new Gender(Gender.Type.valueOf(request().getGender())),
                new DateOfBirth(
                        request().getDateOfBirthDay(),
                        request().getDateOfBirthMonth(),
                        request().getDateOfBirthYear()
                )
        );
       return new ResponseEvents(team.getUncommittedChanges());
    }
}
