/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.File;

/**
 *
 * @author Jose-PC
 */
public class Equipos {

    private String america;
    private String caldas;
    private String cali;
    private String chico;
    private String equidad;
    private String junior;
    private String medellin;
    private String millonarios;
    private String nacional;
    private String pasto;
    private String patriotas;
    private String santa;
    private String tolima;
    private String Escudolocal;
    private String escudoVisitante;

    public Equipos() {
        america = "src/imagenes/escudos/america.png";
        caldas = "src/imagenes/escudos/caldad.png";
        cali = "src/imagenes/escudos/cali.png";
        chico = "src/imagenes/escudos/chico.png";
        equidad = "src/imagenes/escudos/equidad.png";
        junior = "src/imagenes/escudos/junior.png";
        medellin = "src/imagenes/escudos/medellin.png";
        millonarios = "src/imagenes/escudos/millorarios.png";
        nacional = "src\\imagenes\\escudos\\nacional.png";
        pasto = "src/imagenes/escudos/pasto.png";
        patriotas = "src/imagenes/escudos/patriotas.png";
        santa = "src/imagenes/escudos/santa fe.png";
        tolima = "src/imagenes/escudos/tolima.png";
        Escudolocal = "src\\imagenes\\escudos\\local.png";
        escudoVisitante = "src/imagenes/escudos/visitante.png";

    }

    public String escogerLocal(String local) {
        if (local.equalsIgnoreCase("america")) {
            return america;
        }
        if (local.equalsIgnoreCase("oncecaldas") || local.equalsIgnoreCase("once caldas") || local.equalsIgnoreCase("caldas")) {
            return caldas;
        }
        if (local.equalsIgnoreCase("cali")) {
            return cali;
        }
        if (local.equalsIgnoreCase("chico")) {
            return chico;
        }
        if (local.equalsIgnoreCase("equidad")) {
            return equidad;
        }
        if (local.equalsIgnoreCase("junior")) {
            return junior;
        }
        if (local.equalsIgnoreCase("medellin")) {
            return medellin;
        }
        if (local.equalsIgnoreCase("millonarios")) {
            return millonarios;
        }
        if (local.equalsIgnoreCase("nacional")) {
            return nacional;
        }
        if (local.equalsIgnoreCase("pasto")) {
            return pasto;
        }
        if (local.equalsIgnoreCase("patriotas")) {
            return patriotas;
        }
        if (local.equalsIgnoreCase("santafe") || local.equalsIgnoreCase("santa fe")) {
            return santa;
        }
        if (local.equalsIgnoreCase("tolima")) {
            return tolima;
        } else {
            return Escudolocal;
        }
    }

    public String escogerVisitante(String visitante) {
        if (visitante.equalsIgnoreCase("america")) {
            return america;
        }
        if (visitante.equalsIgnoreCase("oncecaldas") || visitante.equalsIgnoreCase("once caldas") || visitante.equalsIgnoreCase("caldas")) {
            return caldas;
        }
        if (visitante.equalsIgnoreCase("cali")) {
            return cali;
        }
        if (visitante.equalsIgnoreCase("chico")) {
            return chico;
        }
        if (visitante.equalsIgnoreCase("equidad")) {
            return equidad;
        }
        if (visitante.equalsIgnoreCase("junior")) {
            return junior;
        }
        if (visitante.equalsIgnoreCase("medellin")) {
            return medellin;
        }
        if (visitante.equalsIgnoreCase("millonarios")) {
            return millonarios;
        }
        if (visitante.equalsIgnoreCase("nacional")) {
            return nacional;
        }
        if (visitante.equalsIgnoreCase("pasto")) {
            return pasto;
        }
        if (visitante.equalsIgnoreCase("patriotas")) {
            return patriotas;
        }
        if (visitante.equalsIgnoreCase("santafe") || visitante.equalsIgnoreCase("santa fe")) {
            return santa;
        }
        if (visitante.equalsIgnoreCase("tolima")) {
            return tolima;
        } else {
            return escudoVisitante;
        }

    }
}
