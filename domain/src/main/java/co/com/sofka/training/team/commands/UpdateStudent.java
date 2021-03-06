package co.com.sofka.training.team.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.training.team.values.DateOfBirth;
import co.com.sofka.training.team.values.Gender;
import co.com.sofka.training.team.values.StudentIdentity;
import co.com.sofka.training.team.values.TeamIdentity;
import co.com.sofka.training.Name;

public class UpdateStudent extends Command {

    private final TeamIdentity teamIdentity;
    private final StudentIdentity studentIdentity;

    public TeamIdentity getTeamIdentity() {
        return teamIdentity;
    }

    public StudentIdentity getStudentIdentity() {
        return studentIdentity;
    }

    private final Name name;
    private final Gender gender;
    private final DateOfBirth dateOfBirth;

    public UpdateStudent(TeamIdentity teamIdentity, StudentIdentity studentIdentity, Name name, Gender gender, DateOfBirth dateOfBirth) {
        super("training.team.updatestudent");
        this.teamIdentity = teamIdentity;
        this.studentIdentity = studentIdentity;
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    public UpdateStudent(TeamIdentity teamIdentity, StudentIdentity studentIdentity, Name name) {
        super("training.team.updatestudent.name");
        this.teamIdentity = teamIdentity;
        this.studentIdentity = studentIdentity;
        this.name = name;
        this.gender = null;
        this.dateOfBirth = null;
    }

    public UpdateStudent(TeamIdentity teamIdentity, StudentIdentity studentIdentity, Gender gender) {
        super("training.team.updatestudent.gender");
        this.teamIdentity = teamIdentity;
        this.studentIdentity = studentIdentity;
        this.name = null;
        this.gender = gender;
        this.dateOfBirth = null;
    }

    public UpdateStudent(TeamIdentity teamIdentity, StudentIdentity studentIdentity, DateOfBirth dateOfBirth) {
        super("training.team.updatestudent.dateofbirth");
        this.teamIdentity = teamIdentity;
        this.studentIdentity = studentIdentity;
        this.name = null;
        this.gender = null;
        this.dateOfBirth = dateOfBirth;
    }

    public Name getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public DateOfBirth getDateOfBirth() {
        return dateOfBirth;
    }
}
