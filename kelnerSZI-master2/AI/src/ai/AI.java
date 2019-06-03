package ai;

import java.awt.*;
import java.awt.geom.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


public class AI extends JFrame {
    public AI() {
        super("Restauracja");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MapPane map = new MapPane();
        add(map);
        setVisible(true);
    }

    public static void main(String[] arguments) {
        AI frame = new AI();
    }

}

class MapPane extends JPanel {
    public void paintComponent(Graphics comp) {
        //background mozna i bez tego 
        Graphics2D comp2D = (Graphics2D) comp;
        comp2D.setColor(Color.white);
        comp2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        Rectangle2D.Float background = new Rectangle2D.Float(
            0F, 0F, getSize().width, getSize().height);
        comp2D.fill(background);
        // koniec background
        
           //rysowanie prostokontow - mapy restauracji 
        comp2D.setColor(Color.black);
        BasicStroke pen2 = new BasicStroke();
        comp2D.setStroke(pen2);
        
     
        
        Rectangle2D.Float a2 = new Rectangle2D.Float(260, 100, 80, 80);
        comp2D.fill(a2);
        
      
        
        Rectangle2D.Float a4 = new Rectangle2D.Float(580, 100, 80, 80);
        comp2D.fill(a4);
          
        Rectangle2D.Float b1 = new Rectangle2D.Float(100, 260, 80, 80);
        comp2D.fill(b1);
        
        Rectangle2D.Float b2 = new Rectangle2D.Float(260, 260, 80, 80);
        comp2D.fill(b2);
        
        Rectangle2D.Float b3 = new Rectangle2D.Float(420, 260, 80, 80);
        comp2D.fill(b3);
        
        Rectangle2D.Float b4 = new Rectangle2D.Float(580, 260, 80, 80);
        comp2D.fill(b4);
        
        Rectangle2D.Float b5 = new Rectangle2D.Float(740, 260, 80, 80);        
        comp2D.fill(b5);
        
        
        Rectangle2D.Float c2 = new Rectangle2D.Float(260, 420, 80, 80);
        comp2D.fill(c2);
        
        
        Rectangle2D.Float c4 = new Rectangle2D.Float(580, 420, 80, 80);
        comp2D.fill(c4);
        
         
        Rectangle2D.Float d1 = new Rectangle2D.Float(100, 580, 80, 80);
        comp2D.fill(d1);
        
        Rectangle2D.Float d2 = new Rectangle2D.Float(260, 580, 80, 80);
        comp2D.fill(d2);
         
        Rectangle2D.Float d3 = new Rectangle2D.Float(420, 580, 80, 80);
        comp2D.fill(d3);
        
        Rectangle2D.Float d4 = new Rectangle2D.Float(580, 580, 80, 80);
        comp2D.fill(d4);
        
        
        
        Rectangle2D.Float c5 = new Rectangle2D.Float(740, 420, 80, 80);
        comp2D.fill(c5);
        //
        
        //Stoliki
         comp2D.setColor(Color.yellow);
        Rectangle2D.Float a1 = new Rectangle2D.Float(100, 100, 80, 80);
        comp2D.fill(a1);
        
        
        Rectangle2D.Float a3 = new Rectangle2D.Float(420, 100, 80, 80);
        comp2D.fill(a3);
        
        
        Rectangle2D.Float a5 = new Rectangle2D.Float(740, 100, 80, 80);
        comp2D.fill(a5);
        
        
     
        Rectangle2D.Float c1 = new Rectangle2D.Float(100, 420, 80, 80);
        comp2D.fill(c1);
        
        Rectangle2D.Float c3 = new Rectangle2D.Float(420, 420, 80, 80);
        comp2D.fill(c3);
        //kuchnia
        comp2D.setColor(Color.red);
       
        Rectangle2D.Float d5 = new Rectangle2D.Float(740, 580, 80, 80);
        comp2D.fill(d5);
        
       
        
        //numery wierszow i kolumn
        comp2D.setColor(Color.black);
        int y = 140;
        for (int i = 1; i <=4; i++)
        {
            comp2D.drawString(Integer.toString(i), 40 , y);
            y = y + 160;
        }
        y = 140;
        for (int i = 1; i <=5; i++)
        {
            comp2D.drawString(Integer.toString(i), y , 40);
            y = y + 160;
        }
        comp2D.drawString("kuchnia", 760, 620);
        comp2D.drawString("stolik 1", 120, 120);
        comp2D.drawString("stolik 2", 440, 120);
        comp2D.drawString("stolik 3", 760, 120);
        comp2D.drawString("stolik 4", 120, 440);
        comp2D.drawString("stolik 5", 440, 440);
        //
        
        
        Rectangle w = new Rectangle(0, 0, 40, 40);
        comp2D.fill(w);
        
    }
}
