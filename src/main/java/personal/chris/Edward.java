package personal.chris;

import java.io.File;

public class Edward {
    public static void main(String[] args) {
        validateArgs(args);
        readFile(args[0]);

        System.out.println("hi");
    }

    private static void validateArgs(String[] args) throws IllegalArgumentException {
        if (args == null) {
            throw new IllegalArgumentException("Null argument supplied");
        }
        if (args.length != 1) {
            throw new IllegalArgumentException("Incorrect number of arguments supplied");
        }
    }

    private static File readFile(String path) {

        return null;
    }
}
