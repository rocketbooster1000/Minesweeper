package root;

import root.consoleDisplays.ConsoleBoard;
import root.consoleDisplays.ConsoleInOut;
import root.game.MinesweeperGame;

public class Main {
    public static void main(String[] args) {
        new MinesweeperGame(new ConsoleBoard(), new ConsoleInOut()).runGame();
    }
}
