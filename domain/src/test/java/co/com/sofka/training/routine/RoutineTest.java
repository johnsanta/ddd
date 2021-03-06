package co.com.sofka.training.routine;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.training.AggregateEventTest;
import co.com.sofka.training.dojo.DojoId;
import co.com.sofka.training.routine.events.AddedKata;
import co.com.sofka.training.routine.events.CreatedRoutine;
import co.com.sofka.training.Name;
import co.com.sofka.training.routine.values.Challenge;
import co.com.sofka.training.routine.values.KataIdentity;
import co.com.sofka.training.routine.values.RoutineIdentity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public class RoutineTest extends AggregateEventTest<RoutineIdentity> {

    static DojoId dojoId;

    @Test
    @Order(1)
    void createRoutine() {
        identity = new RoutineIdentity();
        dojoId = new DojoId();
        Name name = new Name("Routine 1");
        Routine routine = new Routine(identity, dojoId, name);

        List<DomainEvent> listevent = saveEventsFor(routine);
        setIdentity(identity);

        CreatedRoutine expected = new CreatedRoutine(new Name("Routine 1"), new ArrayList<>(), null);
        CreatedRoutine createdRoutine = (CreatedRoutine) listevent.get(0);

        Assertions.assertEquals(expected.getName().value(), createdRoutine.getName().value());
        Assertions.assertEquals(expected.getPeriod(), createdRoutine.getPeriod());

    }

    @ParameterizedTest
    @MethodSource("katas")
    void addNewKata(Kata kata) {
        //before
        Routine routine = Routine.from(identity, eventStore(), dojoId);
        var count = Integer.valueOf(routine.katas.size());

        //during
        routine.addNewKata(kata.challenge, kata.limitOfTime);
        List<DomainEvent> listEvent = saveEventsFor(routine);
        AddedKata addedKata = (AddedKata) listEvent.get(0);

        //after
        Assertions.assertEquals(count + 1, routine.katas.size());
        Assertions.assertEquals("training.routine.AddedKata", addedKata.type);
        Assertions.assertEquals(kata.limitOfTime, addedKata.getDateOfLimit());
        Assertions.assertEquals(kata.challenge.value().get("description"), addedKata.getChallenge().value().get("description"));
        Assertions.assertEquals(kata.challenge.value().get("url"), addedKata.getChallenge().value().get("url"));
        Assertions.assertEquals(kata.challenge.value().get("urlSolution"), addedKata.getChallenge().value().get("urlSolution"));

    }

    private static Stream<Kata> katas() {
        return Stream.of(
                newKata("Do a hello World", "https://helloWorld.co", "https://yourExercise.co"),
                newKata("Do a store program", "https://helloStore.co", "https://yourStore.co")
        );
    }

    private static Kata newKata(String description, String urlSolution, String url) {
        var id = new KataIdentity();
        Challenge challenge = new Challenge(description, urlSolution, url);
        Date limitOfTime = new Date(120, 5, 19);
        return new Kata(id, limitOfTime, challenge, new ArrayList<>());
    }

}
