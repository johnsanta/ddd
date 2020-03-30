package co.com.sofka.example.team;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.example.team.values.*;
import co.com.sofka.generic.Name;


public class Student extends Entity<StudentIdentity> {

    protected Name name;
    protected Gender gender;
    protected DateOfBirth dateOfBirth;
    protected Score score;

    protected Student(StudentIdentity studentIdentity, Name name, Gender gender, DateOfBirth dateOfBirth) {
        super(studentIdentity);
        this.name = name;
        this.gender =gender;
        this.dateOfBirth = dateOfBirth;
        this.score = new Score(0);
    }

    private Student(StudentIdentity studentIdentity){
        super(studentIdentity);
    }

    public void updateScore(Score score){
        this.score = score;
    }

    public void updateName(Name name){
        this.name = name;
    }

    public void updateDateOfBirth(DateOfBirth dateOfBirth){
        this.dateOfBirth = dateOfBirth;
    }

    public void updateGender(Gender gender){
        this.gender = gender;
    }

    public static Student form(StudentIdentity studentIdentity, Name name, Gender gender, DateOfBirth dateOfBirth){
        var student = new Student(studentIdentity);
        student.name = name;
        student.gender = gender;
        student.dateOfBirth = dateOfBirth;
        return student;
    }

    @Override
    public boolean equals(Object o) {
       return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
