
package graficos;

import java.awt.Color;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TestPaintComponent extends JFrame{
    public TestPaintComponent(){
        add(new NewPanel());
    }
   
 public static void main(String[] args) {
    TestPaintComponent frame = new TestPaintComponent();
    frame.setTitle("TestPaintComponent");
    frame.setSize(1024,520);
    frame.setLocationRelativeTo(null); //Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    }
 }

    class NewPanel extends JPanel implements ActionListener, MouseListener {
    private Timer timer;
    private int x;
    int secuencia;
    
    public NewPanel (){
   timer = new Timer(25, this);
   this.addMouseListener(this);
   this.timer.start();
   this.x = 100;
}
    
     @Override
    protected void paintComponent(Graphics g){
        
     super.paintComponent (g);
     Image fondo = loadImage("fondo.png");
     g.drawImage(fondo, 0, 0, null);
     Image gato = loadImage("cats.gif");
     g.drawImage(gato, 600, 400, 732, 480,(this.secuencia*132),0,(this.secuencia*132)+132,80,this);
     
     
     g.drawRect(630, 400, 100, 200); 
     g.setColor(Color.blue);
    g.fillRect(x, 400, 70, 20);
    g.setColor(Color.black);
    g.fillOval(x+10, 420, 20, 20);
    g.fillOval(x+40, 420, 20, 20);
    Polygon polygon = new Polygon();
    polygon.addPoint(x+10, 400);
    polygon.addPoint(x+20, 380);
    polygon.addPoint(x+50, 380);
    polygon.addPoint(x+60, 400);
    g.fillPolygon(polygon);
    g.drawRect(x-5, 370, 80,70 );
         System.out.println("Cclick");
         
 }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        
        this.x+=1;
        checkCollisions();
        x += 5;
        if(this.secuencia == 5){
            this.secuencia = 0;
        }else {
            this.secuencia++;
    }
   
        repaint();
    }
 public void checkCollisions(){
    Rectangle Carro = this.getBounds();
    Rectangle obstaculo = new Rectangle (630, 200, 100, 200);
    if (obstaculo.intersects(Carro)){
                System.out.println("Colision");
                timer.stop();
    }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        Point mp = e.getPoint();
        if(getBounds().contains(mp)){
         timer.stop();
        }
        System.out.println("Sharem Alonso C ");
    }

    @Override
    public void mousePressed(MouseEvent e) {
       
    }

    @Override
    public void mouseReleased(MouseEvent e) {
      
    }

    @Override
    public void mouseEntered(MouseEvent e) {
      
    }

    @Override
    public void mouseExited(MouseEvent e) {
     
    }
   
    public Rectangle getBounds(){
        return new Rectangle(x-5, 170, 80,70);
    }
    
   public Image loadImage(String imageName){
       ImageIcon ii = new ImageIcon(imageName);
       Image image = ii.getImage();
       return image;
   }
   
}
    
