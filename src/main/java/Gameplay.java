import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class Gameplay implements MouseListener {
    private final List<Tile> tiles = new ArrayList<>();
    private final TileFactory tileFactory = new TileFactory();
    private TilePreview tilePreview = new TilePreview();
    private EndButton endButton = new EndButton();


    public Gameplay() {
        tiles.add(tileFactory.getNextTile(8, 4));
        updatePreviewTile();
    }

    public void tick() {
    }

    public void render(Graphics g) {
        for (Tile tile : new ArrayList<>(tiles)) {
            tile.render(g);
        }
        tilePreview.render(g);
        endButton.render(g);
    }

    private boolean spawnTile(int x, int y) {
        if (isConnectedTile(x, y) && placeIsEmpty(x, y) && isMatchingTile(x, y)) {
            Tile newTile = tilePreview.getTile();
            newTile.setX(x);
            newTile.setY(y);
            tiles.add(newTile);
            return true;
        }
        return false;
    }

    private boolean isConnectedTile(int x, int y) {
        for (Tile tile : tiles) {
            if (tile.equals(tilePreview.getTile())) {
                continue;
            }
            int otherXDifference = Math.abs(tile.getX() - x);
            int otherYDifference = Math.abs(tile.getY() - y);
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

    private boolean isMatchingTile(int x, int y) {
        Tile northConnected = null;
        for (Tile tile : tiles) {
            if (tile.getX() == x && tile.getY() == y - 1) {
                northConnected = tile;
            }
        }
        System.out.println(northConnected);
        return true;
    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (endButton.isOnButton(e.getX(), e.getY())) {
            if (!endButton.isDisable()) {
                updatePreviewTile();
                endButton.disable();
            }
        } else {
            if (spawnTile(Cords.xToCords(e.getX()), Cords.yToCords(e.getY()))) {
                endButton.enable();
            }
        }
    }

    private void updatePreviewTile() {
        tilePreview.setTile(tileFactory.getNextTile(0, 0));
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

//podgląd aktualnego
//postawienie aktualnego chowa podgląd
//również aktywuje przycisk
//również blokuje stawianie klocka
//przycisk zatwierdzenia - naciśnięcie pokazuje podgląd kolejnego
//przyleganie dróg - zezwala lub nie na położenie tile
