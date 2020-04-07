package co.com.sofka.training.application;


import co.com.sofka.infraestructure.handle.CommandExecutor;
import co.com.sofka.training.usecases.createstudent.CreateStudentHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApplicationCommandExecutor extends CommandExecutor {

    private final TeamSubscriberEvent subscriberEvent;

    @Autowired
    public ApplicationCommandExecutor(TeamSubscriberEvent subscriberEvent){
        this.subscriberEvent = subscriberEvent;
        initialize();
    }

    private void initialize(){
        add(new CreateStudentHandle(subscriberEvent));
    }
}
