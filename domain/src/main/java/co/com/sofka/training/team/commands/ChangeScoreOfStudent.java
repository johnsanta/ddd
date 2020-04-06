package co.com.sofka.training.team.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.training.team.values.Score;
import co.com.sofka.training.team.values.StudentIdentity;
import co.com.sofka.training.team.values.TeamIdentity;

public class ChangeScoreOfStudent extends Command {

    private final TeamIdentity teamIdentity;
    private final StudentIdentity studentIdentity;
    private final Score score;

    public ChangeScoreOfStudent(TeamIdentity teamIdentity, StudentIdentity studentIdentity, Score score) {
        super("training.team.changescoreofstudent");
        this.teamIdentity = teamIdentity;
        this.studentIdentity = studentIdentity;
        this.score = score;
    }

    public TeamIdentity getTeamIdentity() {
        return teamIdentity;
    }

    public StudentIdentity getStudentIdentity() {
        return studentIdentity;
    }

    public Score getScore() {
        return score;
    }


}
