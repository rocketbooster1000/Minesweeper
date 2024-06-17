package root.consoleDisplays;

import root.game.MinesweeperBoard;

public class ConsoleBoard extends MinesweeperBoard{

    @Override
    public void display(){
        System.out.print("    ");
        for (int i = 0; i < MAX_COL; i++)
            System.out.print(i + "  ");

        System.out.println();
        System.out.println("---------------------------------");
        int row = 0;
        for (Tile[] tiles : this.board){
            System.out.print(row + " | ");
            row++;
            for (Tile t : tiles){
                if (t.isFlagged()) {
                    System.out.print("x");
                } else if (t.isBroken()) {
                    if (t.getMineNeighbors() > 0) System.out.print(t.getMineNeighbors());
                    else System.out.print (" ");
                } else {
                    System.out.print("-");
                }
                System.out.print("  ");
            }
            System.out.println();
        }
        System.out.println("---------------------------------");
    }

    @Override
    public void gameEndWin() {
        display();
        System.out.println("\nCongratulations, you win");
    }

    @Override
    public void gameEndLoose() {
        display();
        System.out.println("You lost");
    }

    @Override
    public void end() {
        System.out.println("bye");
    }
}
