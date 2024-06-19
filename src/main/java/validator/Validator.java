package validator;

import constants.Constant;

import java.util.HashSet;
import java.util.Set;

public class Validator {

    public static boolean isValidateNumber(String number) {
        if (isValidateLength(number) && isValidateDigits(number) && isValidateUnique(number))
            return true;
        else
            throw new IllegalArgumentException();
    }

    private static boolean isValidateLength(String number) {
        if (number.length() != Constant.NUMBER_SIZE)
            throw new IllegalArgumentException(Constant.NUMBER_SIZE + "자리이어야 합니다.");
        return true;
    }

    private static boolean isValidateDigits(String number) {
        for (int i = 0; i < number.length(); i++) {
            if (!Character.isDigit(number.charAt(i)))
                throw new IllegalArgumentException("0과 9사이의 숫자를 입력해야 합니다.");
        }
        return true;
    }

    private static boolean isValidateUnique(String number) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < number.length(); i++) {
            set.add(number.charAt(i));
        }
        if (number.length() != set.size())
            throw new IllegalArgumentException("서로 다른 값을 입력해야 합니다.");

        return true;
    }
}
