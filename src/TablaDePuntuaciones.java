
import Manos.Mano;
import Manos.Mano3DeUnTipo;
import Manos.Mano4DeUnTipo;
import Manos.ManoCasaLlena;
import Manos.ManoCincos;
import Manos.ManoCuatros;
import Manos.ManoDoses;
import Manos.ManoLargoDerecho;
import Manos.ManoOportunidad;
import Manos.ManoPequeñoDerecho;
import Manos.ManoSeises;
import Manos.ManoTreses;
import Manos.ManoUnos;
import Manos.ManoYahtzee;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *clase para modelar la tabla que tendra todas las manos disponibles del jugador y tomara 
 * registro de el puntaje acumulado por el jugador
 * @author ACR
 */
class TablaDePuntuaciones {
ArrayList<Mano> manosSeccionSuperior;
ArrayList<Mano> manosSeccionInferior;
int contadorDePuntos=0;
    //constructor
    public TablaDePuntuaciones()
    {
    manosSeccionSuperior=new ArrayList();
    manosSeccionSuperior.add(new ManoUnos());
    manosSeccionSuperior.add(new ManoDoses());
    manosSeccionSuperior.add(new ManoTreses());
    manosSeccionSuperior.add(new ManoCuatros()); 
    manosSeccionSuperior.add(new ManoCincos());
    manosSeccionSuperior.add(new ManoSeises());    
    manosSeccionInferior=new ArrayList();
    manosSeccionInferior.add(new Mano3DeUnTipo());
    manosSeccionInferior.add(new Mano4DeUnTipo());
    manosSeccionInferior.add(new ManoCasaLlena());
    manosSeccionInferior.add(new ManoPequeñoDerecho());
    manosSeccionInferior.add(new ManoLargoDerecho());
    manosSeccionInferior.add(new ManoYahtzee());
    manosSeccionInferior.add(new ManoOportunidad());
    contadorDePuntos=0;
    }
    
    //getters
    public int getContadorDePuntos()
    {
        return contadorDePuntos;    
    }
    
    public ArrayList<Mano> getManosSuperior()
    {
        return manosSeccionSuperior;    
    }
    
    public ArrayList<Mano> getManosInferior()
    {
        return manosSeccionInferior;    
    }
    
    public ArrayList<Mano> getManos()//para regresar todas las manos
    {
    ArrayList<Mano> todos = new ArrayList();
    todos.addAll(manosSeccionSuperior);
    todos.addAll(manosSeccionInferior);
    return todos;
    }
    //setters
    public void setContadorDePuntos(int contadorDePuntos)
    {
    this.contadorDePuntos=contadorDePuntos;
    }
    
    /**
     * metodo para mostrar la tabla
     * @param numeroDeJugador 
     */
    public void mostrarTabla(int numeroDeJugador)
    {
        System.out.println("---------------------------Jugador "+numeroDeJugador+"--------------------------");
        System.out.println("SECCION SUPERIOR          VALOR                         PUNTAJE"); 
        
        for(Mano mano :manosSeccionSuperior)
        {
            System.out.println(mano.toStirng());    
        }
        System.out.println("SECCION INFERIOR          VALOR                         PUNTAJE");
        for(Mano mano:manosSeccionInferior) 
        {
            System.out.println(mano.toStirng());    
        }
        System.out.println("TOTAL                    ---------->                      "+contadorDePuntos);
    }
    
   
}
