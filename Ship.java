import java.awt.Color;
import java.awt.Image;
import java.util.Arrays;

public class Ship {
    private static final int[] LENGTHS = {2, 3, 3, 4, 5};
    private static final String[] FILES = {"ship2.png", "ship3.png", "ship3.1.png", "ship4.png", "ship5.png"};

    int[][] shape;
    int row, column;
    Color color = Color.GRAY;
    final Image image;

    public Ship(int type) {
        shape = new int[1][LENGTHS[type]];
        Arrays.fill(shape[0], 1);
        image = UI.image(FILES[type]);
    }

    void rotate() {
        int h = shape.length, w = shape[0].length;
        int[][] rotated = new int[w][h];
        for (int r = 0; r < h; r++)
            for (int c = 0; c < w; c++)
                rotated[c][h - 1 - r] = shape[r][c];
        shape = rotated;
    }
}
