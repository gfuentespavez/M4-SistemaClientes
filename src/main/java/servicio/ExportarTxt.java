package servicio;

import modelo.Cliente;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ExportarTxt extends Exportador {

    // Constructor
    public ExportarTxt() {
        super();
    }

    @Override
    public ArrayList<Cliente> cargarDatos(String fileName) {
        return null;  // No se implementa en esta clase
    }

    @Override
    public void exportar(ArrayList<Cliente> listaClientes) {

    }

    @Override
    public void exportar(ArrayList<Cliente> listaClientes, String nombreArchivoTxt) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivoTxt))) {
            writer.write("Nombre|Apellido|RUN|Año|Categoría");
            writer.newLine();

            for (Cliente cliente : listaClientes) {
                writer.write(cliente.getNombreCliente() + "|" +
                        cliente.getApellidoCliente() + "|" +
                        cliente.getRunCliente() + "|" +
                        cliente.getYearCliente() + "|" +
                        cliente.getCategoria());
                writer.newLine();
            }
            System.out.println("Archivo exportado exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al exportar el archivo: " + e.getMessage());
        }
    }
}
