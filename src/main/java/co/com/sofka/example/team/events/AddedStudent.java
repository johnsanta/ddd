package co.com.sofka.example.team.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.example.team.values.DateOfBirth;
import co.com.sofka.example.team.values.Gender;
import co.com.sofka.generic.Name;
import co.com.sofka.example.team.values.StudentIdentity;

public class AddedStudent extends DomainEvent {


    private final StudentIdentity studentIdentity;
    private final Name name;
    private final Gender gender;
    private final DateOfBirth dateOfBirth;

    public AddedStudent(StudentIdentity studentIdentity, Name name, Gender gender, DateOfBirth dateOfBirth) {
        super("training.team.addedstudent");
        this.studentIdentity = studentIdentity;
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    public Name getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public DateOfBirth getDateOfBirth() {
        return dateOfBirth;
    }

    public StudentIdentity getStudentIdentity() {
        return studentIdentity;
    }

}
