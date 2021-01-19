
import java.awt.Color;
import java.awt.Graphics2D;


public class Calle {

    public Calle() {
        
    }
    
    public void pintar(Graphics2D g2){
        ////////////////////////////////////////////////////////////////////////
        //Calles Horizontal
        g2.setColor(new Color(179, 179, 179));
        g2.fillRect(565, 0, 150, 800);
        g2.setColor(new Color(66, 135, 245));
        g2.fillRoundRect(565, 250, 150, 25, 0, 0);
        g2.fillRoundRect(565, 445, 150, 25, 0, 0);
         
        //Calles Vertical
        g2.setColor(new Color(179, 179, 179));
        g2.fillRect(0, 285, 1300, 150);
        g2.setColor(new Color(23, 232, 255));
        g2.fillRoundRect(528, 285, 25, 150, 0, 0);
        g2.fillRoundRect(725, 285, 25, 150, 0, 0);
    }
    
}
