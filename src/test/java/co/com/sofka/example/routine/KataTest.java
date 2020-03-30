package co.com.sofka.example.routine;

import co.com.sofka.example.routine.values.Challenge;
import co.com.sofka.example.routine.values.KataId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class KataTest {

    @Test
    public void newKata(){
        var id = new KataId();
        var challenge = new Challenge("hacer ddd", "https://google.com", null);
        var kata = new Kata(id, new Date(), challenge);

        Assertions.assertEquals("hacer ddd", kata.challenge.value().get("description"));
        Assertions.assertEquals("https://google.com", kata.challenge.value().get("urlSolution"));
    }

    @Test
    public void newKata_as_invalid(){
        var id = new KataId();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            var challenge = new Challenge("hacer ddd", "url", null);
            new Kata(id, new Date(), challenge);
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            var challenge = new Challenge("", "https://google.com", null);
            new Kata(id, new Date(), challenge);
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            var challenge = new Challenge("descripcion", "https://google.com", "url");
            new Kata(id, new Date(), challenge);
        });

    }

    @Test
    void updateChallenge() {

    }

    @Test
    void changeLimitOfTime() {
    }

    @Test
    void addNewExercise() {
    }

    @Test
    void removeExercise() {
    }
}