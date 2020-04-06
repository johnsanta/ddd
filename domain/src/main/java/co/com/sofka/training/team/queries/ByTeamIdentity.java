package co.com.sofka.training.team.queries;

import co.com.sofka.domain.generic.Query;
import co.com.sofka.training.team.values.TeamIdentity;

public class ByTeamIdentity implements Query {
    private TeamIdentity teamIdentity;

    public TeamIdentity getTeamIdentity() {
        return teamIdentity;
    }

    public void setTeamIdentity(TeamIdentity teamIdentity) {
        this.teamIdentity = teamIdentity;
    }
}
