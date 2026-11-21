
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TakeBox extends JPanel{
    public static final int ROWS = 3;
    public static final int COLUMNS = 8;
    public static final int CELL_SIZE = 50;

    Color[][] grid = new Color[ROWS][COLUMNS];
    ArrayList<Ship> ships = new ArrayList<>();

    public TakeBox(){
        ships.add(new Ship(0));
        ships.add(new Ship(1));
        ships.add(new Ship(2));
        ships.add(new Ship(3));
        ships.add(new Ship(4));

        ships.get(0).row = 0;
        ships.get(0).column = 0;

        ships.get(1).row = 0;
        ships.get(1).column = 3;

        ships.get(2).row = 1;
        ships.get(2).column = 0;

        ships.get(3).row = 1;
        ships.get(3).column = 4;

        ships.get(4).row = 2;
        ships.get(4).column = 0;
    }

    boolean isEmpty(int row, int col){
        return row >= 0 && row < ROWS && col >= 0 && col < COLUMNS && grid[row][col] == null;
    }

    boolean canPlace(Ship ship, int newRow, int newCol){
        int[][] shape = ship.shape;

        for(int row = 0; row < shape.length; row++){
            for(int col = 0; col < shape[row].length; col++){
                if(shape[row][col] != 0){
                    int newRowPos = newRow + row;
                    int newColPos = newCol + col;

                    if(!isEmpty(newRowPos, newColPos)){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    void place(Ship ship){
        for(int row = 0; row < ship.shape.length; row++){
            for(int col = 0; col < ship.shape[row].length; col++){
                if(ship.shape[row][col] != 0){
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
        g.fillRect(0, 0, getWidth(), getHeight());

        Graphics2D g2 = (Graphics2D) g;

        for(Ship ship : ships){
            Image img = ship.image.getImage();

            int width = ship.shape[0].length * CELL_SIZE;
            int height = ship.shape.length * CELL_SIZE;

            g2.drawImage(img,
                ship.column * CELL_SIZE,
                ship.row * CELL_SIZE,
                width, height, this);
        }

        g2.setColor(Color.WHITE);
        g2.setStroke(new BasicStroke(2));

        for(int row = 0; row <= ROWS; row++){
            g2.drawLine(0, row * CELL_SIZE,
                COLUMNS * CELL_SIZE, row * CELL_SIZE);
        }

        for(int col = 0; col <= COLUMNS; col++){
            g2.drawLine(col * CELL_SIZE, 0,
                col * CELL_SIZE, ROWS * CELL_SIZE);
        }
    }
}
