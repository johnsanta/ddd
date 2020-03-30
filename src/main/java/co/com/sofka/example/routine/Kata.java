package co.com.sofka.example.routine;


import co.com.sofka.domain.generic.Entity;
import co.com.sofka.example.routine.values.Challenge;
import co.com.sofka.example.routine.values.Exercise;
import co.com.sofka.example.routine.values.KataId;

import java.util.Date;
import java.util.List;

public class Kata extends Entity<KataId> {

    protected List<Exercise> exercises;
    protected Date limitOfTime;
    protected Challenge challenge;

    public Kata(KataId entityId, Date limitOfTime, Challenge challenge){
        this(entityId);
        this.limitOfTime = limitOfTime;
        this.challenge = challenge;
    }

    private Kata(KataId entityId) {
        super(entityId);
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

    public static Kata from(KataId kataId, List<Exercise> exercises, Date limitOfTime, Challenge challenge){
        var kata = new Kata(kataId);
        kata.exercises = exercises;
        kata.limitOfTime = limitOfTime;
        kata.challenge = challenge;
        return kata;
    }

}
