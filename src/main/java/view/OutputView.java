package view;

import controller.GameController;

public class OutputView {
    GameController controller;

    public OutputView(GameController controller) {
        this.controller = controller;
    }

    public void endGame() {
        System.out.println(controller.getCount() + "번만에 맞히셨습니다.");
        System.out.println("게임을 종료합니다.");
    }
}
