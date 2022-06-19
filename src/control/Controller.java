package control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;import modelo.CardagoMatriz;
import modelo.Equipos;
/**
 * AUTOR:EDWAR JAIR GAONA Y JUAN SEBASTIAN SUAREZ FECHA:2/11/2020 DESCRIBCION:
 * SE ENCARGA DE CARGAR LOS ARCHIVOS TXT Y DE COMUNICAR LA VISTA Y EL MODELO
 *
 */
import modelo.Facturas;
import modelo.Mensajes;
import view.CustomEvent;
import view.CustomEventResponde;
import view.IOManager;


public class Controller implements CustomEvent {

    //VARIABLES GLOBALES
    private String textoComida;
    private String textoAsiento;
    private String textoAtencion;
    private Mensajes objeto;
    private Facturas cargadoArchivo;
    private String mensaje;
    private CustomEventResponde objetoCustomResponde;
    private CardagoMatriz objetoMatriz;
    public boolean salir;
    public File rutaTribuna;
    public File rutaTribunaInferior;
    public File rutaTribunaSuperior;
    private File rutaComida;
    private File rutaAtencion;
    private Equipos objetoEquipos;

    //METODO CONSTRUCTOR
    public Controller() {
        textoAsiento = "";
        textoComida = "";
        textoAtencion = "";
        cargadoArchivo = new Facturas();
        objetoEquipos=new Equipos();
        objetoMatriz=new CardagoMatriz();
        rutaTribuna = new File("src/archivos/tribuna.txt");
        rutaComida = new File("src/archivos/archivoComida.txt");
        rutaAtencion = new File("src/archivos/archivoAtencion.txt");
        rutaTribunaSuperior=new File("src/archivos/posicionInferior.txt");
        rutaTribunaSuperior=new File("src/archivos/posicionSuperior.txt");
        
        salir = true;
        objeto = new Mensajes();
        mensaje = "";
    }

    //GET Y SET DEL OBJETO CUSTOMEVENTRESPONSE
    public CustomEventResponde getEnvio(CustomEventResponde objetoCustomResponde) {
        return objetoCustomResponde;
    }

    public CustomEventResponde setEnvio(CustomEventResponde objetoCustomResponde) {
        this.objetoCustomResponde = objetoCustomResponde;
        return objetoCustomResponde;
    }
    
    @Override
    public void retornarGuardado(int x, int y) {
        mensaje = objeto.compraRealizada(x, y);
        objetoCustomResponde.mensajesVista(mensaje);
    }

    //ENVIA EL VALOR DE LOS ASIENTOS AL MODELO
    @Override
    public void mensajePrecio(int i) {
        mensaje = objeto.precios(i);
        objetoCustomResponde.mensajesVista(mensaje);
    }

    //CAMBIA DE PANEL AL QUE SE ENCARGA DE PONER LOS NOMBRES DE LOS EQUIPOS
    @Override
    public void cambioPanel() {
        objetoCustomResponde.cargarPanelEquipos();
    }

    //CAMBIA AL PANEL CON LAS MEDIADAS ESCOGIDAS
    @Override
    public void cambiarTipoPartido(String local,String visitante) {
        
        objetoCustomResponde.cambioEscudos(objetoEquipos.escogerLocal(local),objetoEquipos.escogerVisitante(visitante));
    }

    //CAMBIA AL PANEL DE MEDIDAD DE COVID O SIN MEDIDAD DE BIOSEGURIDAD
    @Override
    public void cargarMatriz(int num) {
        if (objeto.tipoPartido(num)) {

            objetoCustomResponde.cargarPanelCovid();
        } else {
            objetoCustomResponde.cargarPanelNormal();
        }
    }


    //CAMBIA AL PANEL DE COMIDA
    @Override
    public void llamarComida(int numero) {
        objetoCustomResponde.panelComida(numero);

    }

    //ENVIA LOS MENSAJES DE LOS PRECIOS DE LA COMIDA

    @Override
    public void valorComida(int i) {
        mensaje = objeto.preciosComida(i);
        objetoCustomResponde.mensajeComida(mensaje);
    }

    //ENVIA EL SUBTOTAL DE LOS PRODUCTOS SELECCIONADOS

    @Override
    public void llamarsubTotal(String ventas) {
        mensaje = objeto.subTotal(ventas);
        objetoCustomResponde.mensajeComida(mensaje);
    }

    @Override
    public void llamarVerificarPartido() {
        objetoCustomResponde.cambiarVerificado(objetoMatriz.verificado());
    }

    @Override
    public void llamarCargado() {
        objetoCustomResponde.panelCargar();
    }
    

    //CARGA LA FACTURA DE ALIMENTOS

    @Override
    public void cargarFactura(String ventas, int cambio) {
        textoComida = textoComida + cargadoArchivo.total(ventas) + "\n";

        try {
            BufferedWriter escribir = new BufferedWriter(new FileWriter(rutaComida));
            escribir.write(textoComida);
            escribir.newLine();
            escribir.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (cambio==0) {

            objetoCustomResponde.cargarPanelCovid();
        } else if(cambio==1){
            
        }else{
            objetoCustomResponde.panelCargar();
        }

    }

    //CARGA LA FACTURA DE ASIENTOS

    @Override
    public void cargarFacturaTribunas(int i, int tribuna) {
        textoAsiento = textoAsiento + cargadoArchivo.facturaAsientos(i, tribuna) + "\n";
        try {
            BufferedWriter escribir = new BufferedWriter(new FileWriter(rutaTribuna));
            escribir.write(textoAsiento);
            escribir.newLine();
            escribir.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //SE DEVUELVE AL PANEL DE TIPO DE PARTIDO SI QUIERE CAMBIAR DE MEDIDAD

    @Override
    public void llamarVolver() {
        objetoCustomResponde.cambioTipoPartido();
    }
    //ENVIA AL PANEL DE ATENCION AL CLIENTE

    @Override
    public void llamarAtencion(int numero) {
        objetoCustomResponde.cargarPanelAtencion(numero);

    }
    //CARGA LA FACTURA CON LAS PETICIONES DE LOS USUARIOS

    @Override
    public void cargarFacturaAtencion(String comentario, int cambio) {
        textoAtencion = textoAtencion + cargadoArchivo.comentariosAtencion(comentario) + "\n";

        try {
            BufferedWriter escribir = new BufferedWriter(new FileWriter(rutaAtencion));
            escribir.write(textoAtencion);
            escribir.newLine();
            escribir.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (cambio==0) {

            objetoCustomResponde.cargarPanelCovid();
        } else if(cambio==1){
            
        }else{
            objetoCustomResponde.panelCargar();
        }

    }
    
       public boolean verificarTribuna() {
        String contenido = "";
        
        try {
            BufferedReader leer = new BufferedReader(new FileReader(rutaTribunaSuperior));
            contenido = leer.readLine();
            if (contenido == null) {
                salir = false;
            } else {
                salir = true;
            }
                leer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return salir;
    }


    public void init() {
        IOManager objeto = new IOManager();
        objeto.setVisible(true);

    }

}
