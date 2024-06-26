package root.game;

public abstract class MinesweeperBoard{
    public static final int MAX_COL = 10;
    public static final int MAX_ROW = 10;

    private static final int MINES = 10;

    protected int numRows;
    protected int numCols;

    public MinesweeperBoard(int r, int c){
        this.numRows = r;
        this.numCols = c;
    }

    public MinesweeperBoard(){
        this.numRows = MAX_ROW;
        this.numCols = MAX_COL;
    }

    protected Tile[][] board;

    public void initialize(){
        board = new Tile[this.numRows][this.numCols];

        //initialize tiles
        for (int i = 0; i < this.numRows; i++){
            for (int j = 0; j < this.numCols; j++){
                board[i][j] = new Tile();
            }
        }

        // //choose mine locations
        // for (int p = 0; p < MINES; p++){
        //     int i = 0, j = 0;
        //     do {
        //         i = (int)(this.numRows * Math.random());
        //         j = (int)(this.numCols * Math.random());
        //     } while (board[i][j].getMines() == 1);
        //     board[i][j].setAsMine();
        // }

        // //calculates neighbors
        // for (int i = 0; i < this.numRows; i++){
        //     for (int j = 0; j < this.numCols; j++){
        //         int mineNeighbors = 0;
        //         for (int ri = -1; ri < 2; ri++){
        //             for (int ji = -1; ji < 2; ji++){
        //                 int r = ri + i;
        //                 int c = ji + j;
        //                 if (r >= 0 && r < this.numRows
        //                     && c >= 0 && c < this.numCols
        //                     && !(r == i && c == j))
        //                     mineNeighbors += board[r][c].getMines();
        //             }
        //         }
        //         board[i][j].setMineNeighbors(mineNeighbors);
        //     }
        // }
    }

    public void generateMines(int nRow, int nCol){
        //choose mine locations
        for (int p = 0; p < MINES; p++){
            int i = 0, j = 0;
            while (true){
                i = (int)(this.numRows * Math.random());
                j = (int)(this.numCols * Math.random());
                if (board[i][j].getMines() == 1 || (i == nRow && j == nCol)) continue;
                board[i][j].setAsMine();
                setMineNeighbors();
                if (board[nRow][nCol].getMineNeighbors() > 0) {
                    board[i][j].unSetAsMine();
                    continue;
                }
                break;
            }
        }
    }

    private void setMineNeighbors(){
        //calculates neighbors
        for (int i = 0; i < this.numRows; i++){
            for (int j = 0; j < this.numCols; j++){
                int mineNeighbors = 0;
                for (int ri = -1; ri < 2; ri++){
                    for (int ji = -1; ji < 2; ji++){
                        int r = ri + i;
                        int c = ji + j;
                        if (r >= 0 && r < this.numRows
                            && c >= 0 && c < this.numCols
                            && !(r == i && c == j))
                            mineNeighbors += board[r][c].getMines();
                    }
                }
                board[i][j].setMineNeighbors(mineNeighbors);
            }
        }
    }

    public void toggleFlag(int r, int c){
        if (board[r][c].isBroken()) return;
        if (board[r][c].isFlagged()) board[r][c].unFlag();
        else board[r][c].flag();
    }

    //breaks a tile and any surrounding non-mine bordering tiles, returns true if hit a mine
    public boolean breakTile(int r, int c){
        if (board[r][c].isBroken() || board[r][c].isFlagged()) return false;
        else if (board[r][c].getMines() > 0) {
            board[r][c].reveal();
            return true;
        }

        board[r][c].reveal();
        if (board[r][c].getMineNeighbors() == 0){
            for (int rx = -1; rx < 2; rx ++){
                for (int cx = -1; cx < 2; cx++){
                    int ri = rx + r;
                    int ci = cx + c;
                    if (ri >= 0 && ri < this.numRows
                            && ci >= 0 && ci < this.numCols
                            && !(ri == r && ci == c)
                            && board[ri][ci].getMines() == 0){
                                breakTile(ri, ci);
                            }
                }
            }
        }
        return false;
    }

    public boolean isWon(){
        for (Tile[] tiles : board){
            for (Tile t : tiles){
                if (t.getMines() == 0 && !t.isBroken()) return false;
            }
        }
        return true;
    }

    public abstract void display();

    public abstract void gameEndWin();

    public abstract void gameEndLoose();

    public abstract void end();

    public String toString(){
        String str = "";
        for (Tile[] tiles : board){
            for (Tile t : tiles){
                if (t.getMines() > 0) str += "x";
                else str += t.getMineNeighbors();
                
                if (t.isBroken()) str += "s";
                else str += "H";
                str += "  ";
            }
            str += "\n\n";
        }
        return str;
    }

    public int getRows(){
        return this.numRows;
    }

    public int getCols(){
        return this.numCols;
    }

    //represents a tile on the minesweep board
    public static class Tile{
        private int mineNeighbors;

        private int hasMine = 0;
        private boolean isFlagged;
        private boolean revealed;

        public int getMineNeighbors(){
            return this.mineNeighbors;
        }

        public int getMines(){
            return this.hasMine;
        }

        public boolean isFlagged(){
            return this.isFlagged;
        }

        public boolean isBroken(){
            return revealed;
        }

        public void setMineNeighbors(int mineNeighbors){
            this.mineNeighbors = mineNeighbors;
        }

        public void setAsMine(){
            this.hasMine = 1;
        }

        public void unSetAsMine(){
            this.hasMine = 0;
        }

        public void flag(){
            this.isFlagged = true;
        }

        public void unFlag(){
            this.isFlagged = false;
        }

        public void reveal(){
            revealed = true;
        }

    }
}
