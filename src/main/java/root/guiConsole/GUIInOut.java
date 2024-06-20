package root.guiConsole;

import javax.swing.JOptionPane;

import APClassesX.InputOutput;
import root.common.InOut;

public class GUIInOut implements InOut{

    @Override
    public MoveType move() {
        String str = InputOutput.getInstance().getString("Flag or Break (f/b)");
        if ("f".equals(str)) return MoveType.FLAG;
        else if ("b".equals(str)) return MoveType.BREAK;
        else {
            InputOutput.getInstance().coutln("Invalid option");
            return move();
        }
    }

    @Override
    public int[] moveLocation() {
        return new int[]{
            getInt("row"),
            getInt("col")
        };
    }

    @Override
    public boolean wantRestart() {
        return JOptionPane.showOptionDialog(null, "Play again?", "Play Again", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Yes", "No"}, "Yes") == 0;
    }
        
    private int getInt(String prompt){
        String str = InputOutput.getInstance().getString(prompt);
        try {
            return Integer.parseInt(str);
        } catch (Exception e){
            InputOutput.getInstance().coutln("Invalid Option");
            return getInt(prompt);
        }
    }
}
