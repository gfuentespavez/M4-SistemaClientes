package servicio;

import modelo.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteServicio {
    private List<Cliente> listaClientes;

    //Constructor
    public ClienteServicio(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    //Método para listar clientes
    public void listarClientes() {
        if(listaClientes.isEmpty()) {
            System.out.println("No hay clientes");
        } else {
            for (Cliente cliente : listaClientes) {
                System.out.println("Datos del cliente: ");
                System.out.println("Nombre: " + cliente.getNombreCliente());
                System.out.println("Apellido: " + cliente.getApellidoCliente());
                System.out.println("RUN" + cliente.getRunCliente());
                System.out.println("Años activo: " + cliente.getYearCliente());
            }
        }
    }

    //Método para agregar cliente a la lista
    public void agregarCliente(String nombreCliente, String apellidoCliente, String runCliente, String yearCliente) {
        Cliente cliente = new Cliente(nombreCliente, apellidoCliente, runCliente, yearCliente);
        listaClientes.add(cliente);
        System.out.println("Cliente agregado exitosamente" + cliente);
    }

    //Método para editar un cliente existente
    public void editarCliente(int index, String nombreCliente, String apellidoCliente, String runCliente, String yearCliente) {
        if (index >= 0 && index < listaClientes.size()) {
            Cliente cliente = listaClientes.get(index);
            cliente.setNombreCliente(nombreCliente);
            cliente.setApellidoCliente(apellidoCliente);
            cliente.setRunCliente(runCliente);
            cliente.setYearCliente(yearCliente);
            System.out.println("Cliente editado exitosamente" + cliente);
        } else {
            System.out.println("No se encontro el nombre del cliente");
        }
    }
    //Getter listaCliente
    public List<Cliente> getListaClientes() {
        return listaClientes;
    }
}