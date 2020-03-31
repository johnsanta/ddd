package co.com.sofka.example.team.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.example.team.values.Gender;
import co.com.sofka.example.team.values.TeamIdentity;
import co.com.sofka.generic.Name;

public class AddNewStudent extends Command {
    private final TeamIdentity teamIdentity;
    private final Name name;
    private final Gender gender;
    public AddNewStudent(TeamIdentity teamIdentity, Name name, Gender gender) {
        super("training.team.addnewstudent");
        this.teamIdentity = teamIdentity;
        this.name = name;
        this.gender = gender;
    }

    public TeamIdentity getTeamIdentity() {
        return teamIdentity;
    }

    public Name getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }
}
