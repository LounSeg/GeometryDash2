package jade;

import util.Time;

import javax.swing.JFrame;

public class Window extends JFrame implements Runnable {

    private static Window window = null;
    private boolean isRunning = true;

    public Window() {
        this.setSize(1280,720);
        this.setTitle("Geometry Dash");
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    public void init() {

    }

    public static Window getWindow() {
        if (Window.window == null) {
            Window.window = new Window();
        }

        return Window.window;
    }

    public void update(double dt) {
        System.out.println(dt);
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