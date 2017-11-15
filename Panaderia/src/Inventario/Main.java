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
        // TODO code application logic here
/*import javax.swing.JOptionPane;
public class PruebaApp {

    public static void main(String[] args) {

        String nombre=JOptionPane.showInputDialog("Introduce tu nombre");

        JOptionPane.showMessageDialog(null, "Bien, tu nombre es "+nombre);
    }*/

//} String nombre=JOptionPane.showInputDialog("Introduce tu nombre");

ArrayList<String> tipos = new ArrayList<String>();
//tipos.add("1");
//tipos.add("2");//        System.out.println("Ingrese el nombre del Producto");
//        String nombre = hola.next();
//        System.out.println("Ingrese el tipo de producto ( supermercado, papeleria o drogueria):");
//        String tipo = hola.next();
//        System.out.println("Cantidad a la venta y en bodega");
//        int disponible = hola.nextInt();
//        System.out.println("Minima cantidad del producto para prodecder a generar nuevo pedido");
//        int min = hola.nextInt();
//        System.out.println("Precio por unidad sin iva:");
//        double precio = hola.nextInt();
//        PrecioF = tienda.PrecioFijo(precio, tipo);
//        boolean  resultado = tienda.AgregarPro(nombre, tipo, disponible, precio, min, PrecioF);
//        if(resultado == true){
//            System.out.println("Se creo el producto satisfactoriamente");
//        }else{
//            System.out.println("Error al agregar producto");
//        }
        Scanner f = new Scanner(System.in);
        Scanner g = new Scanner(System.in);
        Scanner h = new Scanner(System.in);
        Scanner i = new Scanner(System.in);
        int continuar = 1, opcion = 0;
   

        do {
            System.out.println("1.Mostrar los registros");
            System.out.println("2. Registrar un producto");
            System.out.println("3. Eliminar un producto o material");
            System.out.println("4.Registrar compras");
            System.out.println("5. Cambiar datos de un producto o material");//revisar ome!

            opcion = f.nextInt();
            String nombre;
            double precio;
            int cantidad;
            nombre = "";
            precio = 0.0;
            cantidad = 0;

            switch (opcion) {
 
                case 1:
                    System.out.println(tipos);
                    new Inventario(nombre,precio,cantidad).toString();
                    break;
                case 2:

                    System.out.println("Ingrese el nombre del producto a registrar:");
                    String nombrex = f.next();
                    System.out.println("Ingrese el precio unitario del producto:");
                    double preciox = g.nextInt();
                    System.out.println("Ingrese la cantidad de unidades existentes:");
                    int cantidadx = h.nextInt();

                    do {
                       
                        tipos.add(nombrex + " " + cantidadx + " " + preciox+"\n");
                        
                    } while (opcion == 1);
                    break;
                case 3:
                    System.out.println("Ingrese el nombre del producto que desea eliminar:");
                    String nombre1;
                    nombre1 = f.next();
new Inventario(nombre,precio,cantidad).eliminar(nombre1,precio,cantidad);

                    break;
                case 4:
                case 5:
                    System.out.println("");
                case 6:
                    System.out.println("Presione 1 si es un producto y 2 si es un material");
                    opcion = f.nextInt();
                    if (opcion == 1) {
                        System.out.println("presione 1 para cambiar la cantidad, 2 para cambiar precio y 3 para cambiar el porcentaje de la promocion");
                        opcion = f.nextInt();
                        switch (opcion) {
                            case 1:
                                    
                            case 2:

                            case 3:
                        }

                    } else if (opcion == 2) {

                    }
                    System.out.println("Igrese el porcentaje de promoción por el que desea cambiar");
                    double porcProm = g.nextDouble();
                    nombre = f.next();
                    precio = 0;
                    cantidad = 0;
                    String nCliente = "";
                    new Producto(nCliente, porcProm, nombre, cantidad, precio).cambiarPorc(nombre, porcProm);
                    break;

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
