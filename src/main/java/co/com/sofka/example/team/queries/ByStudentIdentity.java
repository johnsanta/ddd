package co.com.sofka.example.team.queries;

import co.com.sofka.domain.generic.Query;
import co.com.sofka.example.team.values.StudentIdentity;
import co.com.sofka.example.team.values.TeamIdentity;

public class ByStudentIdentity implements Query {
    private TeamIdentity teamIdentity;
    private StudentIdentity studentIdentity;

    public TeamIdentity getTeamIdentity() {
        return teamIdentity;
    }

    public void setTeamIdentity(TeamIdentity teamIdentity) {
        this.teamIdentity = teamIdentity;
    }

    public StudentIdentity getStudentIdentity() {
        return studentIdentity;
    }

    public void setStudentIdentity(StudentIdentity studentIdentity) {
        this.studentIdentity = studentIdentity;
    }
}
