import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class StartMenu extends JPanel{
    private final Image background = Res.image("background.png");

    public StartMenu(CardLayout cards, JPanel root){
        setLayout(null);
        
        JLabel name = new JLabel(Res.icon("battle.png"));
        name.setBounds(200,60,900,263);
        
        JButton Start = makeButton("START", 500, 400);
        Start.addActionListener(e -> cards.show(root, "GAME"));

        JButton Guides = makeButton("GUIDES", 500, 500);
        Guides.addActionListener(e -> cards.show(root, "GUIDE"));
    
        add(Start);
        add(Guides);
        add(name);
    }

        private JButton makeButton(String text, int x, int y) {
        JButton b = new JButton(text);
        b.setBounds(x, y, 300, 80);
        b.setFont(new Font("Times New Roman", Font.BOLD, 30));
        b.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        b.setBackground(new Color(255,255,255,0));
        b.setForeground(Color.BLACK);
        return b;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        UI.drawCover(g, background, this);
    }
}



