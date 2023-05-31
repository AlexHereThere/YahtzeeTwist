
import Manos.Mano;
import Manos.ManoUnos;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *clase para probar algunas 
 * @author ACR
 */
public class DemoAyuda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
     
        String[] coloresDisponible ={"Amarillo","Azul","Naranja","Negro","Rojo","Rosa","Verde"};
        String[] figurasDisponible ={"circulo","cuadro","rectangulo","triangulo","pentagono","rombo"};   
        
    Jugador jugador = new Jugador(coloresDisponible,1);
    jugador.darLanzamientos(10);
    jugador.MostrarCanvasDeJugador();
    while(jugador.getSiguio()!=true){System.out.print("");}//lectura de lanzado
    jugador.getTabla().getManos().get(11).Evaluar(jugador.getDados());
    jugador.getTabla().mostrarTabla(jugador.getNumeroDeJugador());
    }
}
