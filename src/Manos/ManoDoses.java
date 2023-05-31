/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Manos;

import Dados.Dado;

/**
 *clase para modelar la mano de doses
 * @author ACR
 */
public class ManoDoses extends Mano implements Manos {
    //constructor
    public ManoDoses()
    {    
    super();
    nombre="DOSES/CUADROS";
    valor="DOS * NUMERO DE DOS";
    }
     /**
     * metodo para evaluar respecto a esta mano un conjunto de dados
     * @param dados
     * @return 
     */
    @Override
    public int Evaluar(Dado[] dados) {
    int numeroDeDoses=0;

    
        for(int i=0;i<dados.length-1;i++)//menos uno para no considerar el dado color que es el ultimo
        {
            if(dados[i].getValorCaraMostrada()==2)numeroDeDoses++;  
        }
        fueUsado=true;
        puntaje = numeroDeDoses*2;
        puntaje+= regresarExtraPorColor(dados);
        return puntaje;
   
    }
     /**
     * metodo para el despliegue de la mano en tabla
     * @return 
     */
    @Override
    public String toStirng() {
    if(fueUsado==true) return nombre+"           | "+valor+"          |  "+puntaje;    
    else return nombre+"           | "+valor+"          |  "+" ";
    }
}

