package view.otrosServicios;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import view.CustomEvent;

/**
 * AUTOR:EDWAR JAIR GAONA Y JUAN SEBASTIAN SUAREZ FECHA:2/11/2020 DESCRIBCION:
 * CARGARA LOS COMPONENTES DEL PANEL DE ATENCION AL CLIENTE
 *
 */
public class AtencionAlCliente extends JPanel implements MouseListener {

    //VARIABLES GLOBALES

    private CustomEvent objetoCustom;
    private JButton envio;
    private JTextField campoDeTexto;
    private JTextField pregunta;
    private ImageIcon imagenPregunta;
    private JLabel imagen;
    private int cambio;
    private String comentario;

    //METODO CONSTRUCTOR
    public AtencionAlCliente() {
        imagenPregunta = new ImageIcon("src\\imagenes\\pregunta.gif");
        setLayout(null);

        //CRERA UN BOTON QUE ENVIARA EL MENSAJE DEL USUARIO
        envio = new JButton("ENVIO");
        envio.setBounds(350, 450, 100, 30);
        envio.setBackground(Color.red);
        envio.addMouseListener(this);
        add(envio);
        //CARGARA UNA IMAGEN QUE SE MOSTRARA EN EL PANEL
        imagen = new JLabel();
        imagen.setBounds(300, 0, 300, 300);
        imagen.setIcon(imagenPregunta);
        add(imagen);
        //MOSTRARA UN CUADRO DE TEXTO PARA QUE SE ENTIENDA LOP QUE SE DEBE ESCRIBIR EL EN CUADRO DE TEXTO
        pregunta = new JTextField("QUE CAMBIO PODRIAMOS REALIZAR PARA MEJOR NUESTRO SERVICIO");
        pregunta.setEnabled(false);
        pregunta.setHorizontalAlignment(JTextField.CENTER);
        pregunta.setBounds(100, 270, 600, 30);
        add(pregunta);
        //CARGARA EL MENSAJE QUE EL USUARIO SEA ENVIAR
        campoDeTexto = new JTextField();
        campoDeTexto.setBounds(100, 320, 600, 90);
        campoDeTexto.setHorizontalAlignment(JTextField.CENTER);
        add(campoDeTexto);
    }

    // CAMBIA EL VALOR DEL NUMERO PARA SABER A QUE PANEL DEBE REDIRIGIRSE AL ACABA EL MENSAJE

    public void opciones(int numero) {
        cambio = numero;
    }

    //GET Y SET DEL OBJETO CUSTOM EVENT
    public CustomEvent getObjetoCustom() {
        return objetoCustom;
    }

    public void setObjetoCustom(CustomEvent objetoCustom) {
        this.objetoCustom = objetoCustom;
    }

    //REALIZA LAS ACCIONES DEPENDIENDO DE LO QUE EL USUARIO DESEE
    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == envio) {
            comentario = campoDeTexto.getText();
            objetoCustom.cargarFacturaAtencion(comentario, cambio);
        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == envio) {
            envio.setBackground(Color.white);
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == envio) {
            envio.setBackground(Color.red);
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

}
