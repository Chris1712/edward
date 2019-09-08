package personal.chris.edward.services;

import org.springframework.stereotype.Service;
import personal.chris.edward.Messages;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

/***
 * Service for parsing arguments supplied to Edward and determining methods required
 */
@Service
public class Decoder {

    public void decodeFileToFile(String readPath) {
        String fileContent;
        try {
            fileContent = new String(Files.readAllBytes(Paths.get(readPath)));
        } catch (IOException ex) {
            throw new IllegalArgumentException(Messages.COULD_NOT_READ + readPath);
        }
        byte[] fileBytes = Base64.getDecoder().decode(fileContent);

        String writePath = readPath.substring(0, readPath.length()-7);
        try (FileOutputStream stream = new FileOutputStream(writePath)) {
            stream.write(fileBytes);
        } catch (IOException ex) {
            throw new IllegalArgumentException(Messages.COULD_NOT_WRITE + writePath);
        }
        System.out.println(Messages.fileDecodedToFile(readPath, writePath));
    }
}
