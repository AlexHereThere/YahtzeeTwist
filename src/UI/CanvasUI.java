package UI;

import Dados.Dado;
import java.awt.Canvas;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 * clase para modelar la ventana y canvas del juego, donde se le agrega
 * elementos y se despliegan
 *
 * @author ACR
 */
public class CanvasUI extends Canvas {

    ArrayList<Dado> elementosDado;//elementos tipo dado para despliegue
    Frame ventana;

//constructor
    public CanvasUI(String nombre) {
        ventana = new Frame(nombre);
        ventana.setSize(450, 500);
        elementosDado = new ArrayList<>();
    }

    public Frame getFrame() {
        return ventana;
    }

    /**
     * metodo para agregar un elemento tipo dado para su despliegue
     *
     * @param dadoConImg
     */
    public void agregarDado(Dado dadoConImg) {
        CanvasUI paraCambiar = this;
        elementosDado.add(dadoConImg);
        this.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                Rectangle hitbox = new Rectangle(dadoConImg.getX(), dadoConImg.getY(),
                        dadoConImg.getWidth(), dadoConImg.getHeight());
                if (hitbox.contains(e.getPoint())) {
                    dadoConImg.cambiarLanzable();
                    dadoConImg.setImagenes();
                }
                paraCambiar.repaint();
            }
        });
        
    }
    
    
    /**
     * metodo para hacer el frame visible
     */
    public void hacerVisible() {
        ventana.add(this);//cada vez que se usa se manda a frame
        ventana.setVisible(true);
    }


    /**
     * metodo para hacer el frame inbvisible
     */
    public void hacerInvisible() {
        ventana.remove(this);
        ventana.setVisible(false);
    }

    /**
     * para dibujar todos los elementos
     *
     * @param g
     */
    @Override
    public void paint(Graphics g) {

        for (Dado dadoConImg : elementosDado) {
            g.drawImage(dadoConImg.getImageDado(), dadoConImg.getX(), dadoConImg.getY(),
                    dadoConImg.getWidth(), dadoConImg.getHeight(), this);
            g.drawImage(dadoConImg.getImageEstado(), dadoConImg.getX() - 25, dadoConImg.getY(),
                    30, 60, this);
        }

    }
}
