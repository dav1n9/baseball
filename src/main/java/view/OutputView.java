package view;

public class OutputView {
    public static void showStartGameView() {
        System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!");
    }

    public static void showInputCount(int count) {
        System.out.print(count + "번째 시도 : ");
    }

    public static void showEndGameView(int count) {
        System.out.println(count + "번만에 맞히셨습니다.");
        System.out.println("게임을 종료합니다.");
    }

    public static void showExceptionMessage(String message) {
        System.out.println(message + " 다시 시도해 주세요.");
    }

    public static void showResult(String message) {
        System.out.println(message);
    }
}
