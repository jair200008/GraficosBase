package view.tribunasNormales;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import view.CustomEvent;

/**
 * AUTOR:EDWAR JAIR GAONA Y JUAN SEBASTIAN SUAREZ FECHA:2/11/2020 DESCRIBCION:
 * SE ENCUENTRAN LOS COMPONENTES GRAFICOS DE LA TIBUNA OCCIDENTAL SIN MEDIDAS DE
 * BIOSEGURIDAD
 *
 */
public class TribunaOccidental extends JPanel implements MouseListener {

    //VARIUABLES GLOBALES

    JButton asientosInferiores[][] = new JButton[3][9];
    JButton asientosSuperiores[][] = new JButton[3][9];
    private ImageIcon asientoVacio;
    private ImageIcon asientoOcupado;
    private ImageIcon imagenAtras;
    private ImageIcon imagenAtencion;
    private ImageIcon imagenComida;
    private ImageIcon imagenLocal;
    private ImageIcon imagenVersus;
    private ImageIcon imagenVisitante;
    private JSeparator separadoresSuperiores[];
    private JSeparator separadoresInferiores[];
    private JLabel vip[];
    private JLabel estandar[];
    private JLabel economico[];
    private JLabel equipoLocal;
    private JLabel equipoVisitante;
    private JTextField precios[];
    private CustomEvent objetoCustom;
    private String imprimir;
    private ImageIcon iconoCompra;
    private JLabel compra;
    private JButton volver;
    private JButton comida;
    private JButton atencion;
    private int bloqueoVolver;
    private String equipo1;
    private String equipo2;

