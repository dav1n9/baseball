import model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserTest {
    @DisplayName("숫자의 값과 위치가 모두 일치하면 S")
    @Test
    void checkStrike() {
        User user = new User("123");
        int strike = user.getStrike("124");

        Assertions.assertEquals(strike, 2);
    }

    @DisplayName("숫자의 값은 일치하지만 위치가 틀렸으면 B")
    @Test
    void checkBall() {
        User user = new User("123");
        int ball = user.getBall("531");

        Assertions.assertEquals(ball, 2);
    }
}
