package personal.chris.edward.services;

import org.junit.jupiter.api.*;
import personal.chris.edward.services.ArgumentParser;
import personal.chris.edward.services.Decoder;
import personal.chris.edward.services.Encoder;
import personal.chris.edward.services.Help;

import static org.mockito.Mockito.mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

class ArgumentParserTest {

    private ArgumentParser target;
    private Help mockHelp;
    private Encoder mockEncoder;
    private Decoder mockDecoder;

    @BeforeEach
    void setup() {
        mockHelp = mock(Help.class);
        mockEncoder = mock(Encoder.class);
        mockDecoder = mock(Decoder.class);
        target = new ArgumentParser(mockHelp, mockEncoder, mockDecoder);
    }

    @Nested
    class Modes {

        @Test
        @DisplayName("Should throw an error if no arguments are supplied")
        void noArgument() {
            String[] args = {};
            assertThrows(IllegalArgumentException.class, () ->
                    target.parseArgs(args)
            );
        }

        @Test
        @DisplayName("Should throw an error if an incorrect mode is supplied")
        void badFirst() {
            String[] args = {"badFirst", "second"};
            assertThrows(IllegalArgumentException.class, () ->
                    target.parseArgs(args)
            );
        }

    }

    @Nested
    class HelpMode {

        @Test
        @DisplayName("Should call help if the argument supplied is 'help'")
        void helpArg() {
            String[] args = {"help"};
            target.parseArgs(args);
            verify(mockHelp).getHelp();
        }

        @Test
        @DisplayName("Should call help if the argument supplied is '-h'")
        void lowerCaseHArg() {
            String[] args = {"-h"};
            target.parseArgs(args);
            verify(mockHelp).getHelp();
        }

        @Test
        @DisplayName("Should call help if the argument supplied is '-H'")
        void upperCaseHArg() {
            String[] args = {"-H"};
            target.parseArgs(args);
            verify(mockHelp).getHelp();
        }

    }

    @Nested
    class EncodeMode {

        @Test
        @DisplayName("Should throw an error if no further arguments are supplied")
        void noFurtherArgs() {
            String[] args = {"encode"};
            assertThrows(IllegalArgumentException.class, () ->
                    target.parseArgs(args)
            );
        }

        @Test
        @DisplayName("Should throw an error if the second argument isn't -f")
        void badSecondArg() {
            String[] args = {"encode", "badArg", "someFile"};
            assertThrows(IllegalArgumentException.class, () ->
                    target.parseArgs(args)
            );
        }

        @Test
        @DisplayName("Should throw an error if there are more than three arguments")
        void tooManyArgs() {
            String[] args = {"encode", "-f", "someFile", "anotherArg"};
            assertThrows(IllegalArgumentException.class, () ->
                    target.parseArgs(args)
            );
        }

        @Test
        @DisplayName("Should call the encode service with the path to encode")
        void callService() {
            String[] args = {"encode", "-f", "someFile"};
            target.parseArgs(args);
            verify(mockEncoder).encodeFileToFile("someFile");
        }

    }

    @Nested
    class DecodeMode {

        @Test
        @DisplayName("Should throw an error if no further arguments are supplied")
        void noFurtherArgs() {
            String[] args = {"decode"};
            assertThrows(IllegalArgumentException.class, () ->
                    target.parseArgs(args)
            );
        }

        @Test
        @DisplayName("Should throw an error if the second argument isn't -f")
        void badSecondArg() {
            String[] args = {"decode", "badArg", "someFile"};
            assertThrows(IllegalArgumentException.class, () ->
                    target.parseArgs(args)
            );
        }

        @Test
        @DisplayName("Should throw an error if there are more than three arguments")
        void tooManyArgs() {
            String[] args = {"decode", "-f", "someFile", "anotherArg"};
            assertThrows(IllegalArgumentException.class, () ->
                    target.parseArgs(args)
            );
        }

        @Test
        @DisplayName("Should call the decode service with the path to encode")
        void callService() {
            String[] args = {"decode", "-f", "someFile"};
            target.parseArgs(args);
            verify(mockDecoder).decodeFileToFile("someFile");
        }

    }


}