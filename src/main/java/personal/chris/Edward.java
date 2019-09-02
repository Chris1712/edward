package personal.chris;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Edward {
    public static void main(String[] args) throws IOException {
        validateArgs(args);
        readFile(args[0]);


    }

    private static void validateArgs(String[] args) throws IllegalArgumentException {
        if (args == null) {
            throw new IllegalArgumentException("Null argument supplied");
        }
        if (args.length != 1) {
            throw new IllegalArgumentException("Incorrect number of arguments supplied");
        }
    }

    private static byte[] readFile(String path) throws IOException {
        Path filePath = Paths.get(path);
        return Files.readAllBytes(filePath);
    }
}
