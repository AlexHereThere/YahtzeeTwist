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
public class ManoOportunidad extends Mano implements Manos {
    //constructor
    public ManoOportunidad()
    {    
    super();
    nombre="OPORTUNIDAD";
    valor="ACUMULADO VALOR DE TODO DADO";
    }
    /**
     * metodo para evaluar respecto a esta mano un conjunto de dados
     * @param dados
     * @return 
     */
    @Override
    public int Evaluar(Dado[] dados) {
   
        fueUsado=true;
        puntaje+=PuntosMaxPorDados(dados);
        puntaje+=regresarExtraPorColor(dados);
        return puntaje;

    }
    
    private int PuntosMaxPorDados(Dado[] dados)
    {
        int total=0;
        for(int i=0;i<dados.length-1;i++)  
        {
        total+=dados[i].getValorCaraMostrada();
        }
        return total;
    }
     /**
     * metodo para el despliegue de la mano en tabla
     * @return 
     */
    @Override
    public String toStirng() {
    if(fueUsado==true) return nombre+"             | "+valor+" |  "+puntaje;    
    else return nombre+"             | "+valor+" |  "+" ";
    }
    
}

