package jade;

import util.Time;

import javax.swing.JFrame;
import java.awt.event.KeyEvent;

public class Window extends JFrame implements Runnable {

    public ML mouseListener;
    public KL keyListener;

    private static Window window = null;
    private boolean isRunning = true;
    private Scene currentScene = null;

    public Window() {
        this.mouseListener = new ML();
        this.keyListener = new KL();

        this.setSize(1280,720);
        this.setTitle("Geometry Dash");
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(keyListener);
        this.addMouseListener(mouseListener);
        this.addMouseMotionListener(mouseListener);
        this.setLocationRelativeTo(null);
    }

    public void init() {
        changeScene(0);
    }

    public void changeScene(int scene) {
        switch (scene) {
            case 0:
                currentScene = new LevelEditorScene("Level Editor");
                break;
            default:
                System.out.println("Do not know what this scene is.");
                currentScene = null;
                break;
        }
    }

    public static Window getWindow() {
        if (Window.window == null) {
            Window.window = new Window();
        }

        return Window.window;
    }

    public void update(double dt) {
        currentScene.update(dt);
    }

    @Override
    public void run() {
        double lastFrameTime = 0.0;
        try {
            while(isRunning) {
                double time = Time.getTime();
                double deltaTime = time - lastFrameTime;
                lastFrameTime = time;

                update(time);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
