
import java.awt.Color;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;


public class HiloSemaforo extends Thread{
    private boolean pausado = false;
    private boolean ejecutar = true;
    private int contador = 0, sleeping;
    
    boolean ctrl = true;
    
    Color verde =  new Color(20, 196, 0);
    Color amarillo = new Color(220, 240, 0);
    Color rojo = new Color(168, 50, 50);
    
    Lienzo puntero;
    
    public HiloSemaforo(Lienzo p){
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
                    puntero.smD.cambiarColor(1, contador);
                    puntero.smI.cambiarColor(0, contador);
                    
                    puntero.vh[0].colorFoco(0, contador);
                    puntero.vh[1].colorFoco(0, contador);
                    puntero.vh[2].colorFoco(1, contador);
                    puntero.vh[3].colorFoco(1, contador);
                    
                    contador++;
                    
                    switch(contador){
                        case 0: sleeping = 10000;
                            break;
                        case 1: sleeping = 5000;
                            break;
                        case 2: sleeping = 10000;
                            break;
                        default: sleeping = 5000;
                    }
                    
                    if(contador > 2) contador = 0;
                    puntero.repaint();
                }
                sleep(sleeping);
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloSemaforo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private boolean estaDespausado(){
        return !pausado;
    }
}
