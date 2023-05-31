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
public class Mano4DeUnTipo extends Mano implements Manos {
    //constructor
    public Mano4DeUnTipo()
    {    
    super();
    nombre="4 DE UN TIPO";
    valor="ACUMULADO VALOR DE TODO DADO";
    }
    /**
     * metodo para evaluar respecto a esta mano un conjunto de dados
     * @param dados
     * @return 
     */
    @Override
    public int Evaluar(Dado[] dados) {
    int numeroDeRepetidosMax=0;
    int numeroDeRepetidosDeDado;
   
        for(int i=0;i<dados.length-1;i++)//menos uno para no considerar el dado color que es el ultimo
        {
        numeroDeRepetidosDeDado=0;//para contar todos los repetidos de este dado
            for(int j=0;j<dados.length-1;j++)
            {
            if(dados[i].getValorCaraMostrada()==dados[j].getValorCaraMostrada())numeroDeRepetidosDeDado++;//si se repite, +1     
            }
        if(numeroDeRepetidosDeDado>numeroDeRepetidosMax)numeroDeRepetidosMax=numeroDeRepetidosDeDado;//si se sobrepasa    
        //el numero maximo de un Dado Repetido por mas veces, ese numero de repeticiones ahora es el maximo
        }
        fueUsado=true;
        if(numeroDeRepetidosMax>=4)puntaje=PuntosMaxPorDados(dados);
        else puntaje=0;
        puntaje+= regresarExtraPorColor(dados);
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
    if(fueUsado==true) return nombre+"            | "+valor+" |  "+puntaje;    
    else return nombre+"            | "+valor+" | "+" ";
    }
    
}

