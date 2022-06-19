
package view;

/**
 * AUTOR:EDWAR JAIR GAONA Y JUAN SEBASTIAN SUAREZ FECHA:2/11/2020 
 * DESCRIBCION: ESTEA INTERFAZ PERMITE COMUNICAR LAS CLASES PANELES
 * CON EL CONTROLADOR
 *
 */
public interface CustomEvent {
    
    public void cambioPanel();

    public void cambiarTipoPartido(String local,String visitante);

    public void cargarMatriz(int num);

    public void llamarAtencion(int numero);

    public void llamarComida(int numero);

    public void valorComida(int i);

    public void llamarVolver();

    public void llamarsubTotal(String ventas);

    public void mensajePrecio(int i);

    public void retornarGuardado(int x, int y);

    public void cargarFactura(String ventas, int cambio);

    public void cargarFacturaTribunas(int i, int tribuna);

    public void cargarFacturaAtencion(String comentario, int cambio);
    
    public void llamarVerificarPartido();
    
    public void llamarCargado();
}
