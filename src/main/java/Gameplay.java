import java.awt.*;

public class Gameplay {
    public void tick() {
    }

    public void render(Graphics g) {
        Tile tile = new Tile(8, 4);
        tile.render(g);
    }
}
