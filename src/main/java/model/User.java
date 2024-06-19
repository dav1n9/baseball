package model;

import validator.Validator;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String number;

    public User(String number) {
        Validator.validateNumber(number);
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        Validator.validateNumber(number);
        this.number = number;
    }

    // number의 스트라이크 개수를 출력한다.
    public int getStrike(Computer answer) {
        int strike = 0;
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == answer.getNumber().charAt(i)) strike++;
        }
        return strike;
    }

    // number의 볼 개수를 출력한다.
    public int getBall(Computer answer) {
        List<Character> answerList = new ArrayList<>();
        for (char c : answer.getNumber().toCharArray()) {
            answerList.add(c);
        }

        int ball = 0;
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) != answerList.get(i) && answerList.contains(number.charAt(i))) ball++;
        }
        return ball;
    }
}
