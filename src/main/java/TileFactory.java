import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class TileFactory {

    Queue<Tile> getListOfTile() {
        LinkedList<Tile> tiles = new LinkedList<>();
        try {
            Scanner reader = new Scanner(new File("src\\main\\resources\\TilesInfo.csv"));
            while (reader.hasNextLine()) {
                String[] tab = reader.nextLine().split(";");
                BufferedImage bufferedImage = ImageIO.read(Tile.class.getResource("/tiles/PNG/Base_Game_C2_Tile_" + tab[0] + ".png"));
                tiles.add(new Tile(0, 0, bufferedImage));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.shuffle(tiles);
        return tiles;
    }
}
