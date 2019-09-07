package personal.chris.edward.services;

import org.springframework.stereotype.Service;
import personal.chris.edward.Messages;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

/***
 * Service for parsing arguments supplied to Edward and determining methods required
 */
@Service
public class Encoder {

    public void encodeFileToFile(String filePath) {
        Path readPath = Paths.get(filePath);
        byte[] fileBytes;
        try {
            fileBytes = Files.readAllBytes(readPath);
        } catch (IOException ex) {
            throw new IllegalArgumentException(Messages.COULD_NOT_READ + readPath);
        }
        String fileString = Base64.getEncoder().encodeToString(fileBytes);

        String writePath = filePath + ".edward"; // Write out to example.png.edward
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(writePath))) {
            writer.write(fileString);
        } catch (IOException ex) {
            throw new IllegalArgumentException(Messages.COULD_NOT_WRITE + writePath);
        }
    }

}