    public TribunaOccidental() {
        //METODO CONSTRUCTOR
        bloqueoVolver = 0;
        separadoresSuperiores = new JSeparator[4];
        separadoresInferiores = new JSeparator[4];
        vip = new JLabel[4];
        estandar = new JLabel[4];
        economico = new JLabel[4];
        precios = new JTextField[2];
        imprimir = "";
        setLayout(null);
        setBorder(new TitledBorder(null, "TRIBUNA OCCIDENTAL", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
        //RUTA DE LAS IMAGENES
        asientoVacio = new ImageIcon("src\\imagenes\\asientoVacio.png");
        asientoOcupado = new ImageIcon("src\\imagenes\\asientoOcupado.png");
        iconoCompra = new ImageIcon("src\\imagenes\\compra.gif");
        imagenAtras = new ImageIcon("src\\imagenes\\volver.png");
        imagenComida = new ImageIcon("src\\imagenes\\comida.png");
        imagenAtencion = new ImageIcon("src\\imagenes\\atencion.png");
        imagenVersus = new ImageIcon("src\\imagenes\\versus.png");
        //METODOS CON LOS COMPONENTES GRAFICOS
        tribunasSuperiores();
        tribunasInferiores();
        cuadrosDeTextos();
        etiquetas();
        botones();
    }

    //CREA LOS BOTONES EN EL PANES

    public void botones() {
        //VOLVERA AL PANEL ANTERIOR
        volver = new JButton();
        volver.setBounds(5, 5, 100, 50);
        volver.setIcon(new ImageIcon(imagenAtras.getImage().getScaledInstance(volver.getWidth(), volver.getHeight(), Image.SCALE_SMOOTH)));
        volver.setBackground(Color.BLUE);
        volver.setOpaque(false);
        volver.setBorderPainted(false);
        volver.addMouseListener(this);
        add(volver);

        equipoLocal = new JLabel();
        equipoLocal.setBounds(100, 200, 200, 150);
        add(equipoLocal);

        equipoVisitante = new JLabel();
        equipoVisitante.setBounds(520, 200, 200, 150);
        add(equipoVisitante);

        //SE DIRIGIRA AL PANEL DE COMIDA
        comida = new JButton();
        comida.setBounds(670, 5, 100, 50);
        comida.setIcon(new ImageIcon(imagenComida.getImage().getScaledInstance(comida.getWidth(), comida.getHeight(), Image.SCALE_SMOOTH)));
        comida.setBackground(Color.BLUE);
        comida.setOpaque(false);
        comida.setBorderPainted(false);
        comida.addMouseListener(this);
        add(comida);
        //SE DIRIGIRA AL PAEL DE ATENCIONAL CLIENTE
        atencion = new JButton();
        atencion.setBounds(680, 500, 100, 50);
        atencion.setIcon(new ImageIcon(imagenAtencion.getImage().getScaledInstance(comida.getWidth(), comida.getHeight(), Image.SCALE_SMOOTH)));
        atencion.setBackground(Color.BLUE);
        atencion.setOpaque(false);
        atencion.setBorderPainted(false);
        atencion.addMouseListener(this);
        add(atencion);
    }

    //CARGARA LOS MENSAJES QUE SE MOSTRARAN POR PANTALLA

    public void impresiones(String mensaje) {
        imprimir = mensaje;
    }

    public void cargarEquipos(String local, String visitante) {
        equipo1 = visitante;
        equipo2 = local;
        imagenLocal = new ImageIcon(equipo1);
        equipoLocal.setIcon(new ImageIcon(imagenLocal.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));

        imagenVisitante = new ImageIcon(equipo2);
        equipoVisitante.setIcon(new ImageIcon(imagenVisitante.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
    }

    //CREARA AS TRIBUNAS SUPERIORES

    private void tribunasSuperiores() {
        int x = 200;
        int y = 20;
        int separacion = 15;
        for (int i = 0; i < 3; i++) {
            separadoresSuperiores[i] = new JSeparator();
            separadoresSuperiores[i].setBounds(200, separacion, 350, 5);
            add(separadoresSuperiores[i]);
            separacion = separacion + 59;

            for (int j = 0; j < 9; j++) {
                asientosSuperiores[i][j] = new JButton("");
                asientosSuperiores[i][j].setBounds(x, y, 30, 30);
                asientosSuperiores[i][j].setBackground(Color.BLUE);
                asientosSuperiores[i][j].setOpaque(false);
                asientosSuperiores[i][j].setBorderPainted(false);
                asientosSuperiores[i][j].addMouseListener(this);
                asientosSuperiores[i][j].setIcon(new ImageIcon(asientoVacio.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
                add(asientosSuperiores[i][j]);
                x = x + 40;
            }
            y = y + 60;
            x = 200;
        }
    }
    //CREARA LAS TRIBUNAS INFERIORES

    private void tribunasInferiores() {
        int x = 200;
        int y = 400;
        int separacion = 395;
        for (int i = 0; i < 3; i++) {
            separadoresInferiores[i] = new JSeparator();
            separadoresInferiores[i].setBounds(200, separacion, 350, 5);
            add(separadoresInferiores[i]);
            separacion = separacion + 59;

            for (int j = 0; j < 9; j++) {
                asientosInferiores[i][j] = new JButton("");
                asientosInferiores[i][j].setBounds(x, y, 30, 30);
                x = x + 40;
                asientosInferiores[i][j].setBackground(Color.BLUE);
                asientosInferiores[i][j].setOpaque(false);
                asientosInferiores[i][j].setBorderPainted(false);
                asientosInferiores[i][j].addMouseListener(this);
                asientosInferiores[i][j].setIcon(new ImageIcon(asientoVacio.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
                add(asientosInferiores[i][j]);
            }
            y = y + 60;
            x = 200;
        }
    }
    //CUADRO DE TEXTO CON LA EL VALOR DE LOS ASIENTOS

    private void cuadrosDeTextos() {
        int x = 200;
        int y = 170;
        for (int i = 0; i < 2; i++) {
            precios[i] = new JTextField();
            precios[i].setBounds(x, y, 350, 27);
            precios[i].setHorizontalAlignment(JTextField.CENTER);
            precios[i].setEditable(false);
            add(precios[i]);
            y = 350;

        }
    }
//IMAGENES QUE SE CARGARAN EL EL PANEL

    private void etiquetas() {

        int x = 345;
        int y = 0;
        for (int i = 0; i < 2; i++) {
            economico[i] = new JLabel("ECONOMICO");
            economico[i].setBounds(x, y, 150, 20);
            add(economico[i]);
            y = 495;
        }
        x = 345;
        y = 58;
        for (int i = 0; i < 2; i++) {
            estandar[i] = new JLabel("ESTANDAR");
            estandar[i].setBounds(x, y, 150, 20);
            add(estandar[i]);
            y = 435;
        }
        x = 370;
        y = 115;
        for (int i = 0; i < 2; i++) {
            vip[i] = new JLabel("VIP");
            vip[i].setBounds(x, y, 150, 20);
            add(vip[i]);
            y = 375;

        }
        compra = new JLabel();
        compra.setBounds(300, 200, 150, 150);
        compra.setOpaque(false);
        compra.setIcon(new ImageIcon(imagenVersus.getImage().getScaledInstance(compra.getWidth(), compra.getHeight(), Image.SCALE_SMOOTH)));
        compra.setOpaque(false);

        add(compra);
    }

    //GET Y SET DEL OBJETO CUSTOM 

    public CustomEvent getObjetoCustom() {
        return objetoCustom;
    }

    public void setObjetoCustom(CustomEvent objetoCustom) {
        this.objetoCustom = objetoCustom;
    }
//REALIZARA LAS ACCIONES QUE EL USUARIO DESEA

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                if (e.getSource() == asientosSuperiores[i][j] && asientosSuperiores[i][j].getBackground() != Color.BLACK) {
                    objetoCustom.retornarGuardado(i, j);
                    asientosSuperiores[i][j].setBackground(Color.BLACK);
                    asientosSuperiores[i][j].setIcon(new ImageIcon(asientoOcupado.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
                    asientosSuperiores[i][j].setEnabled(false);
                    precios[0].setText(imprimir);
                    compra.setIcon(iconoCompra);
                    volver.setEnabled(false);
                    objetoCustom.cargarFacturaTribunas(i, 2);
                    bloqueoVolver = 1;
                }
                if (e.getSource() == asientosInferiores[i][j] && asientosInferiores[i][j].getBackground() != Color.BLACK) {
                    objetoCustom.retornarGuardado(i, j);
                    asientosInferiores[i][j].setBackground(Color.BLACK);
                    asientosInferiores[i][j].setIcon(new ImageIcon(asientoOcupado.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
                    asientosInferiores[i][j].setEnabled(false);
                    precios[1].setText(imprimir);
                    compra.setIcon(iconoCompra);
                    volver.setEnabled(false);
                    objetoCustom.cargarFacturaTribunas(i, 1);
                    bloqueoVolver = 1;
                }
            }
        }
        if (e.getSource() == volver && bloqueoVolver != 1) {
            objetoCustom.llamarVolver();
        }
        if (e.getSource() == comida) {
            objetoCustom.llamarComida(1);
        }
        if (e.getSource() == atencion) {
            objetoCustom.llamarAtencion(1);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                if (e.getSource() == asientosSuperiores[i][j] && asientosSuperiores[i][j].getBackground() != Color.black) {
                    asientosSuperiores[i][j].setBackground(Color.WHITE);
                    objetoCustom.mensajePrecio(i);
                    precios[0].setText(imprimir);
                    compra.setIcon(null);

                }
                if (e.getSource() == asientosInferiores[i][j] && asientosInferiores[i][j].getBackground() != Color.black) {
                    asientosInferiores[i][j].setBackground(Color.WHITE);
                    objetoCustom.mensajePrecio(i);
                    precios[1].setText(imprimir);
                    compra.setIcon(null);

                }
            }
        }
        compra.setIcon(new ImageIcon(imagenVersus.getImage().getScaledInstance(compra.getWidth(), compra.getHeight(), Image.SCALE_SMOOTH)));
        compra.setOpaque(false);

    }

    @Override
    public void mouseExited(MouseEvent e) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                if (e.getSource() == asientosSuperiores[i][j] && asientosSuperiores[i][j].getBackground() != Color.BLACK) {
                    asientosSuperiores[i][j].setBackground(Color.BLUE);

                    objetoCustom.mensajePrecio(4);
                    precios[0].setText(imprimir);
                    compra.setIcon(null);
                }
                if (e.getSource() == asientosInferiores[i][j] && asientosInferiores[i][j].getBackground() != Color.BLACK) {
                    asientosInferiores[i][j].setBackground(Color.BLUE);

                    objetoCustom.mensajePrecio(4);
                    precios[1].setText(imprimir);
                    compra.setIcon(null);
                }
            }

        }
        compra.setIcon(new ImageIcon(imagenVersus.getImage().getScaledInstance(compra.getWidth(), compra.getHeight(), Image.SCALE_SMOOTH)));
        compra.setOpaque(false);

    }

}
