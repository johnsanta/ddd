package co.com.sofka.example.routine;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.EventBehavior;
import co.com.sofka.example.dojo.DojoId;
import co.com.sofka.example.routine.events.AddedKata;
import co.com.sofka.example.routine.events.CreatedRoutine;
import co.com.sofka.example.routine.values.Challenge;
import co.com.sofka.example.routine.values.KataIdentity;
import co.com.sofka.example.routine.values.Period;
import co.com.sofka.example.routine.values.RoutineIdentity;
import co.com.sofka.generic.Name;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Routine extends AggregateEvent<RoutineIdentity> {

    private final DojoId dojoId;
    protected Name name;
    protected List<Kata> katas;
    protected Period period;

    public Routine (RoutineIdentity routineId, DojoId dojoId, Name name){
        super(routineId);
        this.dojoId = dojoId;
        appendChange(new CreatedRoutine(name, new ArrayList<Kata>(), null)).apply();
    }

    private Routine(RoutineIdentity entityId, DojoId dojoId) {
        super(entityId);
        this.dojoId = dojoId;
        subscribe(new RoutineBehaviors(this));
    }

    public static Routine from(RoutineIdentity identity, List<DomainEvent> eventStore, DojoId dojoId) {
        Routine routine = new Routine(identity, dojoId);
        eventStore.forEach(routine::applyEvent);
        return routine;
    }

    public void addNewKata(Challenge challenge, Date limitOfTime){
        KataIdentity kataIdentity = new KataIdentity();
        appendChange(new AddedKata(kataIdentity, new ArrayList<>(), limitOfTime, challenge)).apply();
    }

    public static class RoutineBehaviors extends EventBehavior {
        protected RoutineBehaviors(Routine entity){
            give((CreatedRoutine event) -> {
                entity.name = event.getName();
                entity.katas = event.getKatas();
                entity.period = event.getPeriod();
            });

            give((AddedKata event)-> {
                var kata = new Kata(
                        event.getKataIdentity(),
                        event.getDateOfLimit(),
                        event.getChallenge(),
                        event.getExercises()
                );
                entity.katas.add(kata);
            });
        }
    }

}
