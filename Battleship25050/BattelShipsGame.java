import javax.swing.*;
import java.awt.*;

public class BattelShipsGame {
    public static void main(String[] args){

        JFrame frame = new JFrame("BATTLESHIPS GAME");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500, 900);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        
        ImageIcon logo = new ImageIcon("Image/logo.png");
        frame.setIconImage(logo.getImage());
        frame.getContentPane().setBackground(new Color(0,25,70));

        frame.setResizable(false);
        frame.setVisible(true);

    }
}
