import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class StartMenu extends JPanel{

    public StartMenu(CardLayout cardStart, JPanel startPanel){
        
        JPanel StartBackground = new JPanel(){
        Image background = new ImageIcon("Image/background.png").getImage();

        @Override
        protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
        
        }   
    };
        
    setLayout(null);

    ImageIcon Title = new ImageIcon("Image/name.png");

        JLabel name = new JLabel();
        name.setIcon(Title);
        name.setBounds(325,100,900,500);
        
        JButton Start = new JButton("START");
        Start.setBounds(600, 400, 300, 80);
        Start.setFont(new Font("Times New Roman", Font.BOLD, 30));
        Start.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        Start.setBackground(Color.ORANGE);
        Start.setForeground(Color.BLACK);

        JButton Guides = new JButton("GUIDES");
        Guides.setBounds(600, 500, 300, 80);
        Guides.setFont(new Font("Times New Roman", Font.BOLD, 30));
        Guides.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        Guides.setBackground(Color.ORANGE);
        Guides.setForeground(Color.BLACK);

        add(Start);
        add(Guides);
        add(name);
    }
}



