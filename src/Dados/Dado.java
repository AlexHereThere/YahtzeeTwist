package Dados;

import UI.CanvasUI;
import java.awt.image.BufferedImage;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 * clase para modelar un dado en general, es abstracto para tener de diferentes
 * tipos
 *
 * @author ACR
 */
public abstract class Dado {

    protected boolean lanzable;
    protected final int NUMERODECARAS;
    protected int valorCaraMostrada, width, height, x, y;//cordenadas y tamano para saber como mostrarlo
    protected String color;
    protected BufferedImage imagenDado;
    protected BufferedImage imagenEstado;
    protected final String[] coloresDisponible;// para tener la seleccion de colores que se pueden usar

    //constructor
    public Dado(int NUMERODECARAS, int x, int y, int width, int height, String[] colores) {
        lanzable = true;
        this.NUMERODECARAS = NUMERODECARAS;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        coloresDisponible = colores;

    }

    //setters
    public void setValorCaraMostrada(int valorCaraMostrada) {
        this.valorCaraMostrada = valorCaraMostrada;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setColor(String color) {
        this.color = color;
    }

   
    
    public void setLanzable(boolean lanzable) {
        this.lanzable=lanzable;
    }

    abstract public void setImagenes();

    //getters
    public int getValorCaraMostrada() {
        return valorCaraMostrada;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getColor() {
        return color;
    }

    public BufferedImage getImageDado() {
        return imagenDado;
    }

    public BufferedImage getImageEstado() {
        return imagenEstado;
    }

    public boolean getLanzable() {
        return lanzable;
    }

    //otros metodos
    /**
     * metodo para lanzar el dado y asignar cuanto valdra,su color y imagen que
     * corresponde.
     */
    abstract public void lanzar();

    /**
     * metodo para el despliegue del mismo dado, en donde es agregado en el
     * canvas para ser dibujado.
     */
    abstract public void dibuja(CanvasUI canvas);
    /**
     * metodo para cambiar el estado de lanzable para los botones
     */
     public void cambiarLanzable() {
        lanzable = lanzable != true;
    }
}
