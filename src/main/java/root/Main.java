package root;

import root.consoleDisplays.ConsoleBoard;
import root.consoleDisplays.ConsoleInOut;
import root.game.MinesweeperGame;
import root.guiConsole.GUIConsoleBoard;
import root.guiConsole.GUIInOut;

public class Main {
    public static void main(String[] args) {
        // new MinesweeperGame(new ConsoleBoard(), new ConsoleInOut()).runGame();
        new MinesweeperGame(new GUIConsoleBoard(), new GUIInOut()).runGame();
    }
}
