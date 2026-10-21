public interface IFiltro {

    public String getNombreFiltro();

    public int getPrioridad();

    public boolean validarAplicacion(String texto);

    public String obtenerTextoOriginal(String textoFiltrado);  
    
    public String aplicarFiltro(String textoOriginal);

    public String explicacionDeFiltro();

}
