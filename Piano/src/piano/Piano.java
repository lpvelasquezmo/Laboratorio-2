/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piano;


import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import static java.lang.System.exit;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Toolkit;

/**
 *
 * @author MARIAJOSE
 */
public class Piano {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame frame = new JFrame("Piano");
        // get and set icon for the program
        ImageIcon icon = new ImageIcon("Images/378-200.png");
        Jugada jugada = new Jugada(5, true, true);
        TimeOut timeout = new TimeOut();
        frame.setIconImage(icon.getImage());
        final JButton DO_KEY = new JButton("Do");
        final JButton RE_KEY = new JButton("Re");
        final JButton MI_KEY = new JButton("Mi");
        final JButton FA_KEY = new JButton("Fa");
        final JButton SOL_KEY = new JButton("Sol");
        final JButton LA_KEY = new JButton("La");
        final JButton SI_KEY = new JButton("Si");
        final JButton NEXT_KEY = new JButton("Siguiente");
        final JButton FINAL_KEY = new JButton ("Comparar") ;
        // Listener to play sounds on click
        ActionListener pianoSounds = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == DO_KEY) {
                    try {
                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("sounds/do.wav").getAbsoluteFile());
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioInputStream);
                        clip.start();
                        jugada.addJugada("do");
                    }catch(Exception x) { x.printStackTrace(); }
                }
                else if (e.getSource() == RE_KEY) {
                    try {
                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("Sounds/re.wav").getAbsoluteFile());
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioInputStream);
                        clip.start();
                        jugada.addJugada("re");
                    }catch(Exception x) { x.printStackTrace(); }
                }
                else if (e.getSource() == MI_KEY) {
                    try {
                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("Sounds/mi.wav").getAbsoluteFile());
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioInputStream);
                        clip.start();
                        jugada.addJugada("mi");
                    }catch(Exception x) { x.printStackTrace(); }
                }
                else if (e.getSource() == FA_KEY) {
                    try {
                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("Sounds/fa.wav").getAbsoluteFile());
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioInputStream);
                        clip.start();
                        jugada.addJugada("fa");
                    } catch(Exception x) { x.printStackTrace(); }
                } else if (e.getSource() == SOL_KEY) {
                    try {
                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("Sounds/sol.wav").getAbsoluteFile());
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioInputStream);
                        clip.start();
                        jugada.addJugada("sol");
                    } catch(Exception x) { x.printStackTrace(); }
                } else if (e.getSource() == LA_KEY) {
                    try {
                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("Sounds/la.wav").getAbsoluteFile());
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioInputStream);
                        clip.start();
                        jugada.addJugada("la");
                    } catch(Exception x) { x.printStackTrace(); }
                } else if (e.getSource() == SI_KEY) {
                    try {
                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("Sounds/si.wav").getAbsoluteFile());
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioInputStream);
                        clip.start();
                        jugada.addJugada("si");
                    } catch(Exception x) { x.printStackTrace(); }
                
                } else if (e.getSource() == NEXT_KEY){
                 jugada.setJugador(false);
                     System.out.println("hola jugador 2");
                      
                      timeout.start(0, 1000);
                      if(timeout.getSecond() == 0){
                          jugada.setVidas(jugada.restar());
                          jugada.getVidas();
                          timeout.setSecond(15);
                      }

                } else if (e.getSource() == FINAL_KEY) {
                    timeout.stop();
                    jugada.comparar(jugada.getJugador1(), jugada.getJugador2());
                    jugada.vida();
                    
                    if(jugada.comparar(jugada.getJugador1(), jugada.getJugador2())==  true){
                        System.out.println("siga");
                        jugada.setJugador(true);
                      
                    } else if (jugada.comparar(jugada.getJugador1(), jugada.getJugador2()) == false || jugada.isIsA() == true){
                        System.out.println("todavia hay chance");
                        System.out.println(jugada.getVidas());
                    } else if (jugada.comparar(jugada.getJugador1(), jugada.getJugador2())== false || jugada.isIsA() == false){
                        System.out.println("bye losser");
                        System.exit(0);
                }
                }
                }
            
        };
        // Register buttons to listener
        DO_KEY.addActionListener(pianoSounds);
        RE_KEY.addActionListener(pianoSounds);
        MI_KEY.addActionListener(pianoSounds);
        FA_KEY.addActionListener(pianoSounds);
        SOL_KEY.addActionListener(pianoSounds);
        LA_KEY.addActionListener(pianoSounds);
        SI_KEY.addActionListener(pianoSounds);
        NEXT_KEY.addActionListener(pianoSounds);
        FINAL_KEY.addActionListener(pianoSounds);
       
            
        // buttons to panel
        JPanel p = new JPanel();
         Image image = Toolkit.getDefaultToolkit().createImage("images/left.png");
        p.createImage((ImageProducer) image);
        p.add(DO_KEY);
        p.add(RE_KEY);
        p.add(MI_KEY);
        p.add(FA_KEY);
        p.add(SOL_KEY);
        p.add(LA_KEY);
        p.add(SI_KEY);
        p.add(NEXT_KEY);
        p.add(FINAL_KEY);
        // Panel to frame
        frame.add(p);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,1000);
        
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
       
    }
    }
    

