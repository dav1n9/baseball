package view;

import controller.GameController;
import model.User;

import java.util.Scanner;

public class InputView {
    GameController controller;

    public InputView(GameController controller) {
        this.controller = controller;
    }

    public void getGameInfo() {
        startGame();
        Scanner scanner = new Scanner(System.in);
        User user = null;
        do {
            System.out.print((controller.getCount() + 1) + "번째 시도 : ");
            try {
                user = controller.inputUserNumber(scanner.next());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + " 다시 시도해 주세요.");
                continue;   // 결과를 출력하지 않도록.
            }
            System.out.println(controller.answer(user));

        } while (user == null || !controller.isCorrectAnswer(user.getNumber()));
    }

    private void startGame() {
        System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!");
        // System.out.println(controller.getAnswerNumber()); // 정답 출력
    }
}
