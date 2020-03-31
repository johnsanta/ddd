package co.com.sofka.example.routine.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.example.routine.values.Challenge;
import co.com.sofka.example.routine.values.Exercise;
import co.com.sofka.example.routine.values.KataIdentity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AddedKata extends DomainEvent {

    private final KataIdentity kataIdentity;
    private final ArrayList<Exercise> exercises;
    private final Date dateOfLimit;
    private final Challenge challenge;

    public AddedKata(KataIdentity kataIdentity, ArrayList<Exercise> exercises, Date dateOfLimit, Challenge challenge) {
        super("training.routine.AddedKata");
        this.kataIdentity = kataIdentity;
        this.exercises = exercises;
        this.dateOfLimit = dateOfLimit;
        this.challenge = challenge;
    }

    public KataIdentity getKataIdentity() {
        return kataIdentity;
    }

    public ArrayList<Exercise> getExercises() {
        return exercises;
    }

    public Date getDateOfLimit() {
        return dateOfLimit;
    }

    public Challenge getChallenge() {
        return challenge;
    }
}
