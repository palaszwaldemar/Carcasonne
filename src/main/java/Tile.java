import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Tile {
    private final int x;
    private final int y;
    private BufferedImage bufferedImage;

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
        try {
            bufferedImage = ImageIO.read(Tile.class.getResource("/tiles/PNG/Base_Game_C2_Tile_D.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    void render(Graphics g) {
        g.drawImage(bufferedImage, Cords.xToPixels(x), Cords.yToPixels(y), 100, 100, null);
    }
}
