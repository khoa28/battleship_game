import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class UI {
    public static JButton button(String text, int x, int y) {
        JButton b = new JButton(text);
        b.setBounds(x, y, 300, 80);
        b.setFont(new Font("Times New Roman", Font.BOLD, 30));
        b.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        b.setBackground(Color.ORANGE);
        b.setForeground(Color.BLACK);
        return b;
    }

    public static void drawCover(Graphics g, Image img, Component c) {
    int iw = img.getWidth(null), ih = img.getHeight(null);
    double scale = Math.max((double) c.getWidth() / iw, (double) c.getHeight() / ih);
    int w = (int) (iw * scale), h = (int) (ih * scale);
    g.drawImage(img, (c.getWidth() - w) / 2, (c.getHeight() - h) / 2, w, h, c);
}
}