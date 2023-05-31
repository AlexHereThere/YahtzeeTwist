/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Manos;

import Dados.Dado;

/**
 *clase para modelar la mano de casa llena (3 de un tipo con 2 de otro tipo)
 * @author ACR
 */
public class ManoCasaLlena extends Mano implements Manos {
    
    int numeroRepetido3Veces;
    //constructor
    public ManoCasaLlena()
    {    
    super();
    nombre="CASA LLENA";
    valor="25 PUNTOS";
    }
     /**
     * metodo para evaluar respecto a esta mano un conjunto de dados
     * @param dados
     * @return 
     */
    @Override
    public int Evaluar(Dado[] dados) {
    boolean hayDadoQueSeRepite3Veces=false;
    boolean hayOtroDadoQueSeRepite2Veces=false;
    
  
        if(sacarYVerDadoQueSeRepite3Veces(dados))hayDadoQueSeRepite3Veces=true;
        if(VerSiHayOtroDadoQueSeRepite2Veces(dados))hayOtroDadoQueSeRepite2Veces=true;
        
        if(hayDadoQueSeRepite3Veces==true && hayOtroDadoQueSeRepite2Veces==true)puntaje=25;    
        else puntaje=0;
        
        fueUsado=true;
        puntaje+= regresarExtraPorColor(dados);
        return puntaje;
 
    }
    
    private boolean sacarYVerDadoQueSeRepite3Veces(Dado[] dados)
    {
    int numeroDeRepetidosDeDado;  
      for(int i=0;i<dados.length-1;i++)//menos uno para no considerar el dado color que es el ultimo
        {
        numeroDeRepetidosDeDado=0;//para contar todos los repetidos de este dado
            for(int j=0;j<dados.length-1;j++)
            {
                if(dados[i].getValorCaraMostrada()==dados[j].getValorCaraMostrada())numeroDeRepetidosDeDado++;//si se repite, +1     
            }
            if(numeroDeRepetidosDeDado==3)
            {
                numeroRepetido3Veces=dados[i].getValorCaraMostrada();
                return true;
            }//si se repite 3 veces este dado,guardar el valor de la cara mostrada de dicho dado y verifica que existe.     
        }
    return false;//si no encontro regresa falso
    }
    
    private boolean VerSiHayOtroDadoQueSeRepite2Veces(Dado[] dados)
    {
        int numeroNoRepetido3Veces=0;//no puede haber dado con valor 0 (en esta version)
       // ahora se sacara si los otros 2 dados que quedaron son lo mismo
        for(int i=0;i<dados.length-1;i++)
        {
            if(dados[i].getValorCaraMostrada()!=numeroRepetido3Veces)numeroNoRepetido3Veces=dados[i].getValorCaraMostrada();
        }
        //ya sacamos el valor de uno de los otros dados que no es parte del numero repetido 3 veces
        //por medio de un contador veremos si hay 2 dados con el valor del numeroNoRepetido3veces
        //con esto veremos si hay casa llena
        int contadorDeOtraCaraRepetida=0;
        for(int i=0;i<dados.length-1;i++)
        {
            if(dados[i].getValorCaraMostrada()==numeroNoRepetido3Veces)contadorDeOtraCaraRepetida++;
        } 
        //dependiendo si hay 2 dados con la cara del dado que no se repite 2 veces regresa verdadero o falso
        return contadorDeOtraCaraRepetida==2;
    }
    
    /**
     * metodo para el despliegue de la mano en tabla
     * @return 
     */
    @Override
    public String toStirng() {
    if(fueUsado==true) return nombre+"              | "+valor+"                    |  "+puntaje;    
    else return nombre+"              | "+valor+"                    | "+" ";
    }
}
