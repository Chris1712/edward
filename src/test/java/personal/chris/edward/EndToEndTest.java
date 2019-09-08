package personal.chris.edward;


import org.junit.jupiter.api.*;
import org.opentest4j.TestAbortedException;
import org.springframework.util.DigestUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EndToEndTest {

    private static final String tempBaseFilePath = "src/test/resources/temp";
    private static final String tempEncodedFilePath = "src/test/resources/temp.edward";
    private static final String tempDecodedFilePath = "src/test/resources/tempOut";
    private static String tempFileHash;

    @BeforeAll
    static void setup() {
        // Create a random file and store the hash
        byte[] fileBytes = new byte[1000000];
        new Random().nextBytes(fileBytes);
        try (FileOutputStream stream = new FileOutputStream(tempBaseFilePath)) {
            stream.write(fileBytes);
            InputStream decodedStream = Files.newInputStream(Paths.get(tempBaseFilePath));
            tempFileHash = DigestUtils.md5DigestAsHex(decodedStream);
        } catch (IOException ex) {
            throw new TestAbortedException("Creating temp file for E2E test failed");
        }
    }

    @Test
    @Order(1)
    @DisplayName("Should create an encoded file from the generated temp file")
    void encodeFile() {
        Edward.main(new String[]{"encode", "-f", tempBaseFilePath});
        assertTrue(new File(tempEncodedFilePath).exists()); // encoded file created
    }

    @Test
    @Order(2)
    @DisplayName("Should decode the .edward file to a file with the same filename and hash")
    void decodeFile() throws IOException {
        Edward.main(new String[]{"decode", "-f", tempEncodedFilePath, "-o", tempDecodedFilePath});
        InputStream decodedStream = Files.newInputStream(Paths.get(tempDecodedFilePath));
        String decodedFileHash = DigestUtils.md5DigestAsHex(decodedStream);
        assertEquals(tempFileHash, decodedFileHash);
    }

    @AfterAll
    static void teardown() {
        String[] filesToClear = {
                tempBaseFilePath,
                tempEncodedFilePath,
                tempDecodedFilePath
        };

        for (String filePath: filesToClear) {
            File file = new File(filePath);
            if (file.exists()) {
                file.delete();
            }
        }
    }

}
