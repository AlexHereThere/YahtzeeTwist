/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Manos;

import Dados.Dado;

/**
 *clase para modelar todas las manos, con todo lo particular de manos
 * @author ACR
 */
public  abstract class Mano implements Manos {
    protected int puntaje=0;
    protected boolean fueUsado;
    protected String nombre;
    protected String valor;
    //constructor
    public Mano()
    {
    puntaje=0;
    fueUsado=false;    
    }
    
      //getters
    @Override
    public boolean getFueUsado() {
        return fueUsado;
    }
    
    public String getNombre()
    {
        return nombre;
    }
    
    public int getPuntaje()
    {
        return puntaje;
    }
    
    /**
     * metodo para considerar el extra que se obtiene si uno o varios 
     * de los dados mandados son el mismo color que el dado color
     * @param dados
     * @return 
     */
    @Override
    public int regresarExtraPorColor(Dado[] dados)
    {
        boolean hayColorComoDadoColor=false;
       for(int i=0;i<dados.length-1;i++)
       {
       if(dados[dados.length-1].getColor().equals(dados[i].getColor())) hayColorComoDadoColor=true; 
       }
       if(hayColorComoDadoColor)//si uno de los dados es el mismo color que dado color, agregar +4 al puntaje
       return 4;
       else return 0;
    }
    /**
     * metodo para evaluar los dados que se mandan
     * @param dados
     * @return 
     */
    @Override
    public abstract int Evaluar(Dado[] dados);
    /**
     * metodo para el despliegue de la mano en tabla
     * @return 
     */
    @Override
    public String toStirng() {
    if(fueUsado==true) return nombre+" | "+valor+" |  "+puntaje;    
    else return nombre+" | "+valor+" | "+" ";
    }
    
    
}
