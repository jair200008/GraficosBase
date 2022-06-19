package view.otrosServicios;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import view.CustomEvent;

/**
 * AUTOR:EDWAR JAIR GAONA Y JUAN SEBASTIAN SUAREZ FECHA:2/11/2020 DESCRIBCION:
 * CARGA EL MENU DE COMIDA QUE EL USUARIO PUEDECOMPRAR
 *
 */
public class Comidas extends JPanel implements  MouseListener{
    //VARIABLES GLOBALES
    private ImageIcon[] menu;
    private ImageIcon imagenAtras;
    private JLabel[] imagenes;
    private JCheckBox[] pedidos;
    private JButton comprar;
    private JTextField descripcion;
    private CustomEvent objetoCustom;
    private String imprimir;
    private JButton volver;
    private int cambio;
    //METODO CONSTRUCTOR
    public Comidas() {
        setLayout(null);
        imagenes = new JLabel[7];
        menu = new ImageIcon[7];
        pedidos= new JCheckBox[7];
        
        imagenAtras = new ImageIcon("src/imagenes/volver.png");
        menu[0] = new ImageIcon("src/imagenes/comidas/hamburguesas.png");
        menu[1] = new ImageIcon("src/imagenes/comidas/perros.png");
        menu[2] = new ImageIcon("src/imagenes/comidas/papas.png");
        menu[3] = new ImageIcon("src/imagenes/comidas/paquetes.png");
        menu[4] = new ImageIcon("src/imagenes/comidas/gaseosa.png");
        menu[5] = new ImageIcon("src/imagenes/comidas/agua.png");
        menu[6] = new ImageIcon("src/imagenes/comidas/jugo.png");

        imagenesComida();
        cuadrosChequeo();
        boton();
    }
    //CAMIALA VARIABLE PARA SABER A QUE PANEL DEBE REDIRIGIRSE AL ACABAR SU PROCESO
    public void volverTipoPanel(int numero){
        cambio=numero;
        
    } 
    //CARGA LOS COMPONENTES AL PANEL COMIDAS
    public void boton(){
        //MOSTRARA EL VALOR DE LOS PRODUCTOS
        descripcion=new JTextField();
        descripcion.setBounds(150,430,500,30);
        descripcion.setHorizontalAlignment(JTextField.CENTER);
        descripcion.setEditable(false);
        add(descripcion);
        //CREARA UN BOTON PARA VOLVERAL PAEL ATERIOR
        volver = new JButton();
        volver.setBounds(5, 5, 100, 50);
        volver.setIcon(new ImageIcon(imagenAtras.getImage().getScaledInstance(volver.getWidth(), volver.getHeight(), Image.SCALE_SMOOTH)));
        volver.setBackground(Color.BLUE);
        volver.setOpaque(false);
        volver.setBorderPainted(false);
        volver.addMouseListener(this);
        add(volver);

        //CRERAR UN BOTO PARA REALIZAR LA COMPRA
        comprar=new JButton("COMPRA");
        comprar.setBounds(340,500,100,30);
        comprar.addMouseListener(this);
        add(comprar);
    }
    //CARGARALAS IMAGENES DE LOS PRODUCTOS QUESEVEDENENEL ESTADIO
    public void imagenesComida() {

        int x = 30;
        int y = 50;
        for (int i = 0; i < 7; i++) {
            if (i == 4) {
                y = 250;
                x = 130;
            }
            imagenes[i] = new JLabel();
            imagenes[i].setBounds(x, y, 150, 150);
            imagenes[i].setIcon(new ImageIcon(menu[i].getImage().getScaledInstance(imagenes[i].getWidth(), imagenes[i].getHeight(), Image.SCALE_SMOOTH)));
            add(imagenes[i]);
            x = x + 200;
        }

    }
    //CREARA CUADROS DECHEQUEO PARAQUE EL USUARIO ESCOJA QUE DESEA COMPRAR
    
    public void cuadrosChequeo(){
        for(int i=0;i<7;i++){
            pedidos[i]=new JCheckBox();
        }
        pedidos[0].setText("HAMBURGUESAS");
        pedidos[1].setText("PERROS");
        pedidos[2].setText("PAPAS");
        pedidos[3].setText("PAQUETES");
        pedidos[4].setText("GASEOSAS");
        pedidos[5].setText("AGUA");
        pedidos[6].setText("JUGOS");
        
        int x=50;
        int y=200;
         for(int i=0;i<7;i++){
             if(i==4){
                 y=400;
                 x=150;
             }
            pedidos[i].setBounds(x,y,130,20);
            pedidos[i].setBackground(Color.BLUE);
            pedidos[i].setOpaque(false);
            pedidos[i].addMouseListener(this);
            add(pedidos[i]);
            x=x+200;
        }       

    }
    //RESIVE LOS MENSAJE QUE EL USUARIO VA VISUALIZAR POR PANTALLA
    public void impresiones(String mensaje) {
        imprimir = mensaje;
    }
    
    //GET Y SET DEL OBJETO CUSTOM EVENT
    public CustomEvent getObjetoCustom() {
        return objetoCustom;
    }

    public void setObjetoCustom(CustomEvent objetoCustom) {
        this.objetoCustom = objetoCustom;
    }

    //SE ENCARGA DE REALIZAR LAS ACCIONES QUE USUARIO DESEA
    @Override
    public void mousePressed(MouseEvent e) {
        String ventas="";
        if(e.getSource()==comprar){
            for(int i=0;i<7;i++){
                if(pedidos[i].isSelected()){
                    ventas=ventas+pedidos[i].getText()+"/";
                }
            }
            objetoCustom.cargarFactura(ventas,cambio);
        
        }
        if(e.getSource()==volver){
            objetoCustom.cargarMatriz(cambio);
        }
    }


    @Override
    public void mouseEntered(MouseEvent e) {
        String ventas="";
        for(int i=0;i<7;i++){
            if(e.getSource()==pedidos[i]){
               objetoCustom.valorComida(i);
               descripcion.setText(imprimir);
            }
        }
        if(e.getSource()==comprar){
            for(int i=0;i<7;i++){
                if(pedidos[i].isSelected()){
                    ventas=ventas+pedidos[i].getText()+"/";
                }
            }
            objetoCustom.llamarsubTotal(ventas);
        
            descripcion.setText(imprimir);
        }
        if(e.getSource()==volver){
            
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        for (int i = 0; i < 7; i++) {
            if (e.getSource() == pedidos[i]) {
                objetoCustom.valorComida(7);
                descripcion.setText(imprimir);
            }
        }
        if(e.getSource()==comprar){
                objetoCustom.valorComida(7);
                descripcion.setText(imprimir);            
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }
}
