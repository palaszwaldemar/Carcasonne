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
        if (spawnIsPossible(x, y)) {
            Tile newTile = new Tile(x, y);
            tiles.add(newTile);
        }
    }

   private boolean spawnIsPossible(int x, int y) {// CHECK : 09.12.2022 dodana metoda pomocnicza
        for (Tile tile : tiles) {
            if (x == tile.getX() && y == tile.getY()) {
                return false;
            }
            if (x == tile.getX() && (y == tile.getY() + 1 || y == tile.getY() - 1)) {//  UP/DOWN
                return true;
            }
            if (y == tile.getY() && (x == tile.getX() + 1 || x == tile.getX() - 1)) {//  LEFT/RIGHT
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
        spawnTile(Cords.xToCords(e.getX()), Cords.yToCords(e.getY())); // CHECK : 09.12.2022 gdzie ta metoda się odpala?
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

//drukuje sie pozycja x, y która została kliknieta +
//wstawia sie tile w pozycje x, y
//można wstawiac tylko w te miescja przylegajace
