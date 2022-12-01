import java.awt.*;

public class Tile {
    private int x;
    private int y;

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
    }

    void render(Graphics g) {
        g.drawRect(Cords.xToPixels(x), Cords.yToPixels(y), 100, 100);
    }
}
