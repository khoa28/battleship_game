import java.awt.*;

public class Board extends GridPanel {
    Ship current;

    public Board() {
        super(10, 10);
    }

    public void setCurrent(Ship ship) {
        this.current = ship;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBackground(g);

        for (int r = 0; r < rows; r++)
            for (int c = 0; c < cols; c++)
                if (grid[r][c] != null)
                    fillCell(g, grid[r][c], r, c);

        if (current != null)
            for (int r = 0; r < current.shape.length; r++)
                for (int c = 0; c < current.shape[r].length; c++)
                    if (current.shape[r][c] != 0)
                        fillCell(g, current.color, current.row + r, current.column + c);

        drawLines(g);
    }

    private void fillCell(Graphics g, Color color, int r, int c) {
        g.setColor(color);
        g.fillRect(c * CELL_SIZE, r * CELL_SIZE, CELL_SIZE, CELL_SIZE);
    }
}
