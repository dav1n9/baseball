package view;

import java.util.Scanner;

public class InputView {
    static Scanner scanner = new Scanner(System.in);

    public static String readUserNumber() {
        return scanner.next();
    }
}
