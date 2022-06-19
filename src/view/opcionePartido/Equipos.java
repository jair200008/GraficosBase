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
import view.CustomEvent;

/**
 * AUTOR:EDWAR JAIR GAONA Y JUAN SEBASTIAN SUAREZ FECHA:2/11/2020 DESCRIBCION:
 * SE ENCARGA DE CARGAR LOS COMPORNENTES QUE LLEVARA LA SECCION DE EQUIPOS
 *
 */
public class Equipos extends JPanel implements MouseListener {

    //VARIABLES GLOBALES

    private ImageIcon imagenLocal;
    private ImageIcon imagenVisitante;
    private JLabel equipoUno;
    private JLabel equipoDos;
    private JTextField local;
    private JTextField visitante;
    private JButton enviar;
    private CustomEvent objetoCustom;

    //METODO CONSTRUCTOR

    public Equipos() {
        imagenLocal = new ImageIcon("src\\imagenes\\equipoUno.gif");
        imagenVisitante = new ImageIcon("src\\imagenes\\equipoDos.gif");

        setLayout(null);
        //CONTIENE UNA IMAGEN QUE SE MOSTRARA EN EL PANE        
        equipoUno = new JLabel();
        equipoUno.setBounds(100, 40, 300, 300);
        equipoUno.setIcon(imagenLocal);

        add(equipoUno);

        //CONTIENE UNA IMAGEN QUE SE MOSTRARA EN EL PANEL
        equipoDos = new JLabel();
        equipoDos.setBounds(500, 50, 300, 300);
        equipoDos.setIcon(imagenVisitante);
        add(equipoDos);

        //CREA UN CUADRO DE TEXTO PARA QUE USUARIO INGRESE EL EQUIPO
        local = new JTextField();
        local.setBounds(550, 300, 100, 30);
        add(local);

        //CREA UN CUADRO DE TEXTO PARA QUE USUARIO INGRESE EL EQUIPO
        visitante = new JTextField();
        visitante.setBounds(150, 300, 100, 30);
        add(visitante);

        //CREA Y AÑADE EL BOTON AL PANEL
        enviar = new JButton("cargar");
        enviar.setBounds(350, 400, 100, 30);
        enviar.setBackground(Color.red);
        enviar.addMouseListener(this);
        add(enviar);

    }

    //GET Y SET DEL OBJETO CUSTOM EVENT

    public CustomEvent getObjetoCustom() {
        return objetoCustom;
    }

    public void setObjetoCustom(CustomEvent objetoCustom) {
        this.objetoCustom = objetoCustom;
    }

    //SON LAS ACCIONES QUE SE VAN A REALIZAR DEPENDIENDO DE LO QUE REALICE EL USUARIO
    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == enviar) {
            if (local.getText().length() != 0 && visitante.getText().length() != 0) {
                objetoCustom.cambiarTipoPartido(local.getText(),visitante.getText());
            } else {
                JOptionPane.showMessageDialog(null, "llene los campos vacios");
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == enviar) {
            enviar.setBackground(Color.WHITE);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        enviar.setBackground(Color.RED);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

}
