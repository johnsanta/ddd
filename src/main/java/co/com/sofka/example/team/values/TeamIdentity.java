package co.com.sofka.example.team.values;

import co.com.sofka.domain.generic.Identity;

public class TeamIdentity extends Identity {
    public TeamIdentity(){
        super();
    }
    private TeamIdentity(String id){
        super(id);
    }
    public static TeamIdentity of(String id){
         return new TeamIdentity(id);
    }
}
