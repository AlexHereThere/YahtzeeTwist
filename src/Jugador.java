
import Dados.Dado;
import Dados.DadoColor;
import Dados.DadoFigura;
import Dados.DadoNumerico;
import Manos.Mano;
import UI.CanvasUI;
import java.awt.event.ActionEvent;
import java.util.Scanner;
import javax.swing.JButton;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 * clase para modelar el jugador de yahtzee con 6 dados (5 normales y 1 de
 * color)
 *
 * @author ACR
 */
class Jugador {
    private int numeroDeJugador=0;
    final private int numeroDeDados = 6;
    private boolean  siguio=false;
    private int lanzamientosPosibles=0;
    final private Dado[] misDados = new Dado[numeroDeDados];
    private TablaDePuntuaciones miTabla;
    private CanvasUI canvas;

    //constructores
    public Jugador(String[] colores,int numeroDeJugador) {
        
        miTabla= new TablaDePuntuaciones();
        this.numeroDeJugador=numeroDeJugador;
        canvas = new CanvasUI("Jugador "+numeroDeJugador);
        int xPosicion = 100;
        int yPosicion = 100;
        int contadorParaBrinco = 0;
        for (int i = 0; i < misDados.length - 1; i++)//menos uno para hacer y acodomar los dados normales y el ultimo hacerlo de color
        {
            misDados[i] = new DadoNumerico(6, xPosicion, yPosicion, 60, 60, colores);
            contadorParaBrinco += 1;
            xPosicion += 100;
            if (contadorParaBrinco == 3) {
                xPosicion = 150;
                yPosicion += 100;
            }
        }
        xPosicion = 200;//posicion para el ultimo dado
        yPosicion = 300;
        misDados[misDados.length - 1] = new DadoColor(7, xPosicion, yPosicion, 60, 60, colores);
        CrearCanvasDeJugador();
    }
    
    //segun los parametros dados determinara que tipo de dado tendra...
    public Jugador(String[] colores, String[] figuras, int numeroDeJugador) {
        canvas = new CanvasUI("Jugador "+numeroDeJugador);
        miTabla= new TablaDePuntuaciones();
        this.numeroDeJugador=numeroDeJugador;
        int xPosicion = 100;
        int yPosicion = 100;
        int contadorParaBrinco = 0;
        for (int i = 0; i < misDados.length - 1; i++)//menos uno para hacer y acodomar los dados normales y el ultimo hacerlo de color
        {
            misDados[i] = new DadoFigura(6, xPosicion, yPosicion, 60, 60, colores, figuras);
            contadorParaBrinco += 1;
            xPosicion += 100;
            if (contadorParaBrinco == 3) {
                xPosicion = 150;
                yPosicion += 100;
            }
        }
        xPosicion = 200;//posicion para el ultimo dado
        yPosicion = 300;
        misDados[misDados.length - 1] = new DadoColor(7, xPosicion, yPosicion, 60, 60, colores);
        CrearCanvasDeJugador();
    }

     //getters
    public int getNumeroDeJugador()
    {
    return numeroDeJugador;    
    }
    
    public boolean getSiguio()
    {
    return siguio;
    }
    
    public TablaDePuntuaciones getTabla()
    {
    return miTabla;    
    }
    public int getLanzamientosPosibles()
    {
    return lanzamientosPosibles;  
    }
    public Dado[] getDados()
    {
    return misDados;    
    }
    //setters
    public void darLanzamientos(int lanzamientosPosibles)
    {
    this.lanzamientosPosibles=lanzamientosPosibles;   
    }
    
    public void setSiguio(boolean siguio)
    {
    this.siguio=siguio;    
    }
    /**
     * metodo para mostrar los dados del jugador
     *
     * @param canvas
     */
    private void mandarDadosACanvas() {
        for (Dado dado : misDados) {
            dado.dibuja(canvas);
        }
    }
    /**
     * metodo para crear el boton que lanzara sus dados
     * @param canvas 
     */
    private void hacerBottonLanzar() {
        JButton botonLanzar = new JButton("Lanzar");
        botonLanzar.setLocation(100, 425);
        botonLanzar.setSize(100, 30);
        botonLanzar.addActionListener((ActionEvent e) -> {
            if(lanzamientosPosibles > 0)
            {
                lanzamientosPosibles--;
                lanzarDados();
                canvas.repaint();
                System.out.println("Lanzamientos Disponibles: "+lanzamientosPosibles);
            }
        });
        canvas.getFrame().add(botonLanzar);
    }
    
