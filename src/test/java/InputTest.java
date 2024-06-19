import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import validator.Validator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputTest {
    @DisplayName("입력값의 길이는 3이어야 한다.")
    @Test
    void validateLength() {
        final String input = "1234";

        assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateLength(input);
        });
    }

    @DisplayName("0~9사이의 숫자만 입력해야 한다.")
    @Test
    void validateDigits() {
        final String input = "abc";

        assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateDigits(input);
        });
    }

    @DisplayName("서로 다른 값을 입력해야 한다.")
    @Test
    void validateUnique() {
        final String input = "111";

        assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateUnique(input);
        });
    }

    @DisplayName("올바른 값을 입력하면 아무 예외가 발생하지 않는다.")
    @Test
    void validateNumber() {
        final String input = "123";
        assertDoesNotThrow(() -> Validator.validateUnique(input));
    }
}
