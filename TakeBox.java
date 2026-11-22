import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TakeBox extends GridPanel {

    private static final int[][] POSITIONS = {{0, 0}, {0, 3}, {1, 0}, {1, 4}, {2, 0}};

    final List<Ship> ships = new ArrayList<>();

    public TakeBox() {
        super(3, 8);
        for (int i = 0; i < POSITIONS.length; i++) {
            Ship s = new Ship(i);
            s.row = POSITIONS[i][0];
            s.column = POSITIONS[i][1];
            ships.add(s);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBackground(g);

        for (Ship s : ships)
            g.drawImage(s.image,
                s.column * CELL_SIZE, s.row * CELL_SIZE,
                s.shape[0].length * CELL_SIZE, s.shape.length * CELL_SIZE, this);

        drawLines(g);
    }
}
