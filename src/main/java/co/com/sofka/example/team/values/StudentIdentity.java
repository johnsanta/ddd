package co.com.sofka.example.team.values;

import co.com.sofka.domain.generic.Identity;


public class StudentIdentity extends Identity {
    public StudentIdentity() {
        super();
    }

    private StudentIdentity(String uuid){
        super(uuid);
    }

    public static StudentIdentity of(String uuid){
        return new StudentIdentity(uuid);
    }
}
