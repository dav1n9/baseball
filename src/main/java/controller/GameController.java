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

    public GameController(Computer computer) {
        answer = computer;
        this.count = 0;
    }

    public String getAnswerNumber() {
        return answer.getNumber();
    }

    public int getCount() {
        return count;
    }

    public User inputUserNumber(String number) {
        Validator.validateNumber(number);
        count++;      // 잘못된 값을 입력할 경우는 count 에 포함하지 않음.
        return new User(number);
    }

    public String answer(User number) {
        int strike = number.getStrike(answer.getNumber());
        int ball = number.getBall(answer.getNumber());

        if (strike == 0 && ball == 0) return strike + "S" + ball + "B";
        else if (strike == 0) return ball + "B";
        else if (ball == 0) return strike + "S";

        return strike + "S" + ball + "B";
    }

    public boolean isCorrectAnswer(String number) {
        return number.equals(getAnswerNumber());
    }
}
