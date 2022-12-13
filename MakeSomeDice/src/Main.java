import javax.swing.*;
import java.awt.*;
import javax.swing.*;
import java.awt.*;

public class Main {
    private static final Toolkit KIT = Toolkit.getDefaultToolkit();
    private static final Dimension SCREEN_SIZE = KIT.getScreenSize();
    public static void main(String[] args) {
        DrawDice drawDice = new DrawDice(10, 10);
        GridBagConstraints c = new GridBagConstraints();
        JPanel p = new JPanel();
        JFrame jFrame = new JFrame();
        jFrame.setLocation(SCREEN_SIZE.width / 2 - jFrame.getWidth() / 2,
                SCREEN_SIZE.height / 2 - jFrame.getHeight() / 2);
        jFrame.pack();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(800, 750);
        jFrame.setMinimumSize(new Dimension(700, 750));
        jFrame.setVisible(true);
        jFrame.setBackground(Color.RED);
        jFrame.add(drawDice);

//        c.ipadx = 50;
//        c.ipady = 50;
//        p.add(drawDice, c);


    }
}

class DrawDice extends JPanel {

    private int myX;
    private int myY;
    private static final Color invisible = new Color(1f,0f,0f,0f);


    public DrawDice( int theX, int theY) {
//        super(theLayout);
        myX = theX;
        myY = theY;
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawRect(myX, myY + 50, 100,100);
        g2D.setPaint(Color.RED);
        g2D.fillRect(myX, myY + 50,100,100);
//
        g2D.drawRect(myX, myY + 200, 100,100);
        g2D.setPaint(Color.BLUE);
        g2D.fillRect(myX, myY + 200,100,100);
//
        g2D.drawOval(myX, myY + 100, 10, 10);
        g2D.setPaint(Color.BLACK);
        g2D.fillOval(myX, myY + 100, 10, 10);

    }

//    private void paintDots(Graphics theGraphics) {
//        theGraphics.drawOval(50, 50, 10, 10);
//        setForeground(Color.RED);
//        theGraphics.fillOval(50,50,10,10);
//    }


}
