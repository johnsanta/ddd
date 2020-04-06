package co.com.sofka.training.team;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.training.Name;
import co.com.sofka.training.team.values.DateOfBirth;
import co.com.sofka.training.team.values.Gender;
import co.com.sofka.training.team.values.Score;
import co.com.sofka.training.team.values.StudentIdentity;


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
