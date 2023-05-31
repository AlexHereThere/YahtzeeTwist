
import Manos.Mano;
import java.util.ArrayList;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author ACR
 */
public class Demo {

    /**
     * clase para verificar que funcione bien las otras clases (para pruebas)
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        
        String[] coloresDisponible ={"Amarillo","Azul","Naranja","Negro","Rojo","Rosa","Verde"};
        String[] figurasDisponible ={"circulo","cuadro","rectangulo","triangulo","pentagono","rombo"};
        
        
       Juego juego = new Juego(2,coloresDisponible,figurasDisponible);
       juego.jugarJuego();
      
     

    }
    
}
