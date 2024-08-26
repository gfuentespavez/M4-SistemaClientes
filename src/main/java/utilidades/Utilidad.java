package utilidades;

public class Utilidad {

    // Método para limpiar la pantalla
    public static void limpiarPantalla() {
        try {
            // Limpiar la pantalla para sistemas basados en Unix (Linux, macOS)
            if (System.getProperty("os.name").toLowerCase().contains("win")) {
                // Comando para Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Comando para sistemas basados en Unix (Linux, macOS)
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            System.err.println("No se pudo limpiar la pantalla.");
            e.printStackTrace();
        }
    }

    // Método para pausar la ejecución del programa
    public static void esperar(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException e) {
            System.err.println("Interrupción durante la espera.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        System.out.println("Limpiando pantalla en 3 segundos...");
        esperar(3);  // Espera de 3 segundos
        limpiarPantalla();  // Limpia la pantalla
        System.out.println("Pantalla limpiada.");
    }
}