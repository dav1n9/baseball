package model;

import constants.Constant;
import validator.Validator;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private final String number;

    public Computer(String number) {
        Validator.validateNumber(number);
        this.number = number;
    }

    public Computer() {
        String randomNum = getRandomNumber();   // 랜덤으로 숫자 생성
        Validator.validateNumber(randomNum);
        this.number = randomNum;
    }

    public String getNumber() {
        return number;
    }

    public String getRandomNumber() {
        List<String> randomInts = new ArrayList<>();
        do {
            String num = randomInt();
            if (!randomInts.contains(num))
                randomInts.add(num);
        } while (randomInts.size() != Constant.NUMBER_SIZE);

        return String.join("", randomInts);
    }

    public String randomInt() {
        return String.valueOf((int) (Math.random() * 10));  // 0~9까지의 랜덤 숫자
    }
}
