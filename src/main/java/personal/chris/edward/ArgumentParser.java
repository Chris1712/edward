package personal.chris.edward;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/***
 * Service for parsing arguments supplied to Edward
 */
@Service
public class ArgumentParser {

    Help help;
    private static final String INCORRECT_ARGS_MSG = "Incorrect arguments supplied. Try 'help' for more info.";

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
        if (args[0].matches("help|-h|-H")) {
            help.getHelp();
            return;
        }
        if (args[0].equals("encode")) {
            validateEncode(args);
        } else if (args[0].equals("decode")) {
            validateDecode(args);
        } else {
            throw new IllegalArgumentException(INCORRECT_ARGS_MSG);
        }
    }

    private void validateEncode(String[] args) {
        if (!args[1].equals("-f")) {
            throw new IllegalArgumentException("Must supply a file for encoding. Try 'help' for more info.");
        }
        if (args.length != 3) {
            throw new IllegalArgumentException(INCORRECT_ARGS_MSG);
        }
        // validate the file exists, then pass it to the relevant provider

    }

    private void validateDecode(String[] args) {
        if (!args[1].equals("-f")) {
            throw new IllegalArgumentException("Must supply a file for decoding. Try 'help' for more info.");
        }
        if (args.length != 3) {
            throw new IllegalArgumentException(INCORRECT_ARGS_MSG);
        }
        // validate the file exists, then pass it to the relevant provider

    }

}
