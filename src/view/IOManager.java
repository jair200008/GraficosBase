package view;

import view.opcionePartido.Opciones;
import view.opcionePartido.TipoPartido;
import view.tribunasCovid.TribunaCovid;
import view.tribunasNormales.TribunaOccidental;
import control.Controller;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import view.opcionePartido.Equipos;
import view.otrosServicios.AtencionAlCliente;
import view.otrosServicios.Comidas;

/**
 * AUTOR:EDWAR JAIR GAONA Y JUAN SEBASTIAN SUAREZ FECHA:2/11/2020 DESCRIBCION:SE
 * ENCARGA DE CARGAR NUESTROS PANELES EN UN JFRAME Y SABER CUAL PANEL ES VISIBLE
 * Y CUAL NO
 *
 */
public class IOManager extends JFrame implements CustomEventResponde {

    //VARIABLES GLOBALES
    private JPanel panelPrincipal;
    private JPanel panelNormal;
    private JPanel opcionPartido;
    private JPanel panelCovid;
    private JPanel opcionComida;
    private JPanel panelAtencion;
    private JPanel panelEquipos;
    private JPanel panelCargarTribuna;
    private Controller objeto;
    private JLabel imagenPanel;
    private ImageIcon rutaUno;
    private ImageIcon logo;
    private String equipoLocal;
    private String equipoVisitante;
    //METODO CONSTRUCTOR
    public IOManager() {
        logo = new ImageIcon("src/imagenes/liga.png");
        rutaUno = new ImageIcon("src/imagenes/principal.jpg");
        objeto = new Controller();
        objeto.setEnvio(this);

        imagenPanel = new JLabel();
        imagenPanel.setBounds(0, 0, 785, 565);
        imagenPanel.setIcon(new ImageIcon(rutaUno.getImage().getScaledInstance(imagenPanel.getWidth(), imagenPanel.getHeight(), Image.SCALE_SMOOTH)));

        setTitle("FUTBOL+");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        add(imagenPanel);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        repaint();

        panelPrincipal = new Opciones();
        panelPrincipal.setBounds(5, 5, 785, 565);
        panelPrincipal.setBackground(Color.BLUE);
        ((Opciones) panelPrincipal).setObjetoCustom(objeto);
        panelPrincipal.add(imagenPanel);
        panelPrincipal.setVisible(true);
        add(panelPrincipal);

        opcionPartido = new TipoPartido();
        opcionPartido.setBackground(Color.BLUE);
        opcionPartido.setBounds(5, 5, 785, 565);

        opcionPartido.setVisible(false);
        add(opcionPartido);

        panelNormal = new TribunaOccidental();
        panelNormal.setBackground(Color.BLUE);
        panelNormal.setBounds(5, 5, 785, 565);

        panelNormal.setVisible(false);
        add(panelNormal);

        panelCovid = new TribunaCovid();
        panelCovid.setBackground(Color.BLUE);
        panelCovid.setBounds(5, 5, 785, 565);

        panelCovid.setVisible(false);
        add(panelCovid);

        opcionComida = new Comidas();
        opcionComida.setBackground(Color.BLUE);
        opcionComida.setBounds(5, 5, 785, 565);

        opcionComida.setVisible(false);
        add(opcionComida);

        panelAtencion = new AtencionAlCliente();
        panelAtencion.setBounds(5, 5, 785, 565);

        panelAtencion.setBackground(Color.BLUE);
        panelAtencion.setVisible(false);
        add(panelAtencion);

        panelEquipos = new Equipos();
        panelEquipos.setBackground(Color.BLUE);
        panelEquipos.setBounds(5, 5, 785, 565);

        panelEquipos.setVisible(false);
        add(panelEquipos);

        panelCargarTribuna = new TribunaCarga();
        panelCargarTribuna.setBounds(5, 5, 785, 565);

        panelCargarTribuna.setBackground(Color.BLUE);
        panelCargarTribuna.setVisible(false);
        add(panelCargarTribuna);

    }

    //CARGA EL PANEL PARA INGRESAR LOS EQUIPOS QUE JUGARAN
    @Override
    public void cargarPanelEquipos() {
        ((Equipos) panelEquipos).setObjetoCustom(objeto);
        panelEquipos.add(imagenPanel);
        panelCovid.setVisible(false);
        panelNormal.setVisible(false);
        panelEquipos.setVisible(true);
         panelCargarTribuna.setVisible(false);
        panelPrincipal.setVisible(false);
        repaint();
    }

