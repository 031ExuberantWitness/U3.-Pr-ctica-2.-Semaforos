import java.awt.Color;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;


public class HiloVehiculo extends Thread{
    private boolean pausado = false;
    private boolean ejecutar = true;
    private int contador = 0, contador2 = 0, sleeping;
    
    Lienzo puntero;
    FrmHome base;
    
    Color rojo =  new Color(20, 196, 0);
    Color amarillo = new Color(220, 240, 0);
    Color verde = new Color(168, 50, 50);
    
    public HiloVehiculo(Lienzo p){
        puntero = p;
    }
    
    public void pausar(){
        pausado = !pausado;
    }
    
    public void detener(){
        ejecutar = false;
    }
    
    private int controlador(){
        return 0;
    }
    

    
    @Override
    public void run(){
        while(ejecutar){
            try {
                if(estaDespausado()){
                    puntero.vh[0].mover(0);
                    puntero.vh[1].mover(1);
                    puntero.vh[2].mover(2);
                    puntero.vh[3].mover(3);
                    
                    
                    puntero.repaint();
                }
                sleep(5);
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloVehiculo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private boolean estaDespausado(){
        return !pausado;
    }
}