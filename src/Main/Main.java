package Main;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame("iPhone 13 mini");
        window.setContentPane(new Device());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.pack();
        window.setVisible(true);

        window.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(window,
                        "Are you sure you want to close this window?", "Close Window?",
                        JOptionPane.YES_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION)
                {

                    Device.running = false;
                    //System.exit(0);
                    try {
                        Thread.sleep(800);
                    }catch (Exception e)
                    {
                        System.out.println("Eroare la inchiderea ferestrei...");
                    }
                }
                else
                {
                    Device.running = false;
                    //System.exit(0);
                    try {
                        Thread.sleep(800);
                    }catch (Exception e)
                    {
                        System.out.println("Eroare la inchiderea ferestrei...");
                    }
                }
            }
        });
    }
}