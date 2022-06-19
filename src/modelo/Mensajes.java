/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 * AUTOR:EDWAR JAIR GAONA Y JUAN SEBASTIAN SUAREZ FECHA:2/11/2020 DESCRIBCION:
 * SE ENCUENTRAN LOS COMPONENTES GRAFICOS DE LA TIBUNA OCCIDENTAL SIN MEDIDAS DE
 * BIOSEGURIDAD
 *
 */
public class Mensajes {
    //VARIABLES GLOBALES

    private int cliente;
    private String cargado;
    private int tribuna[][];
    private String mensajes;
    private boolean opciones;
    //METODO CONSTRUCTOR
    public Mensajes() {
        cliente = 1;
        tribuna = new int[3][10];
        mensajes = "";
    }
//VERIFICA SI EL PARTIDO TIENE MEDIDAS DE COVID O NO

    public boolean tipoPartido(int num) {
        if (num == 0) {
            opciones = true;
        } else {
            opciones = false;
        }

        return opciones;
    }

    //ENVIA UN MENSAJE A LA VISTA SOBRE LOS ASIENTOS Y SU VALOR

    public String precios(int i) {
        if (i == 0) {

            mensajes = ("EL VALOR DE LA ENTRADA ES DE: $ 50.000");
        } else if (i == 1) {
            mensajes = ("EL VALOR DE LA ENTRADA ES DE: $ 80.000");
        } else if (i == 2) {
            mensajes = ("EL VALOR DE LA ENTRADA ES DE: $ 150.000");
        } else {
            mensajes = ("");
        }

        return mensajes;
    }

    //ENVIA UN MENSAJE A LA VISTA DEPENDIENDO EL PRODUCTO POR EL CUAL EL USUARIO ESTE INTERESADO

    public String preciosComida(int i) {
        if (i == 0) {

            mensajes = ("EL VALOR DE LAS HAMBUERGUESAS ES DE: $ 7.500");
        } else if (i == 1) {
            mensajes = ("EL VALOR DE LOS PERROS ES DE: $ 5.500");
        } else if (i == 2) {
            mensajes = ("EL VALOR DE LAS PAPAS ES DE: $ 4.500");
        } else if (i == 3) {
            mensajes = ("EL VALOR DE EL PAQUETE ES DE: $ 2.500");
        } else if (i == 4) {
            mensajes = ("EL VALOR DE LA GASEOSA ES DE: $ 3.500");
        } else if (i == 5) {
            mensajes = ("EL VALOR DE EL AGUA ES DE: $ 1.500");
        } else if (i == 6) {
            mensajes = ("EL VALOR DE EL JUGO ES: $ 2.000");
        } else {

            mensajes = ("");
        }

        return mensajes;
    }

    //ENVIA UN MENSAJE DEL SUB TOTAL DE LOS PRODUCTOS SELECCIONADOS

    public String subTotal(String ventas) {
        boolean ciclo = true;
        int valor = 0;
        String productos;
        String articulo[] = ventas.split("/");

        while (ciclo) {

            for (int i = 0; i < articulo.length; i++) {
                productos = articulo[i];
                if (productos.equalsIgnoreCase("HAMBURGUESAS")) {
                    valor = valor + 7500;
                } else if (productos.equalsIgnoreCase("PERROS")) {
                    valor = valor + 5500;
                } else if (productos.equalsIgnoreCase("PAPAS")) {
                    valor = valor + 4500;
                } else if (productos.equalsIgnoreCase("PAQUETES")) {
                    valor = valor + 2500;
                } else if (productos.equalsIgnoreCase("GASEOSAS")) {
                    valor = valor + 3500;
                } else if (productos.equalsIgnoreCase("AGUA")) {
                    valor = valor + 1500;
                } else if (productos.equalsIgnoreCase("JUGOS")) {
                    valor = valor + 2000;
                }
            }
            ciclo = false;
        }
        mensajes = "EL SUBTOTAL DE SUS COMPRAS ES: $ " + valor;
        return mensajes;
    }
    //ENVIA UN MENSAJE QUE MUESTRA QUE LA COMPRA DEL ASIENTO FUE REALIZADA CON EXITO

    public String compraRealizada(int x, int y) {
        tribuna[x][y] = 2;
        mensajes = "SU COMPRA SE A REALIZADO CON EXITO";
        return mensajes;
    }

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
                    cargado = cargado + productos + 7500 + "\n";
                    valor = valor + 7500;
                } else if (productos.equalsIgnoreCase("PERROS")) {
                    cargado = cargado + productos + 5500 + "\n";
                    valor = valor + 5500;
                } else if (productos.equalsIgnoreCase("PAPAS")) {
                    cargado = cargado + productos + 4500 + "\n";
                    valor = valor + 4500;
                } else if (productos.equalsIgnoreCase("PAQUETES")) {
                    cargado = cargado + productos + 2500 + "\n";
                    valor = valor + 2500;
                } else if (productos.equalsIgnoreCase("GASEOSAS")) {
                    cargado = cargado + productos + 3500 + "\n";
                    valor = valor + 3500;
                } else if (productos.equalsIgnoreCase("AGUA")) {
                    cargado = cargado + productos + 1500 + "\n";
                    valor = valor + 1500;
                } else if (productos.equalsIgnoreCase("JUGOS")) {
                    cargado = cargado + productos + 2000 + "\n";
                    valor = valor + 2000;
                }
            }
            ciclo = false;
        }
        cargado = cargado + "TOTAL: " + valor;
        cliente++;
        return cargado;
    }
}
