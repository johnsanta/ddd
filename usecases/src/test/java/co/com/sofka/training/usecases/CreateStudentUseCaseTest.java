package co.com.sofka.training.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.training.Name;
import co.com.sofka.training.team.events.AddedStudent;
import co.com.sofka.training.team.events.CreatedTeam;
import co.com.sofka.training.team.values.DateOfBirth;
import co.com.sofka.training.team.values.Gender;
import co.com.sofka.training.team.values.StudentIdentity;
import co.com.sofka.training.usecases.createstudent.CreateStudentUseCase;
import co.com.sofka.training.usecases.createstudent.CreateStudentRequest;
import co.com.sofka.training.usecases.createstudent.NoMoreStudentAllowed;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

public class CreateStudentUseCaseTest {

    @Test
    @DisplayName("a new student is added")
    public void executeSuccess(){
        //arrange
        var usecase = new CreateStudentUseCase(Arrays.asList(
                new CreatedTeam(new Name("team name"), new HashSet<>()),
                new AddedStudent(
                        StudentIdentity.of("xxx-xxx-111"),
                        new Name("student 1"),
                        new Gender(Gender.Type.M), new DateOfBirth(9,3,1988)
                )
        ));

        var request = CreateStudentRequest.CreateStudentRequestBuilder.aCreateStudentRequest()
                .withDateOfBirthDay(9)
                .withDateOfBirthMonth(3)
                .withDateOfBirthYear(1988)
                .withGender("M")
                .withName("raul andres")
                .withTeamId("xxx-xxx")
                .build();

        //act
        var response = UseCaseHandler.getInstance().syncExecutor(usecase, request);

        //assert
        Assertions.assertTrue(response.isPresent());
        response.ifPresent((res) -> {
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
    @DisplayName("valid error when the size has been overcome")
    public void executeError(){
        var usecase = new CreateStudentUseCase(Arrays.asList(
                new CreatedTeam(new Name("team name"), new HashSet<>()),
                new AddedStudent(
                        StudentIdentity.of("xxx-xxx-111"),
                        new Name("student 1"),
                        new Gender(Gender.Type.M), new DateOfBirth(9,3,1988)
                ),
                new AddedStudent(
                        StudentIdentity.of("xxx-xxx-222"),
                        new Name("student 2"),
                        new Gender(Gender.Type.M), new DateOfBirth(9,3,1988)
                ),
                new AddedStudent(
                        StudentIdentity.of("xxx-xxx-333"),
                        new Name("student 3"),
                        new Gender(Gender.Type.M), new DateOfBirth(9,3,1988)
                ), new AddedStudent(
                        StudentIdentity.of("xxx-xxx-444"),
                        new Name("student 4"),
                        new Gender(Gender.Type.M), new DateOfBirth(9,3,1988)
                ),
                new AddedStudent(
                        StudentIdentity.of("xxx-xxx-555"),
                        new Name("student 5"),
                        new Gender(Gender.Type.M), new DateOfBirth(9,3,1988)
                )
        ));

        Assertions.assertThrows(NoMoreStudentAllowed.class, () -> {
            var request = CreateStudentRequest.CreateStudentRequestBuilder.aCreateStudentRequest()
                    .withDateOfBirthDay(9)
                    .withDateOfBirthMonth(3)
                    .withDateOfBirthYear(1988)
                    .withGender("M")
                    .withName("raul andres")
                    .withTeamId("xxx-xxx")
                    .build();
            UseCaseHandler.getInstance().syncExecutor(usecase, request);
        });

    }

}
