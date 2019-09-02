package personal.chris;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class EdwardTest {

    Edward target;

    @BeforeEach
    public void setup() {
        target = new Edward();
    }

    @Nested
    class Main {

        @Test
        @DisplayName("Should throw an error if no arguments are supplied")
        public void noArgument() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                target.main(new String[]{});
            });
        }

        @Test
        @DisplayName("Should throw an error if a null argument array is supplied")
        public void nullArgument() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                target.main(null);
            });
        }

        @Test
        @DisplayName("Should throw an error if more than two arguments are supplied")
        public void tooManyArguments() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                target.main(new String[]{"arg1", "arg2", "arg3"});
            });
        }

        @Test
        @DisplayName("Should throw an error if less than two arguments are supplied")
        public void singleArgument() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                target.main(new String[]{"arg1"});
            });
        }

        @Test
        @DisplayName("Should throw an error if the first argument is invalid")
        public void badFirstArgument() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                target.main(new String[]{"arg1", "arg2"});
            });
        }

        @Test
        @DisplayName("Should throw an error if the first argument is the wrong case")
        public void upperCaseFirstArgument() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                target.main(new String[]{"-E", "arg2"});
            });
        }

        @Test
        @DisplayName("Should throw an error if trying to encode .edward file")
        public void encodeEdward() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                target.main(new String[]{"-e", ".edward"});
            });
        }

        @Test
        @DisplayName("Should throw an error if trying to decode a file that isn't .edward")
        public void decodeNonEdward() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                target.main(new String[]{"-d", "somefile"});
            });
        }

        @Test
        @DisplayName("Should not throw an error for a valid encode request")
        public void validEncode() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                target.main(new String[]{"-e", "arg2"});
            });
        }

        @Test
        @DisplayName("Should not throw an error for a valid decode request")
        public void validDecode() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                target.main(new String[]{"-d", "arg2.edward"});
            });
        }

    }

}