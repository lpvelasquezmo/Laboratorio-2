/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventario;

import java.util.ArrayList;

/**
 *
 * @author Familia Bastidas
 */
public class Inventario {

    protected String nombre;
    protected int cantidad;
    protected double precio;
    protected ArrayList<Inventario> tipos;

    public Inventario(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }


    @Override 
    public String toString(){ 
return ("Nombre: "+nombre+" Cantidad: "+cantidad+" Precio "+precio); 
}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(String nombre,double precio) {
        this.precio = precio;
    }

    public boolean anadir(String nombre, double precio, int cantidad) {
        Inventario tipo=new Inventario(this.nombre, this.precio, this.cantidad);

    return this.tipos.add(tipo);    
        //return this.tipos.add(tipo);

    }

    public boolean eliminar(String nombre,double precio, int cantidad) {
String nombre1;
nombre1="";
        if (nombre1.equals(nombre)) {
            tipos.remove(nombre+precio+cantidad);
           return true;
        } else {
            System.out.println("No existe este elemento en el inventario");
            return false;
        }

    }

public ArrayList<Inventario> mostrar(String nombre, double precio, int cantidad){
  System.out.println(tipos);
return tipos;
}
} 
