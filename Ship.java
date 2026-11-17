import java.awt.*;

import javax.swing.ImageIcon;


public class Ship{
    static final int[][][] SHAPES = {
        {{1, 1}},
        {{1, 1, 1}},
        {{1, 1, 1}},
        {{1, 1, 1, 1}},
        {{1, 1, 1, 1, 1}},
        
    };

    static final ImageIcon[] IMAGES = {
    new ImageIcon("Image/ship2.png"),
    new ImageIcon("Image/ship3.png"),
    new ImageIcon("Image/ship3.1.png"),
    new ImageIcon("Image/ship4.png"),
    new ImageIcon("Image/ship5.png")
    };

    int[][] shape;
    int row;
    int column;
    Color color;
    ImageIcon image;
    
    public Ship(int type){
        shape = copyShape(SHAPES[type]);
        image = IMAGES[type];
        row = 0;
        column = 0;
    }

    static int[][] copyShape(int[][] base){
        int[][] copy = new int[base.length][];
        for (int i = 0; i < base.length; i++){
            copy[i] = base[i].clone();
        }
        return copy;
    }

    void rotate(){
        int height = shape.length;
        int width = shape[0].length;
        int[][] rotated = new int[width][height];
        for (int row = 0; row < height; row++){
            for (int col = 0; col < width; col++){
                rotated[col][height - 1 - row] = shape[row][col];
            }
        }
        shape = rotated;
    }
    }

