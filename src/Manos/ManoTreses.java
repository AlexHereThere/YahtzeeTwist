/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Manos;

import Dados.Dado;

/**
 *calse para la mano de treses
 * @author ACR
 */
public class ManoTreses extends Mano implements Manos {
    //constructor
    public ManoTreses()
    {    
    super();
    nombre="TRESES/RECTANGULOS";
    valor="TRES * NUMERO DE TRES";
    }
     /**
     * metodo para evaluar respecto a esta mano un conjunto de dados
     * @param dados
     * @return 
     */
    @Override
    public int Evaluar(Dado[] dados) {
    int numeroDeTreses=0;
   
        for(int i=0;i<dados.length-1;i++)//menos uno para no considerar el dado color que es el ultimo
        {
            if(dados[i].getValorCaraMostrada()==3)numeroDeTreses++;  
        }
        fueUsado=true;
        puntaje = numeroDeTreses*3;
        puntaje+= regresarExtraPorColor(dados);
        return puntaje;
    
    
    }
     /**
     * metodo para el despliegue de la mano en tabla
     * @return 
     */
    @Override
    public String toStirng() {
    if(fueUsado==true) return nombre+"      | "+valor+"        |  "+puntaje;    
    else return nombre+"      | "+valor+"        |  "+" ";
    }
}
