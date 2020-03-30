package co.com.sofka.example.team.commands;

import co.com.sofka.domain.generic.Command;

public class ChangeScoreOfStudent extends Command {
    public ChangeScoreOfStudent() {
        super("training.team.changescoreofstudent");
    }
}
