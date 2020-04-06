package co.com.sofka.training.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.training.Name;
import co.com.sofka.training.team.events.AddedStudent;
import co.com.sofka.training.team.events.CreatedTeam;
import co.com.sofka.training.usecases.createStudent.CreateStudentUseCase;
import co.com.sofka.training.usecases.createStudent.CreateStudentRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

public class CreateStudentUseCaseTest {

    @Test
    public void executeSuccess(){
        //preparar
        var usecase = new CreateStudentUseCase(Arrays.asList(
                new CreatedTeam(new Name("team name"), new HashSet<>())
        ));

        var request = new CreateStudentRequest();
        request.setDateOfBirthDay(9);
        request.setDateOfBirthMonth(3);
        request.setDateOfBirthYear(1988);
        request.setName("raul andres");
        request.setGender("M");
        request.setTeamId("xxx-xxx");

        //actuar
        var respose = UseCaseHandler.getInstance().syncExecutor(usecase, request);

        //verificar
        Assertions.assertTrue(respose.isPresent());
        respose.ifPresent((res) -> {
            var events = res.getDomainEvents();
            AddedStudent event = (AddedStudent)events.get(0);
            Assertions.assertEquals("xxx-xxx", event.aggregateRootId().value());
            Assertions.assertTrue(event.getStudentIdentity().value().length() > 8);
            Assertions.assertEquals("raul andres", event.getName().value());
            Assertions.assertEquals("M", event.getGender().value());
            Assertions.assertEquals("09-03-1988", event.getDateOfBirth().value());
        });

    }

    @Test
    public void executeError(){
        //preparar
        var usecase = new CreateStudentUseCase(Arrays.asList(
                new CreatedTeam(new Name("team name"), new HashSet<>())
        ));

        Assertions.assertThrows(RuntimeException.class, () -> {
            var request = new CreateStudentRequest();
            request.setName("");
            UseCaseHandler.getInstance().syncExecutor(usecase, request);
        });

        Assertions.assertThrows(RuntimeException.class, () -> {
            var request = new CreateStudentRequest();
            request.setGender("");
            UseCaseHandler.getInstance().syncExecutor(usecase, request);
        });

    }

}
