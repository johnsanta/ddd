package co.com.sofka.training.routine.values;

import co.com.sofka.domain.generic.Identity;

public class KataIdentity extends Identity {

    public KataIdentity(){
        super();
    }

    private KataIdentity(String id){
        super(id);
    }

    public static KataIdentity of(String id){
        return new KataIdentity(id);
    }
}
