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

    // number 의 스트라이크 개수를 출력한다.
    public int getStrike(String answer) {
        int strike = 0;
        for (int i = 0; i < number.length(); i++) {
            if (isSamePosition(answer.charAt(i), i)) strike++;
        }
        return strike;
    }

    // number 의 볼 개수를 출력한다.
    public int getBall(String answer) {
        List<Character> answerList = toCharList(answer);

        int ball = 0;
        for (int i = 0; i < number.length(); i++) {
            if (!isSamePosition(answer.charAt(i), i) && answerList.contains(number.charAt(i))) ball++;
        }
        return ball;
    }

    private boolean isSamePosition(char charNum, int position) {
        return number.charAt(position) == charNum;
    }

    private List<Character> toCharList(String numberStr) {
        List<Character> list = new ArrayList<>();
        for (char c : numberStr.toCharArray()) {
            list.add(c);
        }
        return list;
    }
}
