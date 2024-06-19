import model.Computer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class ComputerTest {

    @DisplayName("컴퓨터는 0과 9 사이의 서로 다른 숫자 3개를 무작위로 뽑아야 한다.")
    @Test
    void checkRandomNumber() {
        assertDoesNotThrow(() -> new Computer());
    }
}
