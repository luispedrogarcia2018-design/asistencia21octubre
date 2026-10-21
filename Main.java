import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el texto para aplicar el filtro:");
        String texto = scanner.nextLine();
        System.out.println("Texto ingresado: " + texto);

        IFiltro filtro = new FiltroCensurador(texto);

        System.out.println("Filtro: " + filtro.getNombreFiltro());
        System.out.println("Prioridad: " + filtro.getPrioridad());
        System.out.println("Explicacion: " + filtro.explicacionDeFiltro());

        if (filtro.validarAplicacion(texto)) {
            String textoFiltrado = filtro.aplicarFiltro(texto);
            System.out.println("Texto filtrado: " + textoFiltrado);
            System.out.println("Texto original: " + filtro.obtenerTextoOriginal(textoFiltrado));
        } else {
            System.out.println("El filtro no se puede aplicar a este texto.");
        }

        scanner.close();
    }

}
