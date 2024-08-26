package servicio;

import modelo.Cliente;
import modelo.CategoríaEnum;
import java.util.ArrayList;

public class ClienteServicio {
    private ArrayList<Cliente> listaClientes;

    // Constructor
    public ClienteServicio(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    // Método para listar clientes
    public void listarClientes() {
        if (listaClientes.isEmpty()) {
            System.out.println("No hay clientes");
        } else {
            for (Cliente cliente : listaClientes) {
                System.out.println("Datos del cliente: ");
                System.out.println("Nombre: " + cliente.getNombreCliente());
                System.out.println("Apellido: " + cliente.getApellidoCliente());
                System.out.println("RUN: " + cliente.getRunCliente());
                System.out.println("Año activo: " + cliente.getYearCliente());
                System.out.println("Categoría: " + cliente.getCategoria()); // Mostrar categoría
                System.out.println();
            }
        }
    }

    // Método para agregar cliente a la lista
    public void agregarCliente(String nombreCliente, String apellidoCliente, String runCliente, String yearCliente, CategoríaEnum categoría) {
        Cliente cliente = new Cliente(nombreCliente, apellidoCliente, runCliente, yearCliente, categoría);
        listaClientes.add(cliente);
        System.out.println("Cliente agregado exitosamente: " + cliente);
    }

    // Método para editar un cliente existente por su runCliente
    public boolean editarClientePorRun(String runCliente, String nuevoNombre, String nuevoApellido, String nuevoRun, String nuevoYear, CategoríaEnum nuevaCategoría) {
        boolean clienteEncontrado = false;

        for (Cliente cliente : listaClientes) {
            if (cliente.getRunCliente().equals(runCliente)) {
                cliente.setNombreCliente(nuevoNombre);
                cliente.setApellidoCliente(nuevoApellido);
                cliente.setRunCliente(nuevoRun);
                cliente.setYearCliente(nuevoYear);
                cliente.setCategoria(nuevaCategoría); // Actualizar categoría
                System.out.println("Cliente editado exitosamente: " + cliente);
                clienteEncontrado = true;
                break;
            }
        }

        if (!clienteEncontrado) {
            System.out.println("No se encontró un cliente con el RUN: " + runCliente);
        }
        return clienteEncontrado;
    }

    // Getter listaClientes
    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }
}
