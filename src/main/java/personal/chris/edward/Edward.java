package personal.chris.edward;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

public class Edward {

    public static void main(String[] args) throws IOException {
        ArgumentParser.parseArgs(args);
        Path readPath = Paths.get(args[1]);

        if (args[0].equals("-e")) {
            byte[] fileBytes = Files.readAllBytes(readPath);
            String fileString = Base64.getEncoder().encodeToString(fileBytes);
            String writePath = args[1] + ".edward"; // Write out to example.png.edward
            BufferedWriter writer = new BufferedWriter(new FileWriter(writePath));
            writer.write(fileString);
            writer.close();
        } else if (args[0].equals("-d")) {
            String writePath = args[1].substring(0, args[1].length()-7); // todo, we could get the writepath from the args as a testable method
            String fileContent = new String(Files.readAllBytes(readPath)); // todo, may need buffering
            byte[] fileBytes = Base64.getDecoder().decode(fileContent);
            try (FileOutputStream stream = new FileOutputStream(writePath)) {
                stream.write(fileBytes);
            }
        }
    }

    public static void getHelp() {
        System.out.println("Edward is a tool for encoding and decoding files to base64 strings");
        System.out.println("To encode a file use 'edward encode -f myfile");
        System.out.println("To decode a file try 'edward decode -f myfile.edward");
        System.exit(0);
    }
}
