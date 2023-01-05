import java.awt.*;

public class TilePreview {
    private Tile tile;


    public void setTile(Tile tile) {
        this.tile = tile;
    }

    void render(Graphics g) {
        tile.render(g, 10, 10);
    }

    public Tile getTile() {
        return tile;
    }
}
