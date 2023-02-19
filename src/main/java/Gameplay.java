import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Gameplay implements MouseListener {
    private final TileFactory tileFactory = new TileFactory();
    private final List<Tile> tilesBoard = new ArrayList<>();
    private final Queue<Tile> tilesPile = tileFactory.getListOfTile();
    private final TilePreview tilePreview = new TilePreview();
    private final EndButton endButton = new EndButton();


    public Gameplay() {
        Tile tile = tilesPile.poll();
        tile.setX(8); // TODO: 16.02.2023 wysypie się jak się skończą
        tile.setY(4);
        tilesBoard.add(tile);
        updatePreviewTile();
    }

    public void tick() {
    }

    public void render(Graphics g) {
        for (Tile tile : new ArrayList<>(tilesBoard)) {
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
            tilesBoard.add(newTile);
            return true;
        }
        return false;
    }

    private boolean isConnectedTile(int x, int y) {
        for (Tile tile : tilesBoard) {
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
        for (Tile tile : tilesBoard) {
            if (tile.getX() == x && tile.getY() == y) {
                return false;
            }
        }
        return true;
    }

    private boolean isMatchingTile(int x, int y) {
        Tile northConnected;
        Tile eastConnected;
        Tile southConnected;
        Tile westConnected;
        for (Tile tile : tilesBoard) {
            if (tile.equals(tilePreview.getTile())) {
                continue;
            }
            if (tile.getX() == x && tile.getY() == y + 1) {
                northConnected = tile;
                if (northConnected.getRoad(0) != tilePreview.getTile().getRoad(2)) {
                    return false;
                }
            }
            if (tile.getX() == x && tile.getY() == y - 1) {
                southConnected = tile;
                if (southConnected.getRoad(2) != tilePreview.getTile().getRoad(0)) {
                    return false;
                }
            }
            if (tile.getX() == x - 1 && tile.getY() == y) {
                eastConnected = tile;
                if (eastConnected.getRoad(1) != tilePreview.getTile().getRoad(3)) {
                    return false;
                }
            }
            if (tile.getX() == x + 1 && tile.getY() == y) {
                westConnected = tile;
                if (westConnected.getRoad(3) != tilePreview.getTile().getRoad(1)) {
                    return false;
                }
            }
        }
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
        tilePreview.setTile(tilesPile.poll());
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
