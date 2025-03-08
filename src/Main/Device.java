package Main;

import AppState.AppStateManager;
import Objects.ProductList;
import WebRequest.Request;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

public class Device extends JPanel implements Runnable, MouseListener, KeyListener {

    //dimesiunea ferestrei
    public static final int WIDTH = 403;
    public static final int HEIGHT = 840;
    public static final int SCALE = 1;

    // app thread
    private Thread thread;
    public static boolean running;
    private int FPS =  60;
    private long targetTime = 1000 / FPS;

    // image -- the canvas
    private BufferedImage image;
    private Graphics2D g;

    //Handlers
    private AppStateManager asm;
    private Request data;

    // Data
    private ProductList products;

    // Constructor
    public Device()
    {
        super();
        setPreferredSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
        setFocusable(true);
        requestFocus();
    }

    // Thread pentru gestionarea tastaturii
    public void addNotify()
    {
        super.addNotify();
        if(thread == null)
        {
            thread = new Thread(this);
            addKeyListener(this);
            thread.start();
        }
    }

    public void run()
    {
        init();

        // Bucla pentru timpul petrecut in aplicatie
        while(running)
        {
            update();
            draw();
            drawToScreen();
        }
    }

    private void init()
    {
        image = new BufferedImage(WIDTH*SCALE, HEIGHT*SCALE, BufferedImage.TYPE_INT_RGB);
        g = (Graphics2D) image.getGraphics();

        running = true;

        asm = new AppStateManager();
        data = new Request();
        products = new ProductList();

        data.getData();
        data.generateProductList(products);
    }

    private void update() {asm.update(); }
    private void draw() {asm.draw(g); }
    private void drawToScreen()
    {
        Graphics g2 = getGraphics();
        g2.drawImage(image, 0,0,WIDTH*SCALE, HEIGHT*SCALE, null);
        g2.dispose();
    }

    // Keyboard events
    public void keyTyped(KeyEvent key){}
    public void keyPressed(KeyEvent key){asm.keyPressed(key.getKeyCode());}
    public void keyReleased(KeyEvent key){asm.keyReleased(key.getKeyCode());}

    // Mouse events
    public void mousePressed(MouseEvent e){/*asm.mousePressed(e.getX(), e.getY());*/}
    public void mouseReleased(MouseEvent e){/*asm.mouseReleased();*/}

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public void mouseClicked(MouseEvent e){/*asm.mouseClicked();*/}
}
