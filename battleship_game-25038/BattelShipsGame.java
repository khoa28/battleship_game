import javax.swing.*;
import java.awt.*;

public class BattelShipsGame {
    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("BATTLESHIPS GAME");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setIconImage(Res.image("logo.png"));

            CardLayout cards = new CardLayout();
            JPanel root = new JPanel(cards);
            root.setPreferredSize(new Dimension(1300, 720));
        
            root.add(new StartMenu(cards, root), "MENU");
            root.add(new GameScreen(cards, root), "GAME");
            root.add(new GuideScreen(cards, root), "GUIDE");
            root.add(new EndGame(cards, root), "END");

            frame.setContentPane(root);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setResizable(false);
            frame.setVisible(true);
            cards.show(root, "MENU");
        });
    }
}
