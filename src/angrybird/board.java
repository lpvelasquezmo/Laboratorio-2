/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package angrybird;

import Modelo.imagen;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Path2D;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Maicol Velasquez
 */
public class board extends JPanel implements ActionListener, MouseListener, MouseMotionListener {

    // ArrayList <Point> lista = new ArrayList <Point>();
    private Path2D shape;
    private int inten = 0;
    private int puntos = 0;
    private Color color;
    private int pintar =0;
    boolean go = true;
    private int Px, Py;
    private int press;
    private Timer timer;
    private imagen pajaro;
    private imagen cerdo;
    private imagen cerdo2;

    private int VELOCIDAD;
    private int ANGULO;
    private double vx, vy;
    private double t;

    public board() {
        this.color = Color.RED;
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        initElementos();
        

        this.shape = new Path2D.Float();
        // this.shape.moveTo(70, 400);

        this.timer = new Timer(100, this);

        //Registrar evento del Teclado
        setFocusable(true); //Debe estar en modo Focus para que puede detectar el evento
        this.timer.start();
    }
    
    void initElementos() {
        this.color = Color.RED;
        this.Px = 150;
        this.Py = 408;
        vx = 0; vy = 0;
        t = 0;
        this.pajaro = new imagen(this.Px, this.Py);
        this.cerdo = new imagen(700, 500);
        this.cerdo2 = new imagen(850, 500);

        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (press == 4) {
            System.out.println("hola");

            vx = (VELOCIDAD - (VELOCIDAD - 8)) * Math.cos(Math.toRadians(ANGULO));
            System.out.println("and" + ANGULO);
            vy = (VELOCIDAD - (VELOCIDAD - 8)) * Math.sin(Math.toRadians(ANGULO)) - ((9.8 * 2) * t);

            this.pajaro.setX((int) (this.pajaro.getX() + vx * t));

            //this.pajaro.setX((int )(this.pajaro.getY()  +vx*t));
            this.pajaro.setY((int) (this.pajaro.getY() + -vy * t + (0.5 * (-9.8 * 3)) * t * t));

            t += 0.01;

        }
        repaint();
    }

    public int velocidad() {
        int vx = (this.pajaro.getX() - this.Px);
        int vy = (this.pajaro.getY() - this.Py);
        System.out.println("getvx  " + vx + "vy  " + vy);
//        int vx2 = Math.abs(this.Px + vx);
//        int vy2 = Math.abs(this.Py + vy);
        int aux = (int) Math.pow(vx, 2) + (int) Math.pow(vy, 2);
        aux = (int) Math.sqrt(aux);
        this.VELOCIDAD = aux;

        System.out.println("hip " + this.VELOCIDAD);
        return this.VELOCIDAD;

    }

