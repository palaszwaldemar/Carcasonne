import java.awt.*;

public class EndButton {
    private final int x = 1690;
    private final int y = 10;
    private final static int WIDTH = 100;
    private final static int HEIGHT = 50;
    private boolean isDisable;

    void render(Graphics g) {
        if (isDisable) {
            g.setColor(Color.GRAY);
        } else {
            g.setColor(Color.GRAY.brighter());
        }
        g.fillRect(x, y, WIDTH, HEIGHT);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, WIDTH, HEIGHT);
    }

    public boolean isOnButton(int pixelX, int pixelY) {
        return (pixelX >= x && pixelX <= x + WIDTH) && (pixelY >= y && pixelY <= y + HEIGHT);
    }


    public void disable() {
        isDisable = true;
    }

    public void enable() {
        isDisable = false;
    }
}