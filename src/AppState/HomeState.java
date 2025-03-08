package AppState;

import Main.Device;
import Objects.Background;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HomeState extends AppState{

    private Background bg;
    private boolean viewItem;

    private int favourites;
    private String title;

    private Color titleColor;
    private Font titleFont;

    private Font font;

    public HomeState(AppStateManager asm)
    {
        this.asm = asm;
        viewItem = false;

        try
        {
            bg = new Background("/Background/FirstFrame.jpg");
            titleColor=new Color(0,0,0);
            titleFont = new Font("Monsterrat", Font.BOLD, 30* Device.SCALE);

            font = new Font("Bilo", Font.PLAIN, 16*Device.SCALE);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void init() {}

    public void update() {}

    public void draw(Graphics2D g)
    {
        bg.draw(g);

        g.setColor(titleColor);
        g.setFont(titleFont);
        g.drawString("Products", 24 * Device.SCALE, 128 * Device.SCALE);
    }

    public void select(AppStateManager asm)
    {
        if(viewItem)
        {
           asm.setState(AppStateManager.VIEW_ITEM_STATE);
        }
        else
        {
            asm.setState(AppStateManager.HOME_STATE);
        }
    }

    @Override
    public void keyReleased(int k) {

    }

    @Override
    public void keyPressed(int k, AppStateManager asm) {

    }
}
