package personal.chris.edward;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArgumentParser {

    @Autowired
    Help help;


    public void parseArgs(String[] args) {
        help.getHelp();
        if (args == null) {
            throw new IllegalArgumentException("Null argument supplied");
        }
        if (args.length != 2) {
            throw new IllegalArgumentException("Incorrect number of arguments supplied. Try 'help' for more info.");
        }
        if (!args[0].matches("encode|decode")) {
            throw new IllegalArgumentException("First argument must be mode; 'encode' or 'decode'. Try 'help' for more info.");
        }
        if (args[0].equals("-d") && !args[1].matches(".*\\.edward")) {
            throw new IllegalArgumentException("Can only decode .edward files");
        }
        if (args[0].equals("-e") && args[1].matches(".*\\.edward")) {
            throw new IllegalArgumentException("Cannot encode .edward files");
        }


        help.getHelp();
    }

}
