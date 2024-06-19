package controller;

import model.Computer;
import model.User;
import validator.Validator;

public class GameController {
    private final Computer answer;
    private int count;

    public GameController() {
        answer = new Computer();
        this.count = 0;
    }

    public String getAnswerNumber() {
        return answer.getNumber();
    }

    public int getCount() {
        return count;
    }

    public User inputUserNumber(String number) {
        if (Validator.isValidateNumber(number)) {
            count++;      // 잘못된 값을 입력할 경우는 count 에 포함하지 않음.
            return new User(number);
        }
        throw new IllegalArgumentException("잘못된 입력입니다. 다시 시도해 주세요.");
    }

    public String answer(User number) {
        int strike = number.getStrike(answer);
        int ball = number.getBall(answer);

        if (strike == 0) return ball + "B";
        else if (ball == 0) return strike + "S";

        return strike + "S" + ball + "B";
    }

    public boolean isCorrectAnswer(User number) {
        return number.getNumber().equals(getAnswerNumber());
    }
}
