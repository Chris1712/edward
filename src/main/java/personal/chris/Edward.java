package personal.chris;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

public class Edward {

    public static void main(String[] args) throws IOException {
        validateArgs(args);
        Path readPath = Paths.get(args[1]);

        if (args[0].equals("-e")) {
            byte[] fileBytes = Files.readAllBytes(readPath);
            String fileString = Base64.getEncoder().encodeToString(fileBytes);
            String writePath = args[1] + ".edward"; // Write out to example.zip.edward
            BufferedWriter writer = new BufferedWriter(new FileWriter(writePath));
            writer.write(fileString);
            writer.close();

        } else if (args[0].equals("-d")) {
             String fileContent;
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
