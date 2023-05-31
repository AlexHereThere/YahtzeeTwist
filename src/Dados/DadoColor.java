/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dados;

import UI.CanvasUI;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;

/**
 *clase para modelar un dado de color, este muestra un esfera y solo cambia de color
 * @author ACR
 */
public final class DadoColor extends Dado {
    //constructor
    public DadoColor(int NUMERODECARAS, int x, int y, int width, int height, String[] colores) {
        super(NUMERODECARAS, x, y, width, height, colores);
        lanzar();//lanzar al crear para definir su primer valor y color.
    }

    //setters
    @Override
    public void setValorCaraMostrada(int valorCaraMostrada) {
        this.valorCaraMostrada = valorCaraMostrada;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void setImagenes() {
        try {
            imagenDado = ImageIO.read(new File("Imagenes/" + color + "/ovalo.png"));// para sacar la imagen correcta
            if (lanzable == true) {
                imagenEstado = ImageIO.read(new File("Imagenes/CandadoA.jpg"));
            } else {
                imagenEstado = ImageIO.read(new File("Imagenes/CandadoC.jpg"));
            }
        } catch (IOException ex) {//depende de si es lanzable o no su imagen
            ex.printStackTrace();
        }
    }

    @Override
    public void cambiarLanzable() {
        lanzable = lanzable != true;
    }

    //getters
    @Override
    public int getValorCaraMostrada() {
        return valorCaraMostrada;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public BufferedImage getImageDado() {
        return imagenDado;
    }

    @Override
    public BufferedImage getImageEstado() {
        return imagenEstado;
    }

    @Override
    public boolean getLanzable() {
        return lanzable;
    }

    /**
     * metodo para lanzar el dado y asignar cuanto valdra,su color y imagen que
     * corresponde.
     */
    @Override
    public void lanzar() {
        if (lanzable == true) {//si se puede lanzar el dado se lanzara, de lo opuesto no.
            Random rmd = new Random();
            valorCaraMostrada = rmd.nextInt(NUMERODECARAS) + 1;
            color = coloresDisponible[valorCaraMostrada - 1];
            setImagenes();
        }
    }

    /**
     * metodo para el despliegue del mismo dado, en donde es agregado en el
     * canvas para ser dibujado.
     *
     * @param canvas
     */
    @Override
    public void dibuja(CanvasUI canvas) {
        canvas.agregarDado(this);
    }

}
