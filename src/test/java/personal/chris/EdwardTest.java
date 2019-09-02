package personal.chris;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

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
                target.main(null);
            });
        }


    }

}