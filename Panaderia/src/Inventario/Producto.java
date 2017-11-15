/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventario;

/**
 *
 * @author Familia Bastidas
 */
public class Producto extends Inventario {

    protected String nCliente;
    protected double porcProm;

    public Producto(String nCliente, double porcProm, String nombre, int cantidad, double precio) {
        super(nombre, precio, cantidad);
        this.nCliente = nCliente;
        this.porcProm = porcProm;
    }

    public double getPorcProm() {
        return porcProm;
    }

    public void setPorcProm(double porcProm) {
        this.porcProm = porcProm;
    }

    public String getnCliente() {
        return nCliente;
    }

    public void setnCliente(String nCliente) {
        this.nCliente = nCliente;
    }

    public Producto(String nombre, int cantidad, double precio) {
        super(nombre, precio, cantidad);
    }

    public void registrarVentas(String nombre, int cantidad, double precio) {
        int cPedido;
        double pTotal1;
        cPedido = 0;
        this.cantidad = this.cantidad - cPedido;
        pTotal1 = this.cantidad * precio;
    }

    public void registrarVentasPM(String nombre, int cantidad, double precio, String nCliente, double porcProm) {
        int cPedido;
        cPedido = 0;
        double pTotal;
        this.cantidad = this.cantidad - cPedido;
        pTotal = this.cantidad * precio - (porcProm * this.precio * cantidad);
    }

    public void cambiarPorc(String nombre, double porcProm) {
        if (nombre.equals(this.nombre)) {
            this.porcProm = porcProm;
        }
    }

    public void cambiarPrecio(String nombre, double precio) {
        if (this.nombre.equals(nombre)) {
            this.precio = precio;
        }
    }
    
}
