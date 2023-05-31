
import Manos.Mano;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *Clase para modelar todo lo del juego, aqui se aplican la mayoria de las reglas
 * @author ACR
 */
public class Juego {

    private final int numeroDeJugadores;
    private final ArrayList<Jugador> jugadores;
    //constructor
    public Juego(int numeroDeJugadores,String[] colores, String[] figuras) {
        this.numeroDeJugadores = numeroDeJugadores;
        jugadores = new ArrayList();
        crearJugadores(jugadores,colores,figuras);
    }

    /**
     * metodo para jugar el juego
     *
     */
    public void jugarJuego() {
        System.out.println("Hola Jugaremos YAHTZEE!");
        decidirOrdenJugadores();
        
        int ContadoDeJugadoresLlenos=0;
        do{
            for(Jugador jugador:jugadores)
            {
                realizarRonda(jugador);
                if(jugador.TodasManosUsadas())ContadoDeJugadoresLlenos++;
            }
        }while(ContadoDeJugadoresLlenos<jugadores.size());
        
        terminar(); 
    }
/**
 * metodo para crear los jugadores segun, se decide aleatoriamente cual usara dado numerico o de figuras.
 * Tambien se crea sus manos
 * @param jugadores
 * @param colores
 * @param figuras 
 */
    private void crearJugadores(ArrayList<Jugador> jugadores, String[] colores, String[] figuras) {

        
        Boolean booleanParaDecidirTipoDeDado = new Random().nextBoolean();
        for(int i=0;i<numeroDeJugadores;i++) {//para cada jugador
            if (booleanParaDecidirTipoDeDado == true) {
                booleanParaDecidirTipoDeDado = false;
                jugadores.add(new Jugador(colores,i+1));//se le suma 1 al iterador para representar bien el numero de jugador
            } else {
                booleanParaDecidirTipoDeDado = true;
                jugadores.add(new Jugador(colores, figuras,i+1));
            }
        }
    }
/**
 * metodo para decidir el orden de cual jugador sera el primero
 * @param jugadores 
 */
    private void decidirOrdenJugadores() {
        System.out.println("Vamos a decidir el orden.");
       
        for(Jugador jugador:jugadores)
        {
        System.out.println("turno Jugador "+jugador.getNumeroDeJugador());
        jugador.darLanzamientos(1);//se les da un lanzamiento para empezar
        jugador.MostrarCanvasDeJugador();
        while(jugador.getSiguio()!=true){System.out.print("");}//lectura de lanzado
        jugador.setSiguio(false);// para poder leer el lanzado despues
        jugador.EsconderCanvasDeJugador();
        }
        for(Jugador jugador:jugadores)
        {
            System.out.println("Jugador "+jugador.getNumeroDeJugador()+" acumulo: "+jugador.puntosMaxEntreDados());  
        }
        Collections.sort(jugadores, new ComparadorJugadoresPorPuntos());//ordena los jugadores segun sus puntos
        Collections.reverse(jugadores);//para hacerlo de mayor a menor
        System.out.println("nuevo Orden:");
         for(Jugador jugador:jugadores)
        {
        System.out.println("Jugador "+jugador.getNumeroDeJugador());//mostrar nuevo orden 
        }
        
        
    }
    /**
     * metodo para hacer lo que se hace en una ronda
     * @param jugador 
     */
    private void realizarRonda(Jugador jugador)
    {
        System.out.println("Ahora...");
     jugador.getTabla().mostrarTabla(jugador.getNumeroDeJugador());
     jugador.darLanzamientos(2);//dos lanzamientos extra ya que el juego lanza por el jugador 1 vez...
     jugador.MostrarCanvasDeJugador();
     while(jugador.getSiguio()!=true){System.out.print("");}//lectura de lanzado
     jugador.setSiguio(false);//para poder leer lanzado
     jugador.evaluarDadosConMano();
        System.out.println("Resultado...");
     jugador.getTabla().mostrarTabla(jugador.getNumeroDeJugador());//imprimir como va el jugadpor
     jugador.EsconderCanvasDeJugador();
    }
    
    /**
     * metodo para dar el resultado del juego
     * @param jugadores 
     */
    private void terminar()
    {
        System.out.println("");//solo para brinco de linea
        System.out.println("         SE TERMINO EL JUEGO...");    
        System.out.println("----------------Resultados-----------------");
        for(Jugador jugador :jugadores)
        {
        jugador.getTabla().mostrarTabla(jugador.getNumeroDeJugador());
        }
        extraPorSeccionSuperior();
        indicarGanador();
    }
    /**
     * metodo para conocer y mostrar los ganadores del juego
     */
    private void indicarGanador()
    {
    int ContadorDePuntosMax=jugadores.get(0).getTabla().getContadorDePuntos();
        for(Jugador jugador: jugadores)
        {
            if(jugador.getTabla().getContadorDePuntos()>ContadorDePuntosMax)//determinar el puntaje maximo obtenido entre
            ContadorDePuntosMax=jugador.getTabla().getContadorDePuntos();//todos los jugadores
        }
        System.out.println("");
        System.out.println("GANADORES");
        for(Jugador jugador: jugadores)
        {
            if(jugador.getTabla().getContadorDePuntos()==ContadorDePuntosMax)
                System.out.println("Jugador "+jugador.getNumeroDeJugador());//solo desplegar los que ganaron 
        }
    }

    /**
     * metodo para considerar el extra por acumular 63 puntos en seccion Superior
     */
    private void extraPorSeccionSuperior()
    {
    int puntosMaxPorSeccionSuperior=0;       
    for(Jugador jugador:jugadores)
    {
        for(Mano mano :jugador.getTabla().getManosSuperior())
        {
            puntosMaxPorSeccionSuperior+=mano.getPuntaje();
        }
        if(puntosMaxPorSeccionSuperior>=63)
        {
            System.out.println("Jugador "+jugador.getNumeroDeJugador()+" obtiene +35 por acumulo de 63 puntos en seccion superior!!");
            jugador.getTabla().setContadorDePuntos(jugador.getTabla().getContadorDePuntos()+35);
        }
    }
     
    }
}
