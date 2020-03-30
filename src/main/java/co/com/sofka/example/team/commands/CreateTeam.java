package co.com.sofka.example.team.commands;

import co.com.sofka.domain.generic.Command;

public class CreateTeam extends Command {
    private final String name;

    protected CreateTeam(String name) {
        super("training.team.create");
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
