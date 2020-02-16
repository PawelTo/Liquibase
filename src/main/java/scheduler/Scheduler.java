package scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {

    @Scheduled(cron = "* 30 21 * * *")
    public void schedulded(){
        System.out.println("Metoda do testowania schedulingu");
    }
}
