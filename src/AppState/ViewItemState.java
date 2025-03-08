package AppState;

import Objects.Background;

import java.awt.*;

public class ViewItemState extends AppState{

    private Background bg;
    private boolean viewItem;

    private int favourites;
    private String title;

    private Color titleColor;
    private Font titleFont;

    private Font font;

    public ViewItemState(AppStateManager asm)
    {
        this.asm = asm;
        viewItem = false;

        try
        {
            bg = new Background("/Background/SecondFrame.jpg");
            titleColor=new Color(0,0,0);
            titleFont = new Font("Monsterrat", Font.BOLD, 30);

            font = new Font("Bilo", Font.PLAIN, 16);
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
        //g.drawString("Products", 24, 128);
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
