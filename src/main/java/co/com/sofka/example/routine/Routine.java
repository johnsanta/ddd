package co.com.sofka.example.routine;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.example.dojo.DojoId;
import co.com.sofka.example.routine.values.Period;
import co.com.sofka.example.routine.values.RoutineId;
import co.com.sofka.generic.Name;

import java.util.List;

public class Routine extends AggregateEvent<RoutineId> {

    private final DojoId dojoId;
    private Name name;
    private List<Kata> katas;
    private Period period;

    private Routine(RoutineId entityId, DojoId dojoId) {
        super(entityId);
        this.dojoId = dojoId;
    }
}
