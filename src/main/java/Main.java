import controller.GameController;
import view.InputView;
import view.OutputView;

public class Main {
    public static void main(String[] args) {
        GameController controller = new GameController();

        InputView inputView = new InputView(controller);
        inputView.getGameInfo();

        OutputView outputView = new OutputView(controller);
        outputView.endGame();
    }
}
