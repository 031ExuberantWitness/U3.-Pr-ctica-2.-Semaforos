import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;


public class Lienzo extends JPanel{
    Semaforo smI = new Semaforo(new Color(66, 135, 245), 475, 15);
    Semaforo smD = new Semaforo(new Color(23, 232, 255), 730, 450);
    
    Color rojo =  new Color(20, 196, 0);
    Color verde = new Color(168, 50, 50);
    Color sm0 = verde, sm1 = rojo;
    
    Calle cl = new Calle();
    Vehiculo[] vh;
    
    HiloSemaforo hs = new HiloSemaforo(this);
    HiloVehiculo hv = new HiloVehiculo(this);
    
    public Lienzo() {
        vh = new Vehiculo[9];
        
                          // X , Y
        vh[0] = new Vehiculo(572,1, 0);
        vh[1] = new Vehiculo(655,645, 1);
        vh[2] = new Vehiculo(1,285, 2);
        vh[3] = new Vehiculo(1180,380, 3);
        
        
        hs.start();
        hv.start();
    }
    
    public Color obtenerColor(int n){
        switch(n){
            case 0: return smD.getColorFoco();
            case 1: return smI.getColorFoco();
        }
        
        return smD.getColorFoco();
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        Graphics2D g2 = (Graphics2D) g;
        setBackground(Color.white);
        
        
        smI.pintar(g2);
        smD.pintar(g2);
        
        sm0 = smI.colorFoco;
        sm1 = smD.colorFoco;
        
        cl.pintar(g2);
        

        
        
        vh[0].pintar(g2);
        vh[1].pintar(g2);
        vh[2].pintar(g2);
        vh[3].pintar(g2);
        
    }
}
