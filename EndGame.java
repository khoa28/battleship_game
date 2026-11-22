import javax.swing.*;
import java.awt.*;

public class EndGame extends JPanel {
    private final Image background = UI.image("Loser.png");

    public EndGame(CardLayout cards, JPanel root) {
        setLayout(null);

        JLabel title = new JLabel("GAME OVER", SwingConstants.CENTER);
        title.setFont(new Font("Times New Roman", Font.BOLD, 85));
        title.setForeground(Color.RED);
        title.setBackground(Color.BLACK);
        title.setOpaque(true);
        title.setBounds(340, 100, 600, 250);

        JButton again = UI.button("Play Again", 500, 400, Color.ORANGE);
        again.addActionListener(e -> cards.show(root, "GAME"));

        JButton menu = UI.button("Back to Menu", 500, 500, Color.ORANGE);
        menu.addActionListener(e -> cards.show(root, "MENU"));

        add(title);
        add(again);
        add(menu);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        UI.drawCover(g, background, this);
    }
}
