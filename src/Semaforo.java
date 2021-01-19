
import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.JPanel;


public class Semaforo extends JPanel{
    public Color color;
    public int x, y;
    
    public Color colorFoco = new Color(20, 196, 0);
    public int xFoco, yFoco;

    public boolean s1 = true;
    public boolean s2 = true;
    
    public Semaforo() {
        
    }
    
    public Semaforo(Color color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
        
    }

    public Color getColorFoco() {
        return colorFoco;
    }
    
    public void pintar(Graphics2D g2){
        
        
        ////////////////////////////////////////////////////////////////////////
        //Semaforo fondo
        g2.setColor(color);
                    //    X    Y   W    H   °   °
        g2.fillRoundRect(x, y, 75, 250, 45, 45);
        
        ////////////////////////////////////////////////////////////////////////
        //Foco
        g2.setColor(colorFoco);
        g2.fillOval(xFoco,yFoco, 50, 50);
    }
    
    public void cambiarColor(int s,int n){
        if(s == 0){
            switch(n){
            case 0: colorFoco = new Color(20, 196, 0); //Verde
                    xFoco = 487;
                    yFoco = 24;
                break;
            case 1: colorFoco = new Color(220, 240, 0); //Amarrillo
                    xFoco = 487;
                    yFoco = 110;
                break;
            case 2: colorFoco = new Color(168, 50, 50); //Rojo
                    xFoco = 487;
                    yFoco = 200;
                break;
            default: colorFoco = new Color(168, 50, 50);
                     xFoco = 487;
                     yFoco = 200;
            }
        }else{
            switch(n){
            case 2: colorFoco = new Color(20, 196, 0); //Verde
                    yFoco = 460;
                break;
            case 1: colorFoco = new Color(220, 240, 0); //Amarrillo
                    yFoco = 545;
                break;
            case 0: colorFoco = new Color(168, 50, 50); //Rojo
                    yFoco = 635;
                    xFoco = 742;
                break;
            default: colorFoco = new Color(168, 50, 50); //Rojo
                     yFoco = 200;
            }
        }
    }
}
