package co.com.sofka.training.team.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.training.team.values.TeamIdentity;
import co.com.sofka.training.Name;

public class UpdateTeam extends Command {
    private final Name name;
    private final TeamIdentity teamIdentity;

    public UpdateTeam(TeamIdentity teamIdentity, Name name) {
        super("training.team.updateteam");
        this.name = name;
        this.teamIdentity = teamIdentity;
    }

    public TeamIdentity getTeamIdentity() {
        return teamIdentity;
    }

    public Name getName() {
        return name;
    }


}
