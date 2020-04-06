package co.com.sofka.training.team.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.training.team.values.StudentIdentity;
import co.com.sofka.training.team.values.TeamIdentity;

public class DeleteStudent extends Command {
    private final TeamIdentity teamIdentity;
    private final StudentIdentity studentIdentity;

    public DeleteStudent(TeamIdentity teamIdentity, StudentIdentity studentIdentity) {
        super("training.team.deletestudent");
        this.teamIdentity = teamIdentity;
        this.studentIdentity = studentIdentity;
    }

    public TeamIdentity getTeamIdentity() {
        return teamIdentity;
    }

    public StudentIdentity getStudentIdentity() {
        return studentIdentity;
    }
}
