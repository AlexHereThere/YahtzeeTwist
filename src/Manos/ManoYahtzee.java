/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Manos;

import Dados.Dado;

/**
 *
 * @author 01806
 */
public class ManoYahtzee extends Mano implements Manos {
    //constructor
    int valorDeYahtzeeEnEsteMomento=50;
    int vecesUsado=0;//controlamos si se puede usar o no yahtzee con este contador
    public ManoYahtzee()
    {    
    super();
    nombre="YAHTZEE";
    valor="50/100/100/100 PUNTOS";
    }
     /**
     * metodo para evaluar respecto a esta mano un conjunto de dados
     * @param dados
     * @return 
     */
    @Override
    public int Evaluar(Dado[] dados) {
    int numeroDeDadosConValorIgual=0;//contador para todos los dados que sean igual al valor del primer dado incuyendo el contado 
    // del dado con la cara tomada
   
        int ValorConQueRevisar=dados[0].getValorCaraMostrada();
        for(int i=0;i<dados.length-1;i++)//menos uno para no considerar el dado color que es el ultimo
        {
        if(dados[i].getValorCaraMostrada()==ValorConQueRevisar)numeroDeDadosConValorIgual++;
        }
        if(numeroDeDadosConValorIgual==5)
        {
            vecesUsado++;
            puntaje+=valorDeYahtzeeEnEsteMomento;
            valorDeYahtzeeEnEsteMomento=100;
           
            //si se logro un yahtzee, se puede usar otra vez pero con un valor de 100 puntos
        }
        else 
        {
            vecesUsado++;//es sumado para poder mostrarlo
            fueUsado=true;//si se exedio el numero de veces que se puede usar ya no se puede usar mas.
            //si no pudo lograr exitosamente un yahtzee ya no se puede crear despues
        }
        if(vecesUsado==4)fueUsado=true;//si ya se uso 3 veces ya no se puede usar
        puntaje+= regresarExtraPorColor(dados);
        return puntaje;
    
    }
    
    
    /**
     * metodo para el despliegue de la mano en tabla
     * @return 
     */
    @Override
    public String toStirng() {
    if(vecesUsado>0) return nombre+"                 | "+valor+"        |  "+puntaje;    
    else return nombre+"                 | "+valor+"        | "+" ";
    }
}
