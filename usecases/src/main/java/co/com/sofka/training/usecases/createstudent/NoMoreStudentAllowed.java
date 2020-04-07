package co.com.sofka.training.usecases.createstudent;

public class NoMoreStudentAllowed extends RuntimeException {
    public NoMoreStudentAllowed(){
        super("No more student allowed");
    }
}
