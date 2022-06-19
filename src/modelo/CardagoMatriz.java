/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import control.Controller;

/**
 *
 * @author juans
 */
public class CardagoMatriz {

    private boolean salir;
//    private Controller objeto = new Controller();
    private int matrizSuperior[][];
    private int matrizInferior[][];

    public CardagoMatriz() {
        matrizSuperior = new int[3][9];
        matrizInferior = new int[3][9];
    }

    public boolean verificado() {

  //      salir = objeto.verificarTribuna();

        return salir;
    }

    public void bioseguridad() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 10; j++) {
                if ((i + j) % 2 == 0) {
                    matrizSuperior[i][j] = 0;
                } else {
                    matrizSuperior[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 10; j++) {
                if ((i + j) % 2 == 0) {
                    matrizInferior[i][j] = 0;
                } else {
                    matrizInferior[i][j] = 1;
                }
            }
        }
    }

    public void normal() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 10; j++) {
                matrizSuperior[i][j] = 1;
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 10; j++) {
                matrizInferior[i][j] = 1;
            }
        }
    }
    public void guardadoSuperiores(int fila, int columna) {
        String envio = "";
        if ((fila - 1) < 0 || (columna - 1) < 0 || (fila - 1) > 2 || (columna - 1) > 9) {
            envio = "El asiento no existe";
        } else {
            if (matrizSuperior[fila-1][columna-1] == 0) {
                envio = "El asiento esta bloqueado por normas de bioseguridad";
            } else if (matrizSuperior[fila-1][columna-1] == 2) {
                envio = "El asiento ya esta ocupado";
            } else if (matrizSuperior[fila-1][columna-1] == 1) {
                matrizSuperior[fila - 1][columna - 1] = 2;
                envio = "Su compra a sido exitosa";
            }

        }
    }
    public void guardadoInferior(int fila, int columna) {
        String envio = "";
        if ((fila - 1) < 0 || (columna - 1) < 0 || (fila - 1) > 2 || (columna - 1) > 9) {
            envio = "El asiento no existe";
        } else {
            if (matrizInferior[fila-1][columna-1] == 0) {
                envio = "El asiento esta bloqueado por normas de bioseguridad";
            } else if (matrizInferior[fila-1][columna-1] == 2) {
                envio = "El asiento ya esta ocupado";
            } else if (matrizInferior[fila-1][columna-1] == 1) {
                matrizInferior[fila - 1][columna - 1] = 2;
                envio = "Su compra a sido exitosa";
            }

        }
    }    
}
