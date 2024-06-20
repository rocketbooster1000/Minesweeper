package root.game;

import root.common.InOut;

public class MinesweeperGame {
    private enum GameStatus{
        WON,
        LOST,
        FIRST_MOVE,
        ONGOING
    }

    private MinesweeperBoard board;

    private InOut io;

    private GameStatus status;

    public MinesweeperGame(MinesweeperBoard board, InOut io){
        this.board = board;
        this.io = io;
    }

    public void runGame(){
        newGame();
        while (status == GameStatus.ONGOING || status == GameStatus.FIRST_MOVE){
            move();
            board.display();
        }
        endGame();
        if (io.wantRestart()) runGame();
        else board.end();
    }

    public void newGame(){
        board.initialize();
        board.display();
        status = GameStatus.FIRST_MOVE;
    }

    public void move(){
        int[] tile = io.moveLocation();
        if (tile[0] < 0 || tile[0] > board.getRows() - 1 || tile[1] < 0 || tile[1] > board.getCols() - 1) {
            tile = io.moveLocation();
        }
        switch (io.move()) {
            case BREAK:
                if (status == GameStatus.FIRST_MOVE) {
                    System.out.println("hi");
                    board.generateMines(tile[0], tile[1]);
                    status = GameStatus.ONGOING;
                }

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
                board.gameEndWin();
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
