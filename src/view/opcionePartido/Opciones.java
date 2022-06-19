package view.opcionePartido;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import view.CustomEvent;

/**
 * AUTOR:EDWAR JAIR GAONA Y JUAN SEBASTIAN SUAREZ FECHA:2/11/2020 DESCRIBCION:
 * CARGA LOS COMPONENTES DE LA CLASE OPCIONES SE ENCARGA DE SI EL USUARIO DESEA
 * CREAR UN NUEVO PARTIDO O CARGAR UNO PARTIDO
 *
 */
public class Opciones extends JPanel implements MouseListener {

    //VARIABLES GLOBALES

    private CustomEvent objetoCustom;
    private JButton crear;
    private JButton cargar;
    private ImageIcon rutaUno;
    private ImageIcon rutaDos;
    private ImageIcon imagenBotones;
    private JLabel imagen;
    private JTextField descripcion;
    private boolean cargado;

    //METODO CONSTRUCTOR
    public Opciones() {
        cargado=false;
        rutaUno = new ImageIcon("src\\imagenes\\nuevo.gif");
        rutaDos = new ImageIcon("src\\imagenes\\cargar.gif");
        imagenBotones=new ImageIcon("src\\imagenes\\botones.png");

        setBorder(new TitledBorder(null, "OPCIONES", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
        setLayout(null);

        //CREAR UN BOTON SERVIRA PARA CREAR UN PARTIDO
        crear = new JButton("CREAR");
        crear.setBounds(100, 400, 150, 30);
        crear.setBackground(Color.red);
        crear.addMouseListener(this);
        add(crear);
        //CREAR UN BOTON SERVIRA PARA CARGAR UN PARTIDO
        cargar = new JButton("CARGAR");
        cargar.setBounds(500, 400, 150, 30);
        cargar.setBackground(Color.red);
        cargar.addMouseListener(this);
        add(cargar);

        //CREA UN CUADRO DE TEXTO MOSTRARA LA DESCRIPCION DE LO QUE HARA CADA BOTON
        descripcion = new JTextField();
        descripcion.setBounds(100, 350, 550, 30);
        descripcion.setHorizontalAlignment(JTextField.CENTER);
        descripcion.setEditable(false);
        add(descripcion);

        //CARGA UNA IMAGEN QUE SE MOSTRARA ALTES DE TOMAR UNA OPCION
        imagen = new JLabel();
        imagen.setBounds(220, 50, 280, 280);
        add(imagen);

    }
    
    public void verificado(boolean verificar){
        cargado=verificar;
    }

    //GET Y SET DEL OBJETO CUSTOM EVENT
    public CustomEvent getObjetoCustom() {
        return objetoCustom;
    }

    public void setObjetoCustom(CustomEvent objetoCustom) {
        this.objetoCustom = objetoCustom;
    }

    //REALIZARA LAS UNA ACCION DEPENDIENDO DE LO QUE EL USUARIO DESEE
    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == crear) {
            objetoCustom.cambioPanel();

        }
        if (e.getSource() == cargar) {
                objetoCustom.llamarCargado();

        }

        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == crear) {
            descripcion.setText("SI TIENE UN PARTIDO ANTERIORMENTE REGISTRADO, SE BORRARAN LOS DATOS");
            crear.setBackground(Color.white);
            imagen.setIcon(rutaUno);
        }
        if (e.getSource() == cargar) {
            descripcion.setText("SI TIENE UN PARTIDO REGISTRADO, SE CARGARAN LOS ASIENTOS OCUPADOS");
            cargar.setBackground(Color.WHITE);
            imagen.setIcon(rutaDos);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == crear) {
            descripcion.setText("");
            crear.setBackground(Color.RED);
            imagen.setIcon(null);
        }
        if (e.getSource() == cargar) {
            descripcion.setText("");
            cargar.setBackground(Color.red);
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
