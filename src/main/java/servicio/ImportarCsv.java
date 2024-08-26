package servicio;

import modelo.Cliente;
import modelo.CategoríaEnum;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ImportarCsv {
    private String nombreArchivo;

    public ImportarCsv(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public ArrayList<Cliente> importar() {
        ArrayList<Cliente> listaClientes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 5) { // Asegúrate de que haya 5 campos en lugar de 4
                    String nombre = datos[0];
                    String apellido = datos[1];
                    String run = datos[2];
                    String year = datos[3];
                    CategoríaEnum categoría;

                    try {
                        categoría = CategoríaEnum.valueOf(datos[4].trim()); // Leer y asignar la categoría
                    } catch (IllegalArgumentException e) {
                        System.out.println("Categoría no válida en el archivo: " + datos[4]);
                        continue; // Salta a la siguiente línea en caso de error
                    }

                    Cliente cliente = new Cliente(nombre, apellido, run, year, categoría);
                    listaClientes.add(cliente);
                } else {
                    System.out.println("Formato de datos inválido en línea: " + linea);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + nombreArchivo);
        }
        return listaClientes;
    }
}