    /**
     * metodo para crear un boton que senala cuando seguir al programa
     * @param canvas 
     */
    private void hacerBottonSeguir()
    {
         JButton botonSeguir = new JButton("Seguir");
        botonSeguir.setLocation(250, 425);
        botonSeguir.setSize(100, 30);
        botonSeguir.addActionListener((ActionEvent e) -> {
            if(lanzamientosPosibles == 0)
            {
                siguio = siguio != true;
            }// cuando ya se hizo todos los lanzamientosPosibles puede seguir
        });
        canvas.getFrame().add(botonSeguir);    
    }

    /**
     * metodo para llevar todos los elementos de un jugador al canvas
     * @param canvas 
     */
    private void CrearCanvasDeJugador()
    {
    mandarDadosACanvas();
    hacerBottonLanzar();
    hacerBottonSeguir();
    
    }
    /**
     * metodo para ensenar su Frame y Canvas
     */
    public void MostrarCanvasDeJugador()
    {
    hacerDadosLanzable();    
    lanzarDados();    //cada vez que se muestran los dados deben ser otro valor para no ser abusado
    canvas.hacerVisible();
    }
    /**
     * metodo para cerrrar su Frame y Canvas
     */
    public void EsconderCanvasDeJugador()
    {
    canvas.hacerInvisible();
    }
    
    
    /**
     * metodo para lanzar los dados del jugador
     */
    public void lanzarDados() {
        for (Dado dado : misDados) {
            dado.lanzar();
        }
    }
    
    /**
     * metodo para hacer dados de jugador lanzables
     */
    private void hacerDadosLanzable()
    {
        for(Dado dado :misDados)
        {
        dado.setLanzable(true);
        }
    }
    
   /**
    * saca el valor maximo de puntos por la suma de las caraMostradas de los dados
    * @return 
    */     
   public int puntosMaxEntreDados()
   {
   int sumador=0;
   for(Dado dado:misDados)
   {
   sumador+=dado.getValorCaraMostrada();
   }
   return sumador;
   }
   
   /**
    * metodo para determinar si ya uso todas sus manos el jugador
    */
   public boolean TodasManosUsadas()
   {
    int numeroDeManosUsadas=0;
    for(Mano mano: miTabla.getManos())
    {
    if(mano.getFueUsado()==true) numeroDeManosUsadas++;
    }
    return numeroDeManosUsadas==miTabla.getManos().size();
   }
   
   /**
    * metodo para evaluar los dados con una mano de miTabla
    */
   public void evaluarDadosConMano()
   {
     int indexManoUsar;
        Scanner sc = new Scanner(System.in);
        System.out.println("A CUAL MANO MANDAS DADOS?");
        for(int i=0;i< miTabla.getManos().size();i++)
        {
            System.out.println(i+" -- "+miTabla.getManos().get(i).getNombre());   
        }
        do{
            indexManoUsar = sc.nextInt();
            if(indexManoUsar<0 || indexManoUsar>=miTabla.getManos().size() ||//si la mano ya fue usado o no existe da error
            miTabla.getManos().get(indexManoUsar).getFueUsado()==true)
            System.out.println("ERROR:NO EXISTE ESE MANO O YA FUE USADO");
            
        }while(indexManoUsar<0 || indexManoUsar>=miTabla.getManos().size()||
            miTabla.getManos().get(indexManoUsar).getFueUsado()==true);//se repite hasta que se cumpla las condiciones
        
        miTabla.setContadorDePuntos(
         miTabla.getContadorDePuntos()+miTabla.getManos().get(indexManoUsar).Evaluar(misDados));
   }
}

