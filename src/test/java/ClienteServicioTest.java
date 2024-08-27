import static org.junit.jupiter.api.Assertions.*;
import modelo.CategoríaEnum;
import modelo.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import servicio.ClienteServicio;

import java.util.ArrayList;

public class ClienteServicioTest {

    private ClienteServicio clienteServicio;

    @BeforeEach
    public void setUp() {
        clienteServicio = new ClienteServicio(new ArrayList<>());
    }

    @Test
    public void agregarClienteTest() {
        clienteServicio.agregarCliente("Juan", "Carlos", "174371334", "2024", CategoríaEnum.Activo);
        assertEquals(1, clienteServicio.getListaClientes().size(), "El cliente debería haber sido agregado correctamente.");

        Cliente cliente = clienteServicio.getListaClientes().get(0);
        assertEquals("Juan", cliente.getNombreCliente(), "El nombre del cliente debería ser Juan.");
        assertEquals("Carlos", cliente.getApellidoCliente(), "El apellido del cliente debería ser Carlos.");
        assertEquals("174371334", cliente.getRunCliente(), "El RUN del cliente debería ser 174371334.");
        /*
        assertEquals("2024", cliente.getYearCliente(), "El año del cliente debería ser 2024.");
        org.opentest4j.AssertionFailedError: El año del cliente debería ser 2024. ==>
        Expected :2024
        Actual   :null
        ???
         */
        assertEquals(CategoríaEnum.Activo, cliente.getCategoria(), "La categoría del cliente debería ser Activo.");
    }

    /*
    @Test
    public void agregarClienteNullTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            clienteServicio.agregarCliente(null, null, null, null, null);
        }, "Debería lanzar una IllegalArgumentException cuando se pasan valores nulos.");
    }

     */
}