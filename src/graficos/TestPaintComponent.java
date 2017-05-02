
package graficos;

import java.awt.Color;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestPaintComponent extends JFrame{
    public TestPaintComponent(){
        add(new NewPanel());
    }
   
 public static void main(String[] args) {
    TestPaintComponent frame = new TestPaintComponent();
    frame.setTitle("TestPaintComponent");
    frame.setSize(500,500);
    frame.setLocationRelativeTo(null); //Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    }
 }

class NewPanel extends JPanel implements ActionListener {
    private Timer timer;
    private int x;
    
    public NewPanel (){
   timer = new Timer(25, this);
   this.timer.start();
   this.x = 100;
}
    
     @Override
    protected void paintComponent(Graphics g){
           
    g.setColor(Color.blue);
    g.fillRect(x, 200, 70, 20);
    g.setColor(Color.black);
    g.fillOval(x+10, 220, 20, 20);
    g.fillOval(x+40, 220, 20, 20);
    Polygon polygon = new Polygon();
    polygon.addPoint(x+10, 200);
    polygon.addPoint(x+20, 180);
    polygon.addPoint(x+50, 180);
    polygon.addPoint(x+60, 200);
    g.fillPolygon(polygon);
    g.drawRect(x-5, 170, 80,70 );
         System.out.println("Cclick");
     
    
}

    @Override
    public void actionPerformed(ActionEvent e) {
     //  this.x+=20;
        repaint();
    }
    
}
    
