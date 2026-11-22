import javax.swing.*;
import java.awt.*;

// Main class for each board
public abstract class GridPanel extends JPanel {
    public static final int CELL_SIZE = 40;
    static final Color WATER = new Color(45, 125, 190);

    final int rows, cols;
    final Color[][] grid;

    GridPanel(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.grid = new Color[rows][cols];
        setPreferredSize(new Dimension(cols * CELL_SIZE, rows * CELL_SIZE));
    }

    boolean isEmpty(int r, int c) {
        return r >= 0 && r < rows && c >= 0 && c < cols && grid[r][c] == null;
    }

    boolean canPlace(Ship ship, int newRow, int newCol) {
        for (int r = 0; r < ship.shape.length; r++)
            for (int c = 0; c < ship.shape[r].length; c++)
                if (ship.shape[r][c] != 0 && !isEmpty(newRow + r, newCol + c))
                    return false;
        return true;
    }

    void place(Ship ship) {
        for (int r = 0; r < ship.shape.length; r++)
            for (int c = 0; c < ship.shape[r].length; c++)
                if (ship.shape[r][c] != 0)
                    grid[ship.row + r][ship.column + c] = ship.color;
    }

    void drawBackground(Graphics g) {
        g.setColor(WATER);
        g.fillRect(0, 0, cols * CELL_SIZE, rows * CELL_SIZE);
    }

    void drawLines(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.WHITE);
        g2.setStroke(new BasicStroke(2));
        for (int r = 0; r <= rows; r++)
            g2.drawLine(0, r * CELL_SIZE, cols * CELL_SIZE, r * CELL_SIZE);
        for (int c = 0; c <= cols; c++)
            g2.drawLine(c * CELL_SIZE, 0, c * CELL_SIZE, rows * CELL_SIZE);
    }
}
