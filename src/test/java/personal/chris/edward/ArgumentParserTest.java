package personal.chris.edward;

import org.junit.jupiter.api.*;

import static org.mockito.Mockito.mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

class ArgumentParserTest {

    ArgumentParser target;
    Help mockHelp;

    @BeforeEach
    public void setup() {
        mockHelp = mock(Help.class);
        target = new ArgumentParser(mockHelp);
    }

    @Nested
    class Modes {

        @Test
        @DisplayName("Should throw an error if no arguments are supplied")
        public void noArgument() {
            String[] args = {};
            assertThrows(IllegalArgumentException.class, () ->
                    target.parseArgs(args)
            );
        }

        @Test
        @DisplayName("Should throw an error if an incorrect mode is supplied")
        public void badFirst() {
            String[] args = {"badfirst", "second"};
            assertThrows(IllegalArgumentException.class, () ->
                    target.parseArgs(args)
            );
        }
    }

    @Nested
    class HelpMode {
        @Test
        @DisplayName("Should call help if the argument supplied is 'help'")
        public void helpArg() {
            String[] args = {"help"};
            target.parseArgs(args);
            verify(mockHelp).getHelp();
        }

        @Test
        @DisplayName("Should call help if the argument supplied is '-h'")
        public void lowerCaseHArg() {
            String[] args = {"-h"};
            target.parseArgs(args);
            verify(mockHelp).getHelp();
        }

        @Test
        @DisplayName("Should call help if the argument supplied is '-H'")
        public void upperCaseHArg() {
            String[] args = {"-H"};
            target.parseArgs(args);
            verify(mockHelp).getHelp();
        }
    }

    @Nested
    class EncodeMode {

        @Test
        @DisplayName("Should throw an error if no further arguments are supplied")
        public void noFurtherArgs() {
            String[] args = {"encode"};
            assertThrows(IllegalArgumentException.class, () ->
                    target.parseArgs(args)
            );
        }

        @Test
        @DisplayName("Should throw an error if the second argument isn't -f")
        public void badSecondArg() {
            String[] args = {"encode", "badarg", "somefile"};
            assertThrows(IllegalArgumentException.class, () ->
                    target.parseArgs(args)
            );
        }

        @Test
        @DisplayName("Should throw an error if there are more than three arguments")
        public void tooManyArgs() {
            String[] args = {"encode", "-f", "somefile", "anotherArg"};
            assertThrows(IllegalArgumentException.class, () ->
                    target.parseArgs(args)
            );
        }


    }


}