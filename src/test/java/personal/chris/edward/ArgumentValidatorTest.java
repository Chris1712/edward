package personal.chris.edward;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArgumentValidatorTest {

    @Nested
    class Modes {

        @Test
        @DisplayName("Should throw an error if no arguments are supplied")
        public void noArgument() {
            String[] args = {};
            assertThrows(IllegalArgumentException.class, () ->
                    ArgumentValidator.validateArgs(args)
            );
        }

        @Test
        @DisplayName("Should throw an error if an incorrect mode is supplied")
        public void badFirst() {
            String[] modeInvalid = {"badfirst", "second"};
            assertThrows(IllegalArgumentException.class, () ->
                    ArgumentValidator.validateArgs(args)
            );
        }

        @Test
        @DisplayName("Should not throw an error if mode is set to encode")
        public void modeEncode() {
            String[] args = {"encode", "somefile.png"};
            assertDoesNotThrow(() -> ArgumentValidator.validateArgs(args));
        }

        @Test
        @DisplayName("Should not throw an error if mode is set to decode")
            public void modeDecode() {
            String[] args = {"encode", "somefile.png"};
            assertThrows(IllegalArgumentException.class, () ->
                    ArgumentValidator.validateArgs(args)
            );
        }
    }


}