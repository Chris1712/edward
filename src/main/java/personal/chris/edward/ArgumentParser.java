package personal.chris.edward;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/***
 * Service for parsing arguments supplied to Edward
 */
@Service
public class ArgumentParser {

    Help help;

    @Autowired
    public ArgumentParser(Help help) {
        this.help = help;
    }

    /***
     * Parses the supplied arguments and acts as required.
     * @param args The arguments with which Edward was called
     */
    public void parseArgs(String[] args) {
        if (args == null || args.length == 0) {
            throw new IllegalArgumentException("No arguments supplied");
        }
        if (args.length > 3) {
            throw new IllegalArgumentException("Incorrect number of arguments supplied. Try 'help' for more info.");
        }
        if (args[0].matches("help|-h|-H")) {
            help.getHelp();
            return;
        }
        if (args[0].equals("encode")) {
            validateEncode(args);
        } else if (args[0].equals("decode")) {
            validateDecode(args);
        } else {
            throw new IllegalArgumentException("Incorrect arguments supplied. Try 'help' for more info.");
        }
    }

    private void validateEncode(String[] args) {

    }
    private void validateDecode(String[] args) {

    }

}
