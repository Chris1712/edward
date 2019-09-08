package personal.chris.edward.services;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class EncoderTest {

    private final static String testFile = "src/test/resources/encodable.png";
    private final static String expectedEncodedFile = "src/test/resources/encodable.png.edward";

    @Test
    @DisplayName("Should throw an exception if the file is not found")
    void noFile() {
        Encoder target = new Encoder();
        assertThrows(IllegalArgumentException.class, () ->
                target.encodeFileToFile("src/test/resources/nosuchfile.xyz", "out")
        );
    }

    @Test
    @DisplayName("Should create a correctly encoded text file")
    void encodesCorrectly() throws IOException {
        Encoder target = new Encoder();
        target.encodeFileToFile(testFile, expectedEncodedFile);
        String encodedFileContent = new String(Files.readAllBytes(Paths.get(expectedEncodedFile)));
        assertEquals("iVBORw0KGg", encodedFileContent.substring(0, 10)); // correct start
        assertEquals("lFTkSuQmCC", encodedFileContent.substring(encodedFileContent.length()-10)); // correct end
    }

    @AfterAll
    static void cleanup() throws IOException {
        Files.delete(Paths.get(expectedEncodedFile));
    }

}