import java.util.Comparator;

public class FiltroCensurador implements IFiltro, Comparator<IFiltro>, Comparable<IFiltro> {

    private String[] palabrasCensuradas = {"malo", "tonto", "feo", "prohibido"};
    private String textoOriginal;
    private int prioridad = 15;

    public FiltroCensurador() {
    }

    public FiltroCensurador(String textoOriginal) {
        this.textoOriginal = textoOriginal;
    }

    @Override
    public String getNombreFiltro() {
        return "FiltroCensurador";
    }

    @Override
    public int getPrioridad() {
        return prioridad;
    }

    @Override
    public boolean validarAplicacion(String texto) {
        if (texto == null || texto.equals("")) {
            return false;
        }
        String textoMinusculas = texto.toLowerCase();
        for (int i = 0; i < palabrasCensuradas.length; i++) {
            if (textoMinusculas.contains(palabrasCensuradas[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String obtenerTextoOriginal(String textoFiltrado) {
        return this.textoOriginal;
    }

    @Override
    public String aplicarFiltro(String textoOriginal) {
        this.textoOriginal = textoOriginal;
        String[] palabras = textoOriginal.split(" ");
        String resultado = "";

        for (int i = 0; i < palabras.length; i++) {
            String palabraActual = palabras[i];
            boolean esCensurada = false;

            for (int j = 0; j < palabrasCensuradas.length; j++) {
                if (palabraActual.toLowerCase().contains(palabrasCensuradas[j])) {
                    esCensurada = true;
                    break;
                }
            }

            if (esCensurada) {
                resultado = resultado + "***";
            } else {
                resultado = resultado + palabraActual;
            }

            if (i < palabras.length - 1) {
                resultado = resultado + " ";
            }
        }

        return resultado;
    }

    @Override
    public String explicacionDeFiltro() {
        return "Reemplaza palabras de una lista predefinida por asteriscos.";
    }

    @Override
    public int compare(IFiltro f1, IFiltro f2) {
        if (f1.getPrioridad() > f2.getPrioridad()) {
            return 1;
        } else if (f1.getPrioridad() < f2.getPrioridad()) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public int compareTo(IFiltro otro) {
        if (this.prioridad > otro.getPrioridad()) {
            return 1;
        } else if (this.prioridad < otro.getPrioridad()) {
            return -1;
        } else {
            return 0;
        }
    }

}
