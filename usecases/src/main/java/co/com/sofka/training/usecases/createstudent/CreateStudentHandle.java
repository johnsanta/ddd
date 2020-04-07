package co.com.sofka.training.usecases.createstudent;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.training.team.commands.AddNewStudent;

import java.util.List;
import java.util.concurrent.Flow;
import java.util.function.Consumer;

public class CreateStudentHandle implements Consumer<AddNewStudent> {

    private Flow.Subscriber<? super DomainEvent> subscriberEvent;
    private final List<DomainEvent> domainEventList;

    public CreateStudentHandle(Flow.Subscriber<? super DomainEvent> subscriberEvent, List<DomainEvent> domainEventList){
        this.subscriberEvent = subscriberEvent;
        this.domainEventList = domainEventList;
    }

    @Override
    public void accept(AddNewStudent addNewStudent) {
        var name = addNewStudent.getName();
        var gender = addNewStudent.getGender();
        var dateOfBirth = addNewStudent.getDateOfBirth();
        var teamId = addNewStudent.getTeamIdentity();

        var request = CreateStudentRequest.CreateStudentRequestBuilder
                .aCreateStudentRequest()
                .withGender(gender.value())
               // .withDateOfBirthDay(dateOfBirth) TODO: se debe ajustar el VO.
                .withName(name.value())
                .withTeamId(teamId.value())
                .build();

        UseCaseHandler.getInstance()
                .asyncExecutor(new CreateStudentUseCase(domainEventList), request)
                .subscribe(subscriberEvent);
    }
}
