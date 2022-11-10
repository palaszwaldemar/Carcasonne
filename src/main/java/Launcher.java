public class Launcher {
    public static void main(String[] args) {

        GameEngine gameEngine = new GameEngine(new Display("Carcasonne"), new Gameplay());
        gameEngine.start();
    }
}
