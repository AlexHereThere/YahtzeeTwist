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
public class ManoLargoDerecho extends Mano implements Manos {
    //constructor
    public ManoLargoDerecho()
    {    
    super();
    nombre="LARGO DERECHO";
    valor="40 PUNTOS";
    }
     /**
     * metodo para evaluar respecto a esta mano un conjunto de dados
     * @param dados
     * @return 
     */
    @Override
    public int Evaluar(Dado[] dados) {
    boolean haySecuenciaDe1A5;
    boolean haySecuenciaDe2A6;
   
  
        haySecuenciaDe1A5=seEcontroSecuenciaDe1A5(dados);
        haySecuenciaDe2A6=seEcontroSecuenciaDe2A6(dados);
        
        if(haySecuenciaDe1A5 || haySecuenciaDe2A6) puntaje = 40;
        else puntaje = 0;
        fueUsado=true;
        puntaje+= regresarExtraPorColor(dados);
        return puntaje;
 
    }
    /**
     * metodo para ver si existe una secuencia de 1 a 5
     * @param dados
     * @return 
     */
    private boolean seEcontroSecuenciaDe1A5(Dado[] dados)
    {
    boolean hay1=false;
    boolean hay2=false;
    boolean hay3=false;
    boolean hay4=false;
    boolean hay5=false;
    for(int i=0;i<dados.length-1;i++)
    {
        if(dados[i].getValorCaraMostrada()==1)hay1=true;
        if(dados[i].getValorCaraMostrada()==2)hay2=true;
        if(dados[i].getValorCaraMostrada()==3)hay3=true;
        if(dados[i].getValorCaraMostrada()==4)hay4=true;
        if(dados[i].getValorCaraMostrada()==5)hay5=true;
    }
    return hay1 && hay2 && hay3 && hay4 && hay5;
    }
    /**
     * metodo para ver si existe una secuencia de 2 a 5
     * @param dados
     * @return 
     */
    private boolean seEcontroSecuenciaDe2A6(Dado[] dados)
    {
    boolean hay2=false;
    boolean hay3=false;
    boolean hay4=false;
    boolean hay5=false;
    boolean hay6=false;
    for(int i=0;i<dados.length-1;i++)
    {
        if(dados[i].getValorCaraMostrada()==2)hay2=true;
        if(dados[i].getValorCaraMostrada()==3)hay3=true;
        if(dados[i].getValorCaraMostrada()==4)hay4=true;
        if(dados[i].getValorCaraMostrada()==5)hay5=true;
        if(dados[i].getValorCaraMostrada()==6)hay6=true;
    }
    return hay2 && hay3 && hay4 && hay5 && hay6;
    }
     /**
     * metodo para el despliegue de la mano en tabla
     * @return 
     */
    @Override
    public String toStirng() {
    if(fueUsado==true) return nombre+"           | "+valor+"                    |  "+puntaje;    
    else return nombre+"           | "+valor+"                    | "+" ";
    }
    
}