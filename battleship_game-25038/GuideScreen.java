import javax.swing.*;
import java.awt.*;

public class GuideScreen extends JPanel {
    public GuideScreen(CardLayout cards, JPanel root) {
        setLayout(null);
        setBackground(new Color(0, 25, 70));

        JLabel text = new JLabel("<html><div style='width:800px'>"
            + "<h1>HOW TO PLAY</h1>"
            + "1. Đặt 5 tàu lên bàn cờ của bạn.<br>"
            + "2. Nhấn Ready để bắt đầu.<br>"
            + "3. Lần lượt bắn vào bàn của đối thủ.<br>"
            + "4. Ai đánh chìm hết tàu đối phương trước sẽ thắng."
            + "</div></html>");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        text.setBounds(250, 80, 800, 400);

        JButton back = new JButton("BACK");
        back.setBounds(500, 560, 300, 80);
        back.setFont(new Font("Times New Roman", Font.BOLD, 30));
        back.setBackground(Color.ORANGE);
        back.addActionListener(e -> cards.show(root, "MENU"));

        add(text);
        add(back);
    }
}