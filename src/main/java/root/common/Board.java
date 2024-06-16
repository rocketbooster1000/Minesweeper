package root.common;

public interface Board {
    public boolean breakTile(int r, int c);
    public boolean isWon();
    public void regenerate();
    public void toggleFlag(int r, int c);
    public void display();
    public void gameEndWIn();
    public void gameEndLoose();
    public void end();
}