    public int angulo() {
        int vx = (this.pajaro.getX() - this.Px);
        int vy = (this.pajaro.getY() - this.Py);
        int vx2 = Math.abs(this.Px + vx);
        int vy2 = Math.abs(this.Py + vy);
        double aux1 = vx2 / this.VELOCIDAD;
        if (this.pajaro.getX() < this.Px && this.pajaro.getY() < this.Py) {
            this.ANGULO = -(int) Math.toDegrees(Math.cos(aux1));
        } else {
            this.ANGULO = (int) Math.toDegrees(Math.cos(aux1));
        }

        System.out.println("an   " + this.ANGULO);
        return this.ANGULO;
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (this.color == Color.RED && new Rectangle(50, 50, 140, 51).contains(me.getPoint())) {
            this.color = Color.BLUE;
            this.press = 1;
        }
//        if (this.press==4 && new Rectangle(200, 300, 290, 301).contains(me.getPoint())){
//            System.out.println("entro2");
//            this.color = Color.RED;
//            System.exit(0);
//        }

        repaint();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D d = (Graphics2D) g;
        d.setColor(Color.BLACK);
        System.out.println("-------------->"+inten + "  "+ this.puntos);
        System.out.println("ini " + this.pajaro.getX() + " " + this.pajaro.getY());
        d.fillRect(0, 0, this.getWidth(), this.getHeight());
        Image fondo = loadImage("fondo1.png");
        g.drawImage(fondo, 0, 0, null);
       if (inten < 6) {
            System.out.println("fg");
           
            g.setColor(this.color);
            g.fillRect(50, 50, 140, 52);
            g.setColor(Color.BLACK);
            // g.drawOval(200, 500, 5, 5);

            g.drawString("Click:  lanzar " , 70, 75);
            g.drawString("Intento : " + this.inten + "   De: 5" , 70, 96);

            g.setColor(this.color);
            g.fillRect(800, 50, 100, 51);
            g.setColor(Color.BLACK);
            // g.drawOval(200, 500, 5, 5);

            g.drawString("Puntos " + this.puntos, 806, 80);
            if (press == 1) {

                this.press = 2;
            }

            if (this.press == 2) {
                Image imgP = loadImage("RedBird2.png");
                g.drawImage(imgP, pajaro.getX(), pajaro.getY(), this);

                Image imCer = loadImage("cerdo2.png");
               
                if (this.pintar !=1){
                    g.drawImage(imCer, cerdo.getX(), cerdo.getY(), this);
                }
                if (this.pintar !=2){
                    g.drawImage(imCer, cerdo2.getX(), cerdo2.getY(), this);
                }
                d.setColor(Color.yellow);
                d.draw(this.shape);
                System.out.println("ini " + this.pajaro.getX() + " " + this.pajaro.getY());

            }
            if (this.press == 3) {

                velocidad();
                angulo();

                this.press = 4;
            }

            if (this.press == 4) {

                Image imgP = loadImage("RedBird2.png");
                g.drawImage(imgP, pajaro.getX(), pajaro.getY(), this);

                if (this.pintar !=1){
                    Image imCer = loadImage("cerdo2.png");
                g.drawImage(imCer, cerdo.getX(), cerdo.getY(), this);
                }
                if (this.pintar !=2){
                     Image imCer = loadImage("cerdo2.png");
                Image imCer2 = loadImage("cerdo2.png");
                g.drawImage(imCer, cerdo2.getX(), cerdo2.getY(), this);
                }
                // press= 4;
            Rectangle paj = new Rectangle(this.pajaro.getX(), this.pajaro.getY(), 50, 47);
            Rectangle lim1 = new Rectangle (0, 0, 1000, 1);
            Rectangle lim2 = new Rectangle(0, 0, 1, 600);
            Rectangle lim3 = new Rectangle(998, 0,1000 , 600);
            Rectangle piso = new Rectangle (50, 530, 997, 538);
            
            
           if (this.pintar !=1){
            Rectangle cer = new Rectangle(this.cerdo.getX(), this.cerdo.getY(), 50, 47);
            if (paj.intersects(cer)) {
                g.setColor(Color.LIGHT_GRAY);
                initElementos();
                g.drawRect(cerdo.getX(), cerdo.getY(), 10, 10);
                g.fillRect(cerdo.getX(), cerdo.getY(), 10, 10);
                this.puntos += 1;
                inten++;
                press = 0;
                this.pintar=1;
                                }
           if (this.pintar !=2){
            Rectangle cer2 = new Rectangle(this.cerdo2.getX(), this.cerdo2.getY(), 50, 47);
            if (paj.intersects(cer2)) {
                g.setColor(Color.LIGHT_GRAY);
                initElementos();
                g.drawRect(cerdo.getX(), cerdo.getY(), 10, 10);
                g.fillRect(cerdo.getX(), cerdo.getY(), 10, 10);
                this.puntos += 1;
                inten++;
                this.pintar =2;
                press = 0;
            }
                                }
            
            
            }  if (paj.intersects(piso) || paj.intersects(lim1) || paj.intersects(lim2) || paj.intersects(lim3)) {
                initElementos();
                press = 0;
                inten++;
            }
            }
            if (inten ==5 || this.puntos ==2){

                g.setColor(this.color);
                g.fillRect(200, 300, 290, 301);
                
               // g.drawString("Volver a jugar" + this.puntos, 800, 100);
                g.setColor(Color.BLACK);
                g.drawString("Gracias por Jugar" + this.puntos, 210, 300);              
                System.exit(0);
//                
//                
//            
//            g.fillRect(300, 200,500 , 201);
//            g.setColor(Color.BLACK);
//            g.drawString("Salir del juego" + this.puntos, 360, 100);
            }
            // colision
            

        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
        Graphics g = this.getGraphics();

        if (this.go) {
            this.shape.moveTo(me.getX(), me.getY());
        }
//   g.drawRect(me.getX(), me.getY(), 5 , 5);
        //  lista.add(new Point (me.getX(), me.getY()));
        //   if (lista.size() >1){
        //      g.drawLine(lista.get(lista.size()-1).x, lista.get(lista.size()-1).y, lista.get(lista.size()-2).x, lista.get(lista.size()-2).y);
        //   }

    }
    
  
    @Override
    public  void mouseReleased(MouseEvent me) {
        if (press == 2) {
            press = 3;

        }

    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        if (press == 2) {
            this.pajaro.setX(me.getX());
            this.pajaro.setY(me.getY());
            if (this.go) {
                this.shape.lineTo(this.pajaro.getX(), this.pajaro.getY());

            }
        }
        repaint();

    }

    @Override
    public void mouseMoved(MouseEvent me) {
    }

    public Image loadImage(String imageName) {
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }

}
