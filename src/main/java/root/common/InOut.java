package root.common;

public interface InOut {
    public enum MoveType{
        FLAG,
        BREAK
    }

    public MoveType move();
    public int[] moveLocation();
    public boolean wantRestart();
}
