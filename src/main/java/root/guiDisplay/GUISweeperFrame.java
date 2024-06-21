package root.guiDisplay;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

public class GUISweeperFrame extends JFrame{
    private JPanel tiles;

    public GUISweeperFrame(){
        super("v0.2.0-alpha1");
        this.setSize(900, 900);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);

        tiles = new JPanel(new GridLayout(10, 10));

        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                JButton button = new JButton();
                // button.setBackground(Color.CYAN);
                // button.setBorder(new LineBorder(Color.BLUE, 4));
                button.addMouseListener(
                    new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e){
                            if (SwingUtilities.isLeftMouseButton(e)) System.out.println("break");
                            else if (SwingUtilities.isRightMouseButton(e)) {
                                System.out.println("flag");
                                if (button.getBackground().equals(Color.BLACK)) button.setBackground(null);
                                else button.setBackground(Color.BLACK);
                            }

                        }
                    }
                );
                tiles.add(button);
            }
        }

        this.add(tiles);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new GUISweeperFrame();
    }
}
