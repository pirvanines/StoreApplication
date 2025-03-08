package AppState;

import java.awt.*;

public abstract class AppState {
    protected AppStateManager asm;

    public abstract void init();
    public abstract void update();
    public abstract void draw(Graphics2D g);
    public abstract void keyPressed(int k, AppStateManager appStateManager);
    public abstract void keyReleased(int k);
}
