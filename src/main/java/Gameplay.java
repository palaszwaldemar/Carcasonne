import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Gameplay {
    private List<Tile> tiles = new ArrayList<>();

    public Gameplay() {
        tiles.add(new Tile(4, 7));
        tiles.add(new Tile(8, 1));
        tiles.add(new Tile(2, 5));
        tiles.add(new Tile(7, 6));
        tiles.add(new Tile(3, 1));

    }

    public void tick() {
    }

    public void render(Graphics g) {
        for (Tile tile : tiles) {
            tile.render(g);
        }
    }
}
