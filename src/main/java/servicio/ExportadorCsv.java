package servicio;

import modelo.Cliente;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ExportadorCsv extends Exportador {

    @Override
    public ArrayList<Cliente> cargarDatos(String fileName) {
        return null;  // No se implementa en esta clase
    }

    // Implementación del método exportar que acepta solo la lista de clientes
    @Override
    public void exportar(ArrayList<Cliente> listaClientes) {
        // Aquí podrías lanzar una excepción o implementar un comportamiento por defecto
        throw new UnsupportedOperationException("Este método requiere un nombre de archivo.");
    }

    // Implementación del método exportar que acepta la lista de clientes y el nombre del archivo
    @Override
    public void exportar(ArrayList<Cliente> listaClientes, String nombreArchivoCsv) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivoCsv))) {
            writer.write("Nombre,Apellido,RUN,Año,Categoría");
            writer.newLine();

            for (Cliente cliente : listaClientes) {
                writer.write(cliente.getNombreCliente() + "," +
                        cliente.getApellidoCliente() + "," +
                        cliente.getRunCliente() + "," +
                        cliente.getYearCliente() + "," +
                        cliente.getCategoria());
                writer.newLine();
            }
            System.out.println("Archivo exportado exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al exportar el archivo: " + e.getMessage());
        }
    }
}