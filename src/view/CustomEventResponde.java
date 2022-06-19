package view;

/**
 * AUTOR:EDWAR JAIR GAONA Y JUAN SEBASTIAN SUAREZ FECHA:2/11/2020 DESCRIBCION:
 * SE ENCARGA DE UNIR EL CONTROLADOR CON NUESTRA IOMANAGER
 *
 */
public interface CustomEventResponde {
    
 public void cambioEscudos(String local,String visitante);
         
    public void cambioTipoPartido();

    public void mensajesVista(String mensaje);

    public void cargarPanelCovid();

    public void cargarPanelNormal();

    public void panelComida(int numero);

    public void mensajeComida(String mensaje);

    public void cargarPanelAtencion(int numero);

    public void cargarPanelEquipos();
    
    public void cambiarVerificado(boolean verificado);
    
    public void panelCargar();
}
