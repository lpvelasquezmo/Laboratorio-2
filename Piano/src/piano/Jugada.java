/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piano;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author MARIAJOSE
 */
public class Jugada {

    private boolean jugador;
    private ArrayList<String> jugador1;
    private ArrayList<String> jugador2;
    private int vidas;
    private boolean isA;
    
    public Jugada( int vidas, boolean jugador, boolean isA) {
        this.jugador1 = new ArrayList<>();
        this.jugador2 = new ArrayList<>();
        this.vidas = vidas;
        this.jugador= jugador;
        this.isA = isA;
    }

    public boolean isJugador() {
        return jugador;
    }

    public void setJugador(boolean jugador) {
        this.jugador = jugador;
    }

    public boolean isIsA() {
        return isA;
    }

    public void setIsA(boolean isA) {
        this.isA = isA;
    }
    
    public ArrayList<String> getJugador1() {
        return jugador1;
    }

    public ArrayList<String> getJugador2() {
        return jugador2;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }
    
   
    public void vida(){
        if (this.vidas > 0){
        this.isA = true;
    } else if (this.vidas <= 0) {
            this.isA = false;
            
        }
        
    }
    public int restar(){
        --this.vidas ;
        return this.vidas;
    }
    
    public void addJugada(String j){
        if (jugador == true){
        this.jugador1.add(j);
        
    } else if (jugador == false) {
    
        this.jugador2.add(j);
    
    }
    }
    
        public void limpiar(){
        this.jugador2.clear();
    }
    
    
    public  boolean comparar(ArrayList<String> a, ArrayList<String> b){    
       // comprobar que tienen el mismo tamaño y que no son nulos
    if ((a.size() != b.size()) || (a == null && b!= null) || (a != null && b== null)){
    --this.vidas ;
        this.jugador2.clear();
        return false;
   
   }

    if (a == null && b == null) {
        this.jugador1.clear();
        this.jugador2.clear();
        return true;
    }
        
    // ordenar las ArrayList y comprobar que son iguales          
    Collections.sort(a);
    Collections.sort(b);      
    return a.equals(b);
}
}
