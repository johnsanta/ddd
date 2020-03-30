package co.com.sofka.example.team;

import co.com.sofka.example.team.values.*;
import co.com.sofka.generic.Name;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class StudentTest {

    @Test
    void updateScore() {
        var student = newStudent();
        student.updateScore(new Score(10));
        Assertions.assertEquals(10, student.score.value().get("point"));
    }

    @Test
    void updateScore_as_invalid() {
        var student = newStudent();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            student.updateScore(new Score(-1));
        });
    }

    @Test
    void updateName() {
        var student = newStudent();
        student.updateName(new Name("camilo andres"));
        Assertions.assertEquals("camilo andres", student.name.value());
    }

    @Test
    void updateName__as_invalid() {
        var student = newStudent();
        Assertions.assertThrows(NullPointerException.class, () -> {
            student.updateName(new Name(null));
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            student.updateName(new Name(" "));
        });
    }


    @Test
    void updateDateOfBirth() {
        var student = newStudent();
        student.updateDateOfBirth(new DateOfBirth(9, 3, 1988));
        Assertions.assertEquals("09-03-1988", student.dateOfBirth.value());
    }

    @Test
    void updateDateOfBirth_as_invalid() {
        var student = newStudent();
        var local = LocalDateTime.now();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            var date = local.plusDays(1);
            student.updateDateOfBirth(new DateOfBirth(
                    date.getDayOfMonth(),  date.getMonthValue(),  date.getYear()
            ));
        });
    }
    @Test
    void updateGender() {
        var student = newStudent();
        student.updateGender(new Gender(Gender.Type.F));
        Assertions.assertEquals("F", student.gender.value());
    }

    @Test
    void form() {
        var student = Student.form(
                StudentIdentity.of("xxx-xxx-xxx"),
                new Name("raul andres"),
                new Gender(Gender.Type.F),
                new DateOfBirth(1,1,1988)
        );
        Assertions.assertEquals("raul andres", student.name.value());
        Assertions.assertEquals("F", student.gender.value());
        Assertions.assertEquals("01-01-1988", student.dateOfBirth.value());
    }

    private Student newStudent(){
        StudentIdentity id = new StudentIdentity();
        Name name = new Name("andres camilo");
        Gender gender = new Gender(Gender.Type.M);
        DateOfBirth date = new DateOfBirth(9, 3, 1988);
        return new Student(id, name, gender, date);
    }
}