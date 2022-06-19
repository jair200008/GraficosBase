/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 * AUTOR:EDWAR JAIR GAONA Y JUAN SEBASTIAN SUAREZ FECHA:2/11/2020 DESCRIBCION:
 * SE ENCARGA DE LOS VALORES QUE SE VAN A CARGAR EN LAS FACTURAS TXT
 *
 */
public class Facturas {

    //VARIABLES GLOBALES

    private int cliente;
    private String cargado;
    private int asientos;
    private int numeroMensajes;
    private String cargarTribunas;

    //METODO CONSTRUCTOR

    public Facturas() {
        asientos = 1;
        cliente = 1;
        numeroMensajes = 1;

    }

    //CARGA EN LA FACTURA LOS PRODUCTOS QUE EL USUARIO COMPRO Y DA SU TOTAL

    public String total(String ventas) {
        boolean ciclo = true;
        int valor = 0;
        cargado = "Cliente " + cliente + "\n";
        String productos;
        String articulo[] = ventas.split("/");

        while (ciclo) {

            for (int i = 0; i < articulo.length; i++) {
                productos = articulo[i];
                if (productos.equalsIgnoreCase("HAMBURGUESAS")) {
                    cargado = cargado + productos + " ---> " + 7500 + "\n";
                    valor = valor + 7500;
                } else if (productos.equalsIgnoreCase("PERROS")) {
                    cargado = cargado + productos + " ---> " + 5500 + "\n";
                    valor = valor + 5500;
                } else if (productos.equalsIgnoreCase("PAPAS")) {
                    cargado = cargado + productos + " ---> " + 4500 + "\n";
                    valor = valor + 4500;
                } else if (productos.equalsIgnoreCase("PAQUETES")) {
                    cargado = cargado + productos + " ---> " + 2500 + "\n";
                    valor = valor + 2500;
                } else if (productos.equalsIgnoreCase("GASEOSAS")) {
                    cargado = cargado + productos + " ---> " + 3500 + "\n";
                    valor = valor + 3500;
                } else if (productos.equalsIgnoreCase("AGUA")) {
                    cargado = cargado + productos + " ---> " + 1500 + "\n";
                    valor = valor + 1500;
                } else if (productos.equalsIgnoreCase("JUGOS")) {
                    cargado = cargado + productos + " ---> " + 2000 + "\n";
                    valor = valor + 2000;
                }
            }
            ciclo = false;
        }
        cargado = cargado + "TOTAL: " + valor;
        cliente++;
        return cargado;
    }

//CARGA LOS ASIENTOS QUE ESTAN OCUPADOS Y LOS CARGA EN LA FACTURA CON SU VALOR CORRESPONDIENTE
    public String facturaAsientos(int i, int tribuna) {
        int total = 0;
        cargarTribunas = "ASIENTO " + asientos + "\n";

        if (i == 0 && tribuna == 2) {
            cargarTribunas = cargarTribunas + "ECONOMICA ---> " + 50000 + "\n";
            total = total + 7500;
        } else if (i == 1 && tribuna == 2) {
            cargarTribunas = cargarTribunas + "ESTANDAR ---> " + 80000 + "\n";
            total = total + 5500;
        } else if (i == 2 && tribuna == 2) {
            cargarTribunas = cargarTribunas + "VIP---> " + 150000 + "\n";
            total = total + 4500;
        } else if (i == 0 && tribuna == 1) {
            cargarTribunas = cargarTribunas + "VIP---> " + 150000 + "\n";
            total = total + 2500;
        } else if (i == 1 && tribuna == 1) {
            cargarTribunas = cargarTribunas + "ESTANDAR---> " + 80000 + "\n";
            total = total + 3500;
        } else if (i == 2 && tribuna == 1) {
            cargarTribunas = cargarTribunas + "ECONOMICA---> " + 50000 + "\n";
            total = total + 1500;

        }
        asientos++;
        return cargarTribunas;
    }
//CARGA LOS MENSAJES QUE EL USUARIO DIGITO EN LA SECCION DE ATENCION AL CLIENTE

    public String comentariosAtencion(String atencion) {

        cargarTribunas = "MENSAJE " + numeroMensajes + "\n" + atencion + "\n";
        numeroMensajes++;
        return cargarTribunas;
    }
}
