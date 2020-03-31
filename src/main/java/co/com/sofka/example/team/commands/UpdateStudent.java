package co.com.sofka.example.team.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.example.team.values.DateOfBirth;
import co.com.sofka.example.team.values.Gender;
import co.com.sofka.example.team.values.StudentIdentity;
import co.com.sofka.example.team.values.TeamIdentity;
import co.com.sofka.generic.Name;

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
       this(teamIdentity, studentIdentity, name, null, null);
    }

    public UpdateStudent(TeamIdentity teamIdentity, StudentIdentity studentIdentity, Gender gender) {
        this(teamIdentity, studentIdentity, null, gender, null);
    }

    public UpdateStudent(TeamIdentity teamIdentity, StudentIdentity studentIdentity, DateOfBirth dateOfBirth) {
        this(teamIdentity, studentIdentity, null, null, dateOfBirth);
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
