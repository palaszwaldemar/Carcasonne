import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class Gameplay implements MouseListener {
    private final List<Tile> tiles = new ArrayList<>();

    public Gameplay() {
        tiles.add(new Tile(8, 4));
    }

    public void tick() {
    }

    public void render(Graphics g) {
        for (Tile tile : new ArrayList<>(tiles)) {
            tile.render(g);
        }
    }

    private void spawnTile(int x, int y) {
        if (spawnIsPossible(x, y) && placeIsEmpty(x, y)) {
            Tile newTile = new Tile(x, y);
            tiles.add(newTile);
        }
    }

    private boolean spawnIsPossible(int x, int y) {
        for (Tile tile : tiles) {
            int otherXDifference = Math.abs( tile.getX() - x);
            int otherYDifference = Math.abs( tile.getY() - y);
            int sum = otherXDifference + otherYDifference;
            if (sum == 1) {
                return true;
            }
        }
        return false;
    }

    private boolean placeIsEmpty(int x, int y) {
        for (Tile tile : tiles) {
            if (tile.getX() == x && tile.getY() == y) {
                return false;
            }
        }
        return true;
    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        spawnTile(Cords.xToCords(e.getX()), Cords.yToCords(e.getY()));
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

//kładziemy tylko na WOLNE przylegajace miejsca
//grafiki tile
//przyleganie dróg - zezwala lub nie na położenie tile
