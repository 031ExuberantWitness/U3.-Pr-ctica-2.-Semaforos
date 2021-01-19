
import java.awt.Color;
import java.awt.Graphics2D;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JPanel;


public class Vehiculo extends JPanel{
    public int x, y;
    int desplazamientoX, desplazamientoY;
    
    Color colorSI, colorSD;
    int vehiculo;
    
    Lienzo puntero;
    Random rand = new Random();
    
    Color rojo =  new Color(20, 196, 0);
    Color amarillo = new Color(220, 240, 0);
    Color verde = new Color(168, 50, 50);
    
    public Vehiculo(int xx, int yy, int v) {
        x = xx;
        y = yy;
        vehiculo = v;
        
        desplazamientoX = 5;
        desplazamientoY = 5;
        
        setDoubleBuffered(true);
    }
    
    
    public void pintar(Graphics2D g2){
        ////////////////////////////////////////////////////////////////////////
        //Pinta el auto
        try {
            g2.drawImage(ImageIO.read(getClass().getResource("vehiculo" + vehiculo + ".png")), x, y, puntero);
        } catch (IOException ex) {
            showMessageDialog(null, ex);
        }
    }
    
    public void colorFoco(int s, int n){
        if(s == 0){
            switch(n){
            case 0: colorSI = new Color(20, 196, 0); //Verde
                break;
            case 1: colorSI = new Color(220, 240, 0); //Amarrillo
                break;
            case 2: colorSI = new Color(168, 50, 50); //Rojo
                break;
            default: colorSI = new Color(168, 50, 50);
            }
        }else{
            switch(n){
            case 2: colorSD = new Color(20, 196, 0); //Verde
                break;
            case 1: colorSD = new Color(220, 240, 0); //Amarrillo
                break;
            case 0: colorSD = new Color(168, 50, 50); //Rojo
                break;
            default: colorSD = new Color(168, 50, 50); //Rojo
            }
        }
    }
    
    public void mover(int n){
        switch(n){
                case 0: ////////////////////////////////////////////////////////
                        //Control de desplazamiento
                        y += desplazamientoY;
                        if(y <= 0){
                            desplazamientoY = 3 + rand.nextInt(3);
                        }else if(y >= 720-10){
                            vehiculo = rand.nextInt(6);
                            y = -150;;
                        }
                        
                        ////////////////////////////////////////////////////////
                        //Detiene el auto si esta el semaforo en rojo y en linea peatonal
                        if(colorSI.equals(verde)){
                            if(y <= 185){
                                desplazamientoY = 0;
                            }else{
                                desplazamientoY = 3 + rand.nextInt(3);
                            }
                        }
                    break;
                case 1: ////////////////////////////////////////////////////////
                        //Control de desplazamiento
                        y -= desplazamientoY;
                        if(y >= 0){
                            desplazamientoY = 3 + rand.nextInt(3);
                        }else if(y >= 0-125){
                            vehiculo = rand.nextInt(6);
                            y = 1300;
                        } 
                        
                        ////////////////////////////////////////////////////////
                        //Detiene el auto si esta el semaforo en rojo y en linea peatonal
                        if(colorSI.equals(verde)){
                            if(y <= 480){
                                desplazamientoY = 0;
                            }else{
                                desplazamientoY = 3 + rand.nextInt(3);
                            }
                        }
                    break;
                case 2: ////////////////////////////////////////////////////////
                        //Control de desplazamiento
                        x += desplazamientoX;
                        if(x >= 0){
                            desplazamientoX = 1 + rand.nextInt(3);;
                        }else if(x <= 1280-600){
                            x = -150;
                            vehiculo = rand.nextInt(6);
                        }
                        
                        ////////////////////////////////////////////////////////
                        //Detiene el auto si esta el semaforo en rojo y en linea peatonal

                        if(!colorSD.equals(rojo)){
                            if(x >= 466){
                               desplazamientoX = 0;
                        }else{
                            desplazamientoX = 1 + rand.nextInt(3);
                            }
                        }
                    break;
                case 3: ////////////////////////////////////////////////////////
                        //Control de desplazamiento
                        x -= desplazamientoX;
                        if(x >= 0){
                            desplazamientoX = 2 + rand.nextInt(3);
                        }else if(x >= 0-125){
                            x = 1600;
                            vehiculo = rand.nextInt(6);
                        } 
                        
                        ////////////////////////////////////////////////////////
                        //Detiene el auto si esta el semaforo en rojo y en linea peatonal
                        if(!colorSD.equals(rojo)){
                            if(x <= 765){
                            desplazamientoX = 0;
                            }else{
                                desplazamientoX = 2 + rand.nextInt(3);
                            }
                        }
                    break;
                default:
        }
    }
}
