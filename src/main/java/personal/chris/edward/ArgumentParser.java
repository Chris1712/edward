package personal.chris.edward;

public class ArgumentParser {

    public static void parseArgs(String[] args) {
        if (args == null) {
            throw new IllegalArgumentException("Null argument supplied");
        }
        if (args.length != 2) {
            throw new IllegalArgumentException("Incorrect number of arguments supplied");
        }
        if (!args[0].matches("encode|decode")) {
            throw new IllegalArgumentException("First argument must be mode; 'encode' or 'decode'.");
        }
        if (args[0].equals("-d") && !args[1].matches(".*\\.edward")) {
            throw new IllegalArgumentException("Can only decode .edward files");
        }
        if (args[0].equals("-e") && args[1].matches(".*\\.edward")) {
            throw new IllegalArgumentException("Cannot encode .edward files");
        }
    }

}
