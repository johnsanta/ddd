package co.com.sofka.example.team.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.generic.Name;

public class CreateTeam extends Command {
    private final Name name;

    protected CreateTeam(Name name) {
        super("training.team.createteam");
        this.name = name;
    }

    public Name getName() {
        return name;
    }


}
