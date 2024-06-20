package root.guiConsole;

import javax.swing.JOptionPane;

import APClassesX.InputOutput;
import root.game.MinesweeperBoard;

public class GUIConsoleBoard extends MinesweeperBoard{
    
    @Override
    public void display() {
        InputOutput.getInstance().cout("    ");
        for (int i = 0; i < this.numCols; i++)
            InputOutput.getInstance().cout(i + "  ");

        InputOutput.getInstance().coutln();
        InputOutput.getInstance().coutln("---------------------------------");
        int row = 0;
        for (Tile[] tiles : this.board){
            InputOutput.getInstance().cout(row + " | ");
            row++;
            for (Tile t : tiles){
                if (t.isFlagged()) {
                    InputOutput.getInstance().cout("x");
                } else if (t.isBroken()) {
                    if (t.getMineNeighbors() > 0) InputOutput.getInstance().cout(t.getMineNeighbors());
                    else InputOutput.getInstance().cout (" ");
                } else {
                    InputOutput.getInstance().cout("-");
                }
                InputOutput.getInstance().cout("  ");
            }
            InputOutput.getInstance().coutln();
        }
        InputOutput.getInstance().coutln("---------------------------------");
    }

    @Override
    public void gameEndWin() {
        display();
        JOptionPane.showMessageDialog(null, "You win!", "Game Result", JOptionPane.INFORMATION_MESSAGE);
        InputOutput.getInstance().coutln("\nCongratulations, you win");
    }

    @Override
    public void gameEndLoose() {
        InputOutput.getInstance().cout("    ");
        for (int i = 0; i < this.numCols; i++)
            InputOutput.getInstance().cout(i + "  ");

        InputOutput.getInstance().coutln();
        InputOutput.getInstance().coutln("---------------------------------");
        int row = 0;
        for (Tile[] tiles : this.board){
            InputOutput.getInstance().cout(row + " | ");
            row++;
            for (Tile t : tiles){
                if (t.getMines() > 0){
                    InputOutput.getInstance().cout("o");
                } else if (t.getMineNeighbors() > 0){
                    InputOutput.getInstance().cout(t.getMineNeighbors());
                } else {
                    InputOutput.getInstance().cout(" ");
                }
                InputOutput.getInstance().cout("  ");
            }
            InputOutput.getInstance().coutln();
        }
        InputOutput.getInstance().coutln("---------------------------------");
        InputOutput.getInstance().coutln("You lost\n\n\n");
        JOptionPane.showMessageDialog(null, "You lost", "Game Result", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void end() {
        InputOutput.getInstance().coutln("Bye!, you may close this window");
        JOptionPane.showMessageDialog(null, "Bye", "Good bye!", JOptionPane.INFORMATION_MESSAGE);
    }
}
