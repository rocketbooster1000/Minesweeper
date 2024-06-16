package root.game;

import root.common.Board;
import root.common.InOut;

public class MinesweeperGame {
    private enum GameStatus{
        WON,
        LOST,
        ONGOING
    }

    private Board board;

    private InOut io;

    private GameStatus status;

    public MinesweeperGame(Board board, InOut io){
        this.board = board;
        this.io = io;
    }

    public void runGame(){
        newGame();
        while (status == GameStatus.ONGOING){
            move();
            board.display();
        }
        endGame();
        if (io.wantRestart()) runGame();
        else board.end();
    }

    public void newGame(){
        board.regenerate();
        board.display();
        status = GameStatus.ONGOING;
    }

    public void move(){
        int[] tile = io.moveLocation();
        switch (io.move()) {
            case BREAK:
                if (board.breakTile(tile[0], tile[1])) status = GameStatus.LOST;
                else if (board.isWon()) status = GameStatus.WON;
                break;
        
            case FLAG:
                board.toggleFlag(tile[0], tile[1]);
                break;
        }
    }

    private void endGame(){
        switch (status){
            case WON:
                board.gameEndWIn();
                break;
            case LOST:
                board.gameEndLoose();
                break;
            default:
                break;
        }
    }

    public GameStatus getStatus(){
        return this.status;
    }
}
