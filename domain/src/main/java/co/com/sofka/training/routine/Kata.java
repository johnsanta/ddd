package co.com.sofka.training.routine;


import co.com.sofka.domain.generic.Entity;
import co.com.sofka.training.routine.values.Challenge;
import co.com.sofka.training.routine.values.Exercise;
import co.com.sofka.training.routine.values.KataIdentity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Kata extends Entity<KataIdentity> {

    protected List<Exercise> exercises;
    protected Date limitOfTime;
    protected Challenge challenge;

    public Kata(KataIdentity entityId, Date limitOfTime, Challenge challenge, ArrayList<Exercise> exercises){
        this(entityId);
        this.limitOfTime = limitOfTime;
        this.challenge = challenge;
        this.exercises = exercises;
    }

    private Kata(KataIdentity entityId) {
        super(entityId);
    }

    public Kata(KataIdentity id, Date date, Challenge challenge) {
        super(id);
        this.limitOfTime = limitOfTime;
        this.challenge = challenge;
    }

    public void updateChallenge(Challenge challenge){
        this.challenge = challenge;
    }

    public void changeLimitOfTime(Date limitOfTime){
        this.limitOfTime = limitOfTime;

    }

    public void addNewExercise(Exercise exercise){
        this.exercises.add(exercise);
    }

    public void removeExercise(Exercise exercise){
        this.exercises.remove(exercise);
    }

    public static Kata from(KataIdentity kataIdentity, List<Exercise> exercises, Date limitOfTime, Challenge challenge){
        var kata = new Kata(kataIdentity);
        kata.exercises = exercises;
        kata.limitOfTime = limitOfTime;
        kata.challenge = challenge;
        return kata;
    }

}
