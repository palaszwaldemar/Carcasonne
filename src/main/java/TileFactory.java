import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TileFactory {

    //getStartingTile

    Tile getNextTile(int x, int y) {
        String symbol = generateRandomTileSymbol();
        try {
            BufferedImage bufferedImage = ImageIO.read(Tile.class.getResource("/tiles/PNG/Base_Game_C2_Tile_" + symbol + ".png"));
            Tile tile = new Tile(x, y, bufferedImage);
            switch (symbol) {
                case "U" -> {
                    tile.setRoad('N');
                    tile.setRoad('S');
                }
                case "D" -> {
                    tile.setRoad('E');
                    tile.setRoad('W');
                }
                case "X" -> {
                    tile.setRoad('N');
                    tile.setRoad('E');
                    tile.setRoad('S');
                    tile.setRoad('W');
                }
            }
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
