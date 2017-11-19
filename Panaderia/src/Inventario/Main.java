/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventario;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Familia Bastidas
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ArrayList<String> tipos = new ArrayList<String>();

        Scanner f = new Scanner(System.in);
        Scanner g = new Scanner(System.in);
        Scanner h = new Scanner(System.in);
        Scanner i = new Scanner(System.in);
        int continuar = 1, opcion = 0;

        do {
            System.out.println("1.Mostrar los registros");
            System.out.println("2. Registrar un producto o material");
            System.out.println("3. Eliminar un producto o material");
            System.out.println("4.Registrar ventas");
            System.out.println("5.Registrar compras de material");
            System.out.println("6.Registrar gasto de material");
            System.out.println("7. Cambiar precio");

            opcion = f.nextInt();
            String nombre;
            double precio;
            int cantidad;
            nombre = "";
            precio = 0.0;
            cantidad = 0;
            int cPed;
            cPed = 0;
            String nCliente;
            double porcProm;
            int cGas;
            String nombre1;
            switch (opcion) {

                case 1:
                    System.out.println(tipos);
                    new Inventario(nombre, precio, cantidad).toString();
                    break;
                case 2:

                    System.out.println("Ingrese el nombre del producto a registrar:");
                    String nombrex = f.next();
                    System.out.println("Ingrese el precio unitario del producto:");
                    double preciox = g.nextInt();
                    System.out.println("Ingrese la cantidad de unidades existentes:");
                    int cantidadx = h.nextInt();

                    do {

                        tipos.add(nombrex + " " + cantidadx + " " + preciox + "\n");

                    } while (opcion == 2);
                    break;
                case 3:
                    System.out.println("Ingrese el nombre del producto que desea eliminar:");
                    
                    nombre1 = f.next();
                    new Inventario(nombre, precio, cantidad).eliminar(nombre1, precio, cantidad);

                    break;
                case 4:
                    System.out.println("presione: 1 para compras corrientes"
                            + "2 para compras al  por mayor");
                    int caso;
                    caso = f.nextInt();
                    switch (caso) {
                        case 1:
                            System.out.println("Ingrese el nombre del producto vendido");
                            nombre = f.next();
                            System.out.println("Ingrese la cantidad vendida");
                            cantidad = f.nextInt();
                            System.out.println("Ingrese el precio unitario");
                            precio = f.nextDouble();
                            new Producto(nombre, cantidad, precio).registrarVentas(nombre, cantidad, precio);
                        case 2:
                            System.out.println("Ingrese el nombre del producto vendido");
                            nombre = f.next();
                            System.out.println("Ingrese la el precio unitario");
                            precio = f.nextDouble();
                            System.out.println("Ingrese la cantidad vendida");
                            cantidad = f.nextInt();
                            System.out.println("Ingrese el nombre del cliente");
                            nCliente = f.next();
                            System.out.println("Ingrese la promoción actual del producto, si no hay promoción ponga 0");
                            porcProm = f.nextInt();
                            new Producto(nCliente, porcProm, nombre, cantidad, precio).registrarVentasPM(nombre, cantidad, precio, nCliente, porcProm);
                    }
                case 5:
            System.out.println("Ingrese el nombre del producto vendido");
                            nombre = f.next();
                            System.out.println("Ingrese el precio unitario");
                            precio = f.nextDouble();
                            System.out.println("Ingrese la cantidad comprada");
                            cantidad = f.nextInt();
                            new Materia(nombre,cantidad,precio).registrarCompras(nombre,cantidad,precio);
                case 6:

                    System.out.println("Ingrese el nombre del material");
                    nombre = f.next();
                    System.out.println("Ingrese la cantidad gastada de " + nombre);
                    cGas = f.nextInt();
                    new Materia(nombre, cantidad, precio).registrarGastados(nombre, cGas);

                case 7:
                  System.out.println("Ingrese el nombre del producto o material");
                  nombre1=f.next();
                  System.out.println("Ingrese el nuevo precio");
            double precio1 = f.nextDouble();
                  if (nombre1.equals(nombre)){
                  new Inventario(nombre,precio,cantidad).setPrecio(nombre1,precio1);
                  }
            }

        } while (continuar == 1);

        //*
        System.out.println();
        File inventario = new File("directorio.txt");
        File productos = new File("productos.txt");
        File materia = new File("materia.txt");
        File ganancias = new File("ganancias.txt");
        if (inventario.exists() && productos.exists() && ganancias.exists()) {
            String archivos[] = inventario.list();
            for (String archivo : archivos) {
                System.out.println(archivo);

            }
            System.out.println(inventario.getAbsolutePath());
        } else {
            try {
                inventario.createNewFile();
                productos.createNewFile();
                materia.createNewFile();
                ganancias.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
    }

}
