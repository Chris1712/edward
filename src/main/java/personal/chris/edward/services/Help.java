package personal.chris.edward.services;

import org.springframework.stereotype.Service;
import personal.chris.edward.Messages;

@Service
public class Help {

    public void getHelp() {
        System.out.println(Messages.HELP);
        System.exit(0);
    }
}
