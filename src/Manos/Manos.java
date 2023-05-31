/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Manos;

import Dados.Dado;

/**
 *Interface para considerar los metodos especiales de las manos
 * @author ACR
 */
public interface Manos {
    int Evaluar(Dado[] dados);
    int regresarExtraPorColor(Dado[] dados);
    boolean getFueUsado();
    String toStirng();
}
