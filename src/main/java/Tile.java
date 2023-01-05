import java.awt.*;
import java.awt.image.BufferedImage;
public class Tile {
    private static final int SIZE = 100;
    private  int x;
    private  int y;
    private BufferedImage bufferedImage;

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

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
