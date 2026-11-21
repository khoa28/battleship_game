import javax.swing.*;
import javax.swing.border.EtchedBorder;

import java.awt.*;

public class EndGame extends JPanel{

    public EndGame(CardLayout cardEnd, JPanel endPanel){

        JPanel EndBackground = new JPanel(){
        Image background = new ImageIcon("Image/Loser.png").getImage();

        @Override
        protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
    }
    };

    setLayout(null);

        JLabel name = new JLabel("GAME OVER");
        name.setFont(new Font("Times New Roman", Font.BOLD, 85));
        name.setForeground(Color.RED);
        name.setBackground(Color.BLACK);
        name.setOpaque(true);
        name.setBounds(450, 100, 600, 250);
        name.setVerticalAlignment(JLabel.CENTER);
        name.setHorizontalAlignment(JLabel.CENTER);

        JButton Restart = new JButton("Play Again");
        Restart.setBounds(600, 400, 300, 80);
        Restart.setFont(new Font("Times New Roman", Font.BOLD, 30));
        Restart.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        Restart.setBackground(Color.ORANGE);
        Restart.setForeground(Color.BLACK);

        JButton Back = new JButton("Back to Menu");
        Back.setBounds(600, 500, 300, 80);
        Back.setFont(new Font("Times New Roman", Font.BOLD, 30));
        Back.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        Back.setBackground(Color.ORANGE);
        Back.setForeground(Color.BLACK);

        add(Restart);
        add(Back);
        add(name);

    }
}


