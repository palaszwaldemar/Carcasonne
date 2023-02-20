import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;

public class Tile {
    private static final int SIZE = 100;
    private int x;
    private int y;
    private final BufferedImage bufferedImage;
    private final boolean[] road = new boolean[4];
    private final boolean[] city = new boolean[4];

    public Tile(int x, int y, BufferedImage bufferedImage) {
        this.x = x;
        this.y = y;
        this.bufferedImage = bufferedImage;
    }

    void render(Graphics g) {
        g.drawImage(bufferedImage, Cords.xToPixels(x), Cords.yToPixels(y), SIZE, SIZE, null);
    }

    void render(Graphics g, int pixelX, int pixelY) {
        g.drawImage(bufferedImage, pixelX, pixelY, SIZE, SIZE, null);
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setRoad(char side) {
        switch (side) {
            case 'N' -> road[0] = true;
            case 'E' -> road[1] = true;
            case 'S' -> road[2] = true;
            case 'W' -> road[3] = true;
        }
    }

    public void setCity(char side) {
        switch (side) {
            case 'N' -> city[0] = true;
            case 'E' -> city[1] = true;
            case 'S' -> city[2] = true;
            case 'W' -> city[3] = true;
        }
    }

    public boolean getRoad(int i) {
        return road[i];
    }

    public boolean getCity(int i) {
        return city[i];
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Tile{" +
                "x=" + x +
                ", y=" + y +
                ", road=" + Arrays.toString(road) +
                '}';
    }
}
