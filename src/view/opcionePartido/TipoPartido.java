package view.opcionePartido;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import view.CustomEvent;

/**
 * AUTOR:EDWAR JAIR GAONA Y JUAN SEBASTIAN SUAREZ FECHA:2/11/2020 DESCRIBCION:
 * SE ENCARGA DE CARGAR LOS COMPONENTES GRAFICOS DE LA CLASE TIPO PARTIDO Y
 * REALIZAR LAS ACCIONES QU EL USUARIO DESEE
 *
 */
public class TipoPartido extends JPanel implements MouseListener {

    //VARIABLES GLOBALES

    private CustomEvent objetoCustom;
    private JButton bioseguridad;
    private JButton normal;
    private JTextField descripcion;
    private JLabel imagen;
    private ImageIcon rutaUno;
    private ImageIcon rutaDos;

    //METODO CONSTRUCTOR

    public TipoPartido() {
        rutaUno = new ImageIcon("src\\imagenes\\covid.gif");
        rutaDos = new ImageIcon("src\\imagenes\\normal.gif");

        setBorder(new TitledBorder(null, "TRIBUNA OCCIDENTAL", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
        setLayout(null);
        //CREARA UN PARTIDO CON MEDIDAD DE BIOSEGURIDAD
        bioseguridad = new JButton("Bioseguridad");
        bioseguridad.setBounds(100, 400, 150, 30);
        bioseguridad.setBackground(Color.red);
        bioseguridad.addMouseListener(this);
        add(bioseguridad);
        //CREARA UN PARTIDO SIN MEDIDAS DE BIOSEGURIDAD 
        normal = new JButton("Normal");
        normal.setBounds(500, 400, 150, 30);
        normal.setBackground(Color.red);
        normal.addMouseListener(this);
        add(normal);
        //CREARA UN CUADRO DE TEXTO DESCRIBIENDO LAS ACCIONES DE CADA BOTON
        descripcion = new JTextField();
        descripcion.setBounds(100, 350, 550, 30);
        descripcion.setHorizontalAlignment(JTextField.CENTER);
        descripcion.setEditable(false);
        add(descripcion);

        //CARGARA UNA IMAGEN ANTES QUE EL USUARIO RELICE UNA ACCION
        imagen = new JLabel();
        imagen.setBounds(220, 50, 280, 280);
        add(imagen);

    }

    //GET Y SET DEL OBJETO CUSTOM EVENT

    public CustomEvent getObjetoCustom() {
        return objetoCustom;
    }

    public void setObjetoCustom(CustomEvent objetoCustom) {
        this.objetoCustom = objetoCustom;
    }
    //REALIZARA LAS ACCIONES QUE EL USUARIO DESEE

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == bioseguridad) {
            objetoCustom.cargarMatriz(0);

        }
        if (e.getSource() == normal) {
            objetoCustom.cargarMatriz(1);

        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == bioseguridad) {
            descripcion.setText("ALGUNOS ASIENTOS NO ESTARAN DISPONIBLES");
            bioseguridad.setBackground(Color.white);
            imagen.setIcon(rutaUno);
        }
        if (e.getSource() == normal) {
            descripcion.setText("SE PODRAN VENDER TODOS LOS ASIENTOS");
            normal.setBackground(Color.WHITE);
            imagen.setIcon(rutaDos);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == bioseguridad) {
            descripcion.setText("");
            bioseguridad.setBackground(Color.RED);
            imagen.setIcon(null);
        }
        if (e.getSource() == normal) {
            descripcion.setText("");
            normal.setBackground(Color.red);
            imagen.setIcon(null);

        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

}
