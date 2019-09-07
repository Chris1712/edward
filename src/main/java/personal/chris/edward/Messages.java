package personal.chris.edward;

public class Messages {

    public final static String INCORRECT_ARGS = "Incorrect arguments supplied. Try 'help' for more info.";
    public final static String NO_ARGS = "No arguments supplied";
    public final static String MUST_SUPPLY_FILE_FOR_DECODE = "Must supply a file for decoding. Try 'help' for more info.";
    public final static String MUST_SUPPLY_FILE_FOR_ENCODE = "Must supply a file for encoding. Try 'help' for more info.";

    public final static String COULD_NOT_READ = "Could not read from file: ";
    public final static String COULD_NOT_WRITE = "Could not write to file: ";

    public final static String HELP =
              "Edward is a tool for encoding and decoding files to base64 strings\n"
            + "To encode a file use 'edward encode -f myFile\n"
            + "To decode a file try 'edward decode -f myFile.edward";
}
