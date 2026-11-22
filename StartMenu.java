import javax.swing.*;
import java.awt.*;

public class StartMenu extends JPanel {
    private final Image background = UI.image("background.png");

    public StartMenu(CardLayout cards, JPanel root) {
        setLayout(null);

        JLabel name = new JLabel(new ImageIcon(UI.image("battle.png")));
        name.setBounds(250, 100, 1100, 263);

        JButton start = UI.button("START", 500, 400, null);
        start.addActionListener(e -> cards.show(root, "GAME"));

        JButton guides = UI.button("GUIDES", 500, 500, null);
        guides.addActionListener(e -> cards.show(root, "GUIDE"));

        add(start);
        add(guides);
        add(name);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        UI.drawCover(g, background, this);
    }
}
