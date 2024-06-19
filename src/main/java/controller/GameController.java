package controller;

import model.Computer;
import model.User;
import validator.Validator;
import view.InputView;
import view.OutputView;

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

    public void gameStart() {
        OutputView.showStartGameView();
        User user = null;
        do {
            try {
                OutputView.showInputCount(count + 1);
                user = inputUserNumber(InputView.readUserNumber());
            } catch (IllegalArgumentException e) {
                OutputView.showExceptionMessage(e.getMessage());
                continue;
            }
            OutputView.showResult(answer(user));
        } while (user == null || !isCorrectAnswer(user.getNumber()));
        OutputView.showEndGameView(count);
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
