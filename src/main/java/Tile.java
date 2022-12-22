import java.awt.*;

public class Tile {
    private final int x;
    private final int y;

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    void render(Graphics g) {
        g.setColor(Color.GREEN);// CHECK : 09.12.2022 dodano na eksperymenty
        g.fillRect(Cords.xToPixels(x), Cords.yToPixels(y), 100, 100);// CHECK : 09.12.2022 dodano na eksperymetny
        /*g.drawRect(Cords.xToPixels(x), Cords.yToPixels(y), 100, 100);*/ // CHECK : 09.12.2022 zakomentowano na eksperymenty
    }
}
