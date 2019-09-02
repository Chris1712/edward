package personal.chris;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

public class Edward {

    public enum OperationModes {DECODE, ENCODE}

    public static void main(String[] args) throws IOException {
        validateArgs(args);
        Path readPath = Paths.get(args[1]);

        if (args[0].equals("-e")) {
            byte[] fileBytes = Files.readAllBytes(readPath);
            String fileString = Base64.getEncoder().encodeToString(fileBytes);
//            Path writePath =
            //  Whatever the file is, convert to base 64 string, put some stuff above it, and put in .edward

        } else if (args[0].equals("-d")) {
            //  Verify .edward file, parse top bit, read in base 64 and then output
        }
    }

    public static void validateArgs(String[] args) throws IllegalArgumentException {
        if (args == null) {
            throw new IllegalArgumentException("Null argument supplied");
        }
        if (args.length != 2) {
            throw new IllegalArgumentException("Incorrect number of arguments supplied");
        }
        if (!args[0].matches("-[ed]")) {
            throw new IllegalArgumentException("Incorrect number of arguments supplied");
        }
        if (args[0].equals("-d") && !args[1].matches(".*\\.edward")) {
            throw new IllegalArgumentException("Can only decode .edward files");
        }
        if (args[0].equals("-e") && args[1].matches(".*\\.edward")) {
            throw new IllegalArgumentException("Cannot encode .edward files");
        }

    }
}
