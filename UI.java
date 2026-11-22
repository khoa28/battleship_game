import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class UI {
    private static final Map<String, Image> CACHE = new HashMap<>();

    public static Image image(String name) {
        return CACHE.computeIfAbsent(name, n -> {
            var url = UI.class.getResource("/Image/" + n);
            return (url != null ? new ImageIcon(url) : new ImageIcon("Image/" + n)).getImage();
        });
    }

    public static JButton button(String text, int x, int y, Color bg) {
        JButton b = new JButton(text);
        b.setBounds(x, y, 300, 80);
        b.setFont(new Font("Times New Roman", Font.BOLD, 30));
        b.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        b.setForeground(Color.BLACK);
        if (bg == null) b.setContentAreaFilled(false);
        else b.setBackground(bg);
        return b;
    }

    public static void drawCover(Graphics g, Image img, Component c) {
        int iw = img.getWidth(null), ih = img.getHeight(null);
        if (iw <= 0 || ih <= 0) return;
        double scale = Math.max((double) c.getWidth() / iw, (double) c.getHeight() / ih);
        int w = (int) (iw * scale), h = (int) (ih * scale);
        g.drawImage(img, (c.getWidth() - w) / 2, (c.getHeight() - h) / 2, w, h, c);
    }
}
