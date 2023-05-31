
import java.util.Comparator;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *clase para comparar los puntos de los jugadores y decidir quien va primero
 * @author ACR
 */
public class ComparadorJugadoresPorPuntos implements Comparator<Jugador> {

    /**
     *compara puntaje total de dados
     * @param o1
     * @param o2
     * @return
     */
    @Override
    public int compare(Jugador o1, Jugador o2) {
        return o1.puntosMaxEntreDados() - o2.puntosMaxEntreDados();
    }
    
}