    //CARGA EL PANEL PARA ESCOGER QUE MEDIDAD DE BIOSEGURIDAD TENDRA EL PARTIDO
    @Override
    public void cambioTipoPartido() {
        

        ((TipoPartido) opcionPartido).setObjetoCustom(objeto);
        opcionPartido.add(imagenPanel);
        panelCovid.setVisible(false);
        panelNormal.setVisible(false);
        panelEquipos.setVisible(false);
        opcionPartido.setVisible(true);
         panelCargarTribuna.setVisible(false);
        panelPrincipal.setVisible(false);

        repaint();

    }

    @Override
    public void cambioEscudos(String local, String visitante) {
        equipoLocal=local;
        equipoVisitante=visitante;
        ((TribunaCovid) panelCovid).setObjetoCustom(objeto);
        ((TribunaCovid) panelCovid).cargarEquipos(local,visitante);
        ((TribunaOccidental) panelNormal).setObjetoCustom(objeto);
        ((TribunaOccidental) panelNormal).cargarEquipos(local,visitante);
        ((TipoPartido) opcionPartido).setObjetoCustom(objeto);
        opcionPartido.add(imagenPanel);
        panelCovid.setVisible(false);
        panelNormal.setVisible(false);
        panelEquipos.setVisible(false);
        opcionPartido.setVisible(true);
         panelCargarTribuna.setVisible(false);
        panelPrincipal.setVisible(false);

    }
    

    //CREAR E PANEL SEGUN EL TIPO DE MEDIDAS DE BIOSEGURIDAD
    @Override
    public void cargarPanelCovid() {
        ((TribunaCovid) panelCovid).setObjetoCustom(objeto);
        opcionComida.setVisible(false);
        panelAtencion.setVisible(false);
        opcionPartido.setVisible(false);
         panelCargarTribuna.setVisible(false);
        panelCovid.setVisible(true);
        panelCovid.add(imagenPanel);
        repaint();
    }

    //CARGA EL PANEL SIN MEDIDAS DE BIOSEGURIDAD
    @Override
    public void cargarPanelNormal() {
        ((TribunaOccidental) panelNormal).setObjetoCustom(objeto);
        panelNormal.add(imagenPanel);
        panelAtencion.setVisible(false);
        panelNormal.setVisible(true);
        opcionComida.setVisible(false);
        opcionPartido.setVisible(false);
        panelCargarTribuna.setVisible(false);
        repaint();
    }
    //CARGA EL PANEL DE LA SECCION DE COMIDA

    @Override
    public void panelComida(int numero) {
        ((Comidas) opcionComida).setObjetoCustom(objeto);
        ((Comidas) opcionComida).volverTipoPanel(numero);
        opcionComida.add(imagenPanel);
        opcionComida.setVisible(true);
        panelCargarTribuna.setVisible(false);
        panelAtencion.setVisible(false);
        panelCovid.setVisible(false);
        panelNormal.setVisible(false);
        repaint();
    }

    //ENCIA LOS MENSAJES A LOS PANELES DE LAS TRIBUNAS
    @Override
    public void mensajesVista(String mensaje) {
        ((TribunaCovid) panelCovid).impresiones(mensaje);

        ((TribunaOccidental) panelNormal).impresiones(mensaje);

        ((TribunaCarga) panelCargarTribuna).impresiones(mensaje);
    }
    //ENVIA MENSAJES A LA SECCION DE COMIDAS

    @Override
    public void mensajeComida(String mensaje) {
        ((Comidas) opcionComida).impresiones(mensaje);
    }

    //CARGA EL PANEL DE ATENION AL CLIENTE
    @Override
    public void cargarPanelAtencion(int numero) {
        ((AtencionAlCliente) panelAtencion).setObjetoCustom(objeto);
        ((AtencionAlCliente) panelAtencion).opciones(numero);
        panelAtencion.add(imagenPanel);
        panelAtencion.setVisible(true);
        panelNormal.setVisible(false);
        panelCovid.setVisible(false);
        opcionComida.setVisible(false);
         panelCargarTribuna.setVisible(false);
        opcionPartido.setVisible(false);

        repaint();
    }

    @Override
    public void cambiarVerificado(boolean verificar) {
        ((Opciones) panelPrincipal).verificado(verificar);
    }

    @Override
    public void panelCargar() {
        ((TribunaCarga) panelCargarTribuna).setObjetoCustom(objeto);
        panelCargarTribuna.add(imagenPanel);
        panelCovid.setVisible(false);
        panelNormal.setVisible(false);
        panelCargarTribuna.setVisible(true);
        panelAtencion.setVisible(false);
        opcionComida.setVisible(false);
        panelPrincipal.setVisible(false);
        repaint();
    }
    
    

}
