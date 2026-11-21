import java.awt.Image;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import java.net.URL;

public class Res {
 private static final Map<String, ImageIcon> cache = new HashMap<>();

    public static ImageIcon icon(String name) {
        return cache.computeIfAbsent(name, n -> {
            URL url = Res.class.getResource("/Image/" + n);   
            return (url != null) ? new ImageIcon(url) : new ImageIcon("Image/" + n); 
        });
    }

    public static Image image(String name) {
        return icon(name).getImage();
    }
}