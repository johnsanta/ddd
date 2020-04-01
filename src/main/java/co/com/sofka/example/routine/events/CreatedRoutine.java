package co.com.sofka.example.routine.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.example.routine.Kata;
import co.com.sofka.example.routine.values.Period;
import co.com.sofka.generic.Name;

import java.util.ArrayList;
import java.util.List;

public class CreatedRoutine extends DomainEvent {

    private final Name name;
    private final List<Kata> katas;
    private final Period period;

    public CreatedRoutine(Name name, ArrayList<Kata> katas, Period period) {
        super("training.routine.createdRoutine");
        this.name = name;
        this.katas = katas;
        this.period = period;
    }

    public Name getName() {
        return name;
    }

    public List<Kata> getKatas() {
        return katas;
    }

    public Period getPeriod() {
        return period;
    }
}
