package root;

import root.consoleDisplays.ConsoleBoard;
import root.consoleDisplays.ConsoleInOut;
import root.game.MinesweeperGame;

public class Main {
    public static void main(String[] args) {
        MinesweeperGame game = new MinesweeperGame(new ConsoleBoard(), new ConsoleInOut());
        game.runGame();
        
    }
}
