package validator;

public class Validator {

    public static boolean isValidateNumber(String number) {
        if (number.length() != 3) throw new IllegalArgumentException("3자리 수이어야 합니다.");

        for (int i = 0; i < number.length(); i++) {
            if (!Character.isDigit(number.charAt(i)))
                throw new IllegalArgumentException("0과 9사이의 숫자를 입력해야 합니다.");
        }

        if (number.charAt(0) == number.charAt(1) ||
                number.charAt(0) == number.charAt(2) ||
                number.charAt(1) == number.charAt(2))
            throw new IllegalArgumentException("서로 다른 숫자를 입력해야 합니다.");

        return true;
    }
}
