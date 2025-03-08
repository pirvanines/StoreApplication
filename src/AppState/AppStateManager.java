package AppState;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class AppStateManager {
    private static ArrayList<AppState> appStates;
    private static int currentState;

    public static final int HOME_STATE = 0;
    public static final int VIEW_ITEM_STATE = 1;

    public AppStateManager()
    {
        // Initializeaza lista si starea curenta a ecranului
        appStates = new ArrayList<AppState>();
        currentState = HOME_STATE;

        // Adauga cele doua stari posibile ale ecranului
        appStates.add(new HomeState(this));
        appStates.add(new ViewItemState(this));
    }

    public void setState(int state)
    {
        currentState = state;
        appStates.get(currentState).init();
    }

    // Update si Draw pentru fiecare frame
    public void update(){appStates.get(currentState).update(); }
    public void draw(Graphics2D g){appStates.get(currentState).draw(g);}

    // Key events
    public void keyPressed(int k){appStates.get(currentState).keyPressed(k, this);}
    public void keyReleased(int k){appStates.get(currentState).keyReleased(k); }

    // Mouse events
    //public void mousePressed(MouseEvent e){asm.mousePressed(e.getX(), e.getY());}
    //public void mouseReleased(MouseEvent e){asm.mouseReleased();}
    //public void mouseClicked(MouseEvent e){asm.mouseClicked();}
}
