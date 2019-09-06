package personal.chris.edward;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArgumentParserTest {

    @Nested
    class Modes {

        @Test
        @DisplayName("Should throw an error if no arguments are supplied")
        public void noArgument() {
            String[] args = {};
            assertThrows(IllegalArgumentException.class, () ->
                    ArgumentParser.parseArgs(args)
            );
        }

        @Test
        @DisplayName("Should throw an error if an incorrect mode is supplied")
        public void badFirst() {
            String[] args = {"badfirst", "second"};
            assertThrows(IllegalArgumentException.class, () ->
                    ArgumentParser.parseArgs(args)
            );
        }

        @Test
        @DisplayName("Should not throw an error if mode is set to encode")
        public void modeEncode() {
            String[] args = {"encode", "somefile.png"};
            assertDoesNotThrow(() -> ArgumentParser.parseArgs(args));
            // todo - should check that path is valid
        }

        @Test
        @DisplayName("Should not throw an error if mode is set to decode")
            public void modeDecode() {
            String[] args = {"decode", "somefile.png.edward"};
            assertDoesNotThrow(() -> ArgumentParser.parseArgs(args));
        }
    }

    @Nested
    class Help {
        @Test
        @DisplayName("Should call help if the argument supplied is 'help'")
        public void helpArg() {
            String[] args = {"encode"};
            assertThrows(IllegalArgumentException.class, () ->
                    ArgumentParser.parseArgs(args)
            );
        }

        @Test
        @DisplayName("Should call help if the argument supplied is '-h'")
        public void lowerCaseHArg() {
            String[] args = {"encode"};
            assertThrows(IllegalArgumentException.class, () ->
                    ArgumentParser.parseArgs(args)
            );
        }

        @Test
        @DisplayName("Should call help if the argument supplied is '-H'")
        public void upperCaseHArg() {
            String[] args = {"encode"};
            assertThrows(IllegalArgumentException.class, () ->
                    ArgumentParser.parseArgs(args)
            );
        }
    }

    @Nested
    class Encode {

        @Test
        @DisplayName("Should throw an error if no further arguments are supplied")
        public void noFurtherArgs() {
            String[] args = {"encode"};
            assertThrows(IllegalArgumentException.class, () ->
                    ArgumentParser.parseArgs(args)
            );
        }

        @Test
        @DisplayName("Should throw an error if the second argument isn't -f")
        public void badSecondArg() {
            String[] args = {"encode", "badarg", "somefile"};
            assertThrows(IllegalArgumentException.class, () ->
                    ArgumentParser.parseArgs(args)
            );
        }

        @Test
        @DisplayName("Should throw an error if there are more than three arguments")
        public void tooManyArgs() {
            String[] args = {"encode", "-f", "somefile", "anotherArg"};
            assertThrows(IllegalArgumentException.class, () ->
                    ArgumentParser.parseArgs(args)
            );
        }


    }


}