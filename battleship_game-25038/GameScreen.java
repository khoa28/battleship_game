import javax.swing.*;
import java.awt.*;

public class GameScreen extends JPanel {
    private final Board playerBoard = new Board();
    private final Board enemyBoard  = new Board();
    private final TakeBox takeBox   = new TakeBox();

    public GameScreen(CardLayout cards, JPanel root) {
        setLayout(null);
        setBackground(new Color(0, 25, 70));

        playerBoard.setBounds(70, 70, 400, 400);
        enemyBoard.setBounds(830, 70, 400, 400);

        Image vs = Res.image("vs.png").getScaledInstance(113, 200, Image.SCALE_SMOOTH);
        JLabel vsLogo = new JLabel(new ImageIcon(vs));
        vsLogo.setBounds(470, 70, 360, 400);

        takeBox.setBounds(490, 510, 320, 120);

        JButton ready = new JButton("Ready");
        ready.setBounds(830, 540, 200, 60);
        ready.setFont(new Font("Times New Roman", Font.BOLD, 30));
        ready.setBackground(Color.ORANGE);
        ready.addActionListener(e -> cards.show(root, "END")); // TẠM THỜI để test chuyển màn

        add(playerBoard);
        add(enemyBoard);
        add(vsLogo);
        add(takeBox);
        add(ready);
    }
}