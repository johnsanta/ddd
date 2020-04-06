package co.com.sofka.training.team.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.training.team.values.Score;
import co.com.sofka.training.team.values.StudentIdentity;

public class UpdateScoreOfStudent extends DomainEvent {
    private final StudentIdentity studentIdentity;
    private final Score score;

    public UpdateScoreOfStudent(StudentIdentity studentIdentity, Score score) {
        super("training.team.updatescoreofstudent");
        this.studentIdentity = studentIdentity;
        this.score = score;
    }

    public StudentIdentity getStudentIdentity() {
        return studentIdentity;
    }

    public Score getScore() {
        return score;
    }
}
