package co.com.sofka.training.routine.values;

import co.com.sofka.domain.generic.Identity;

public class RoutineIdentity extends Identity {

    public RoutineIdentity(){
        super();
    }

    private RoutineIdentity(String identityId){
        super(identityId);
    }

    public static RoutineIdentity of(String identityId){
        return new RoutineIdentity(identityId);
    }

}
