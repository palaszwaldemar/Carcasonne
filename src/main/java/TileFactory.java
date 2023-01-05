import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TileFactory {

    //getStartingTile

    Tile getNextTile(int x, int y) {
        try {
            BufferedImage bufferedImage = ImageIO.read(Tile.class.getResource("/tiles/PNG/Base_Game_C2_Tile_" + generateRandomTileSymbol() + ".png"));
            Tile tile = new Tile(x, y, bufferedImage);
            return tile;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    String generateRandomTileSymbol() {
        List<String> symbols = List.of("U", "D", "X");
        Random random = new Random();
        int indexOfSymbol = random.nextInt(symbols.size());
        return symbols.get(indexOfSymbol);
    }
}
