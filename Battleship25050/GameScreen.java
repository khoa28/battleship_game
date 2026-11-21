import javax.swing.*;
import java.awt.*;

public class GameScreen extends JPanel {
        public static void main(String[] args){
        Board Mainboard = new Board();
        Board AIboard = new Board();
        TakeBox TakeShip = new TakeBox();
        
        Ship ship2 = new Ship(0);
        Ship ship3 = new Ship(1);
        Ship ship31 = new Ship(2);
        Ship ship4 = new Ship(3);
        Ship ship5 = new Ship(4);


        ImageIcon vs = new ImageIcon("Image/vs.png");
        JLabel vslogo = new JLabel(vs);
        
        JButton Ready = new JButton("Ready");
        Ready.setBounds(1000, 700, 200, 60);
        Ready.setFont(new Font("Times New Roman", Font.BOLD, 30));
        Ready.setBackground(Color.ORANGE);

        JFrame frame = new JFrame("BATTLESHIPS GAME");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500, 900);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        
        ImageIcon logo = new ImageIcon("Image/logo.png");
        frame.setIconImage(logo.getImage());
        frame.getContentPane().setBackground(new Color(0, 25, 70));

        frame.add(Mainboard);
        Mainboard.setBounds(850,100,500,500);

        frame.add(AIboard);
        AIboard.setBounds(150,100,500,500);

        frame.add(vslogo);
        vslogo.setBounds(500, 100, 500, 500);

        frame.add(TakeShip);
        TakeShip.setBounds(550,650,400,150);

        frame.add(Ready);

        frame.setResizable(false);
        frame.setVisible(true);
        }
}
