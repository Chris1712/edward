package personal.chris.edward.services;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.util.DigestUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class DecoderTest {

    private final static String testFile = "src/test/resources/decodable.png.edward";
    private final static String expectedDecodedFile = "src/test/resources/decodable.png";

    @Test
    @DisplayName("Should throw an exception if the file is not found")
    void noFile() {
        Decoder target = new Decoder();
        assertThrows(IllegalArgumentException.class, () ->
                target.decodeFileToFile("src/test/resources/nosuchfile.xyz")
        );
    }

    @Test
    @DisplayName("Should create a correctly decoded file")
    void decodesCorrectly() throws IOException {
        Decoder target = new Decoder();

        target.decodeFileToFile(testFile);

        InputStream decodedStream = Files.newInputStream(Paths.get(expectedDecodedFile));
        String decodedFileHash = DigestUtils.md5DigestAsHex(decodedStream);
        assertEquals("0672c15d926d8d94d85116cc91cec53a", decodedFileHash);
    }

    @AfterAll
    static void cleanup() throws IOException {
        Files.delete(Paths.get(expectedDecodedFile));
    }

}