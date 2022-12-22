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

    private void spawnTile(int x, int y) { // CHECK : 09.12.2022 zmieniono metodę aby działała poprawnie.
        System.out.println(tiles.size());
        if (spawnIsPossible(x, y)) {
            Tile newTile = new Tile(x, y);
            tiles.add(newTile);
        }
    }

    private boolean spawnIsPossible(int x, int y) {// CHECK : 09.12.2022 dodana metoda pomocnicza
        for (Tile tile : tiles) {
            int otherXDifference = Math.abs( tile.getX() - x);  // 0
            int otherYDifference = Math.abs( tile.getY() - y);  // 1
            int sum = otherXDifference + otherYDifference;
            if (sum == 1) {
                return true;
            }
        }
        return false;
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
