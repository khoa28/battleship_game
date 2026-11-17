import javax.swing.*;
import java.awt.*;

public class Board extends JPanel{
    public static final int ROWS = 10;
    public static final int COLUMNS = 10;
    public static final int CELL_SIZE = 50;

    Color[][] grid = new Color[ROWS][COLUMNS];
    Ship current;

    public void setCurrent(Ship Ship){
        this.current = Ship;
    }

    boolean isEmpty(int row, int col){
        return row >= 0 && row < ROWS && col >= 0 && col < COLUMNS && grid[row][col] == null;
    }
    
    boolean canPlace(Ship Ship, int newRow, int newCol){
        int[][] shape = Ship.shape;
        for (int row = 0; row < shape.length; row++){
            for (int col = 0; col < shape[row].length; col++){
                if (shape[row][col] != 0){
                    int newRowPos = newRow + row;
                    int newColPos = newCol + col;

                    if (!isEmpty(newRowPos, newColPos)){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    void place(Ship ship){
        for (int row = 0; row < ship.shape.length; row++){
            for (int col = 0; col < ship.shape[row].length; col++){
                if (ship.shape[row][col] != 0){
                    grid[ship.row + row][ship.column + col] = ship.color;
                }
            }
        }
    }
    @Override
    public Dimension getPreferredSize(){
        return new Dimension(COLUMNS * CELL_SIZE, ROWS * CELL_SIZE);
    }

    @Override 
    public void paintComponent(Graphics g){
        super.paintComponent(g);

    g.setColor(new Color(45, 125, 190));
    g.fillRect(0, 0, COLUMNS * CELL_SIZE, ROWS * CELL_SIZE);

    for(int row = 0; row <ROWS; row++){
        for(int column = 0; column < COLUMNS; column++){
            if(grid[row][column] != null){
                g.setColor(grid[row][column]);
                g.fillRect(column * CELL_SIZE, row * CELL_SIZE, CELL_SIZE, CELL_SIZE);
            }
        }
    }
    Graphics2D g2 = (Graphics2D) g;

    g2.setColor(Color.WHITE);
    g2.setStroke(new BasicStroke(2));

    g2.drawRect(0, 0, COLUMNS * CELL_SIZE, ROWS * CELL_SIZE);

    if(current != null){
        g.setColor(current.color);
        for(int row = 0; row < current.shape.length; row++){
            for(int column = 0; column < current.shape[row].length; column++){
                if(current.shape[row][column] != 0){
                    int x = (current.column + column) * CELL_SIZE;
                    int y = (current.row + row) * CELL_SIZE;

                    g.fillRect(x, y, CELL_SIZE, CELL_SIZE);
                }
            }
        }
    }
    g.setColor(Color.WHITE);
    for(int row = 0; row <= ROWS; row++){
        g.drawLine(0, row * CELL_SIZE, COLUMNS * CELL_SIZE, row * CELL_SIZE);
    }
    for(int column = 0; column <= COLUMNS; column++){
        g.drawLine(column * CELL_SIZE, 0, column * CELL_SIZE, ROWS * CELL_SIZE);
    }
}
}   