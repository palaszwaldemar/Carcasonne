public class Cords {

    static int xPixelsToCords(int x) {
        return x / 100;
    }

    static int yPixelsToCords(int y) {
        return y / 100;
    }

    static int xCordsToPixels(int x) {
        return x * 100;
    }

    static int yCordsToPixels(int y) {
        return y * 100;
    }
}
