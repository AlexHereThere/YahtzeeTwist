/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Manos;

import Dados.Dado;

/**
 *clase para modelar la Mano de pequeno derecho (valores escaloneados(1,2,3,4) secuencia de 4)
 * @author ACR
 */
public class ManoPequeñoDerecho extends Mano implements Manos {
    //constructor
    public ManoPequeñoDerecho()
    {    
    super();
    nombre="PEQUENO DERECHO";
    valor="30 PUNTOS";
    }
     /**
     * metodo para evaluar respecto a esta mano un conjunto de dados
     * @param dados
     * @return 
     */
    @Override
    public int Evaluar(Dado[] dados) {
    boolean haySecuenciaDe1A4;
    boolean haySecuenciaDe2A5;
    boolean haySecuenciaDe3A6;
   
        haySecuenciaDe1A4=seEcontroSecuenciaDe1A4(dados);
        haySecuenciaDe2A5=seEcontroSecuenciaDe2A5(dados);
        haySecuenciaDe3A6=seEcontroSecuenciaDe3A6(dados);
        
        if(haySecuenciaDe1A4 || haySecuenciaDe2A5 || haySecuenciaDe3A6) puntaje = 30;
        else puntaje = 0;
        fueUsado=true;
        puntaje+= regresarExtraPorColor(dados);
        return puntaje;
 
    }
    /**
     * metodo para ver si existe una secuencia de 1 a 4
     * @param dados
     * @return 
     */
    private boolean seEcontroSecuenciaDe1A4(Dado[] dados)
    {
    boolean hay1=false;
    boolean hay2=false;
    boolean hay3=false;
    boolean hay4=false;
    for(int i=0;i<dados.length-1;i++)
    {
        if(dados[i].getValorCaraMostrada()==1)hay1=true;
        if(dados[i].getValorCaraMostrada()==2)hay2=true;
        if(dados[i].getValorCaraMostrada()==3)hay3=true;
        if(dados[i].getValorCaraMostrada()==4)hay4=true;
    }
    return hay1 && hay2 && hay3 && hay4;
    }
    /**
     * metodo para ver si existe una secuencia de 2 a 5
     * @param dados
     * @return 
     */
    private boolean seEcontroSecuenciaDe2A5(Dado[] dados)
    {
    boolean hay2=false;
    boolean hay3=false;
    boolean hay4=false;
    boolean hay5=false;
    for(int i=0;i<dados.length-1;i++)
    {
        if(dados[i].getValorCaraMostrada()==2)hay2=true;
        if(dados[i].getValorCaraMostrada()==3)hay3=true;
        if(dados[i].getValorCaraMostrada()==4)hay4=true;
        if(dados[i].getValorCaraMostrada()==5)hay5=true;
    }
    return hay2 && hay3 && hay4 && hay5;
    }
    
    /**
     * metodo para ver si existe una secuencia de 3 a 6
     * @param dados
     * @return 
     */
    private boolean seEcontroSecuenciaDe3A6(Dado[] dados)
    {
    boolean hay3=false;
    boolean hay4=false;
    boolean hay5=false;
    boolean hay6=false;
    for(int i=0;i<dados.length-1;i++)
    {
        if(dados[i].getValorCaraMostrada()==3)hay3=true;
        if(dados[i].getValorCaraMostrada()==4)hay4=true;
        if(dados[i].getValorCaraMostrada()==5)hay5=true;
        if(dados[i].getValorCaraMostrada()==5)hay5=true;
    }
    return hay3 && hay4 && hay5 && hay6;
    }
    
    /**
     * metodo para el despliegue de la mano en tabla
     * @return 
     */
    @Override
    public String toStirng() {
    if(fueUsado==true) return nombre+"         | "+valor+"                    |  "+puntaje;    
    else return nombre+"         | "+valor+"                    | "+" ";
    }
}
