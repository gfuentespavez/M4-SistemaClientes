package servicio;

import modelo.Cliente;
import modelo.CategoríaEnum;

import java.io.*;
import java.util.ArrayList;

public class ArchivoServicio extends Exportador {

    // Método para cargar datos desde un archivo
    @Override
    public ArrayList<Cliente> cargarDatos(String fileName) {
        ArrayList<Cliente> listaClientes = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                // Suponiendo que los datos en cada línea están separados por comas
                String[] datos = linea.split(",");

                // Crear un objeto Cliente con los datos y agregarlo a la lista
                if (datos.length == 5) { // Asegúrate de que haya 5 campos
                    String nombre = datos[0];
                    String apellido = datos[1];
                    String run = datos[2];
                    String year = datos[3];
                    CategoríaEnum categoría;

                    // Leer y asignar la categoría
                    try {
                        categoría = CategoríaEnum.valueOf(datos[4].trim());
                    } catch (IllegalArgumentException e) {
                        System.out.println("Categoría no válida en el archivo: " + datos[4]);
                        continue; // Salta a la siguiente línea en caso de error
                    }

                    Cliente cliente = new Cliente(nombre, apellido, run, year, categoría);
                    listaClientes.add(cliente);
                }
            }
            System.out.println("Datos cargados exitosamente desde " + fileName);
        } catch (IOException e) {
            System.out.println("Error al cargar los datos: " + e.getMessage());
        }

        return listaClientes;
    }

    @Override
    public void exportar(ArrayList<Cliente> listaClientes) {

    }

    // Implementación del método exportar heredado de Exportador
    @Override
    public void exportar(ArrayList<Cliente> listaClientes, String nombreArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            // Escribir encabezado del archivo
            writer.write("Nombre,Apellido,RUN,Año,Categoría");
            writer.newLine();

            // Escribir los datos de cada cliente
            for (Cliente cliente : listaClientes) {
                writer.write(cliente.getNombreCliente() + "," +
                        cliente.getApellidoCliente() + "," +
                        cliente.getRunCliente() + "," +
                        cliente.getYearCliente() + "," +
                        cliente.getCategoria()); // Incluye Categoría en la línea del cliente
                writer.newLine();
            }
            System.out.println("Archivo exportado exitosamente a " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al exportar el archivo: " + e.getMessage());
        }
    }
}
