package servicio;

import modelo.Cliente;

import java.util.ArrayList;

public abstract class Exportador {
    // Método para cargar datos desde un archivo
    public abstract ArrayList<Cliente> cargarDatos(String fileName);

    // Método abstracto para exportar con un solo parámetro
    public abstract void exportar(ArrayList<Cliente> listaClientes);

    // Método abstracto para exportar con dos parámetros
    public abstract void exportar(ArrayList<Cliente> listaClientes, String nombreArchivo);
}
