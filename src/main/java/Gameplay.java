import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class Gameplay implements MouseListener {
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

    void spawnTile(int x, int y) {
        System.out.printf("Stworzenie tile w pozycji: x:%d y:%d\n", x, y);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {spawnTile(Cords.xPixelsToCords(e.getX()), Cords.yPixelsToCords(e.getY()));

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

//drukuje sie pozycja x, y która została kliknieta
//wstawia sie tile w pozycje x, y
//można wstawiac tylko w te miescja przylegajace
