import controller.GameController;
import model.Computer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    GameController controller;
    @BeforeEach
    public void setUp() {
        controller = new GameController(new Computer("987"));
    }

    @DisplayName("올바른 값을 입력하면 예외가 발생하지 않고, count 가 증가한다.")
    @Test
    void validateInputNumber() {
        String input = "123";

        assertDoesNotThrow(() -> controller.inputUserNumber(input));
        assertEquals(controller.getCount(), 1);
    }

    @DisplayName("잘못된 값을 입력하면 예외가 발생한다.")
    @Test
    void validateInputNumber2() {
        String input = "1234";

        assertThrows(IllegalArgumentException.class, () -> {
            controller.inputUserNumber(input);
        });
    }

    @DisplayName("정답을 입력하면 true를 반환한다.")
    @Test
    void checkCorrectAnswer() {
        String input = "987";

        assertTrue(controller.isCorrectAnswer(input));
    }
}
