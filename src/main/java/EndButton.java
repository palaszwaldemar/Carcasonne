import java.awt.*;

public class EndButton {
    private final int x = 1690;
    private final int y = 10;
    private final static int WIDTH = 100;
    private final static int HEIGHT = 50;


    void render(Graphics g) {
        g.drawRect(x, y, WIDTH, HEIGHT);
    }

    public boolean isOnButton(int pixelX, int pixelY){
        return (pixelX >= x && pixelX <= x + WIDTH) && (pixelY >= y && pixelY <= y + HEIGHT);
    }
}
