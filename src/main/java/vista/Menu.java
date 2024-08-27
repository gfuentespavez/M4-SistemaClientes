package vista;

import servicio.*;
import modelo.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private ClienteServicio clienteServicio;
    private ArchivoServicio archivoServicio;
    private ExportadorCsv exportadorCsv;
    private ExportarTxt exportarTxt;
    private Scanner sc;

    // Constructor con parámetros
    public Menu(ClienteServicio clienteServicio, ArchivoServicio archivoServicio, ExportadorCsv exportadorCsv, ExportarTxt exportarTxt) {
        this.clienteServicio = clienteServicio;
        this.archivoServicio = archivoServicio;
        this.exportadorCsv = exportadorCsv;
        this.exportarTxt = exportarTxt;
        this.sc = new Scanner(System.in);
    }

    // Mostrar menú
    public void iniciarMenu() {
        int opcion;
        do {
            System.out.println("-----------------");
            System.out.println("Bienvenidos al sistema de gestión de clientes de Pastelería Bon Bon Jovi.");
            System.out.println("-----------------");
            System.out.println("Menú: ");
            System.out.println("1. Listar clientes.");
            System.out.println("2. Agregar clientes");
            System.out.println("3. Modificar clientes");
            System.out.println("4. Importar clientes");
            System.out.println("5. Exportar datos");
            System.out.println("0. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    listarClientes();
                    break;
                case 2:
                    agregarCliente();
                    break;
                case 3:
                    editarCliente();
                    break;
                case 4:
                    importarDatos();
                    break;
                case 5:
                    exportarDatos();
                    break;
                case 0:
                    terminarPrograma();
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    private void listarClientes() {
        clienteServicio.listarClientes();
    }
    //Método para agregar un cliente OK
    private void agregarCliente() {
        String nombre, apellido, run, year = "", categoria;
        CategoríaEnum categoríaEnum;

        System.out.println("------------------------");
        System.out.println("Agregar nuevos clientes a Bon Bon Jovi.");
        System.out.println("------------------------");
        System.out.print("Ingrese el nombre del cliente: ");
        nombre = sc.nextLine();

        System.out.print("Ingrese el apellido del cliente: ");
        apellido = sc.nextLine();

        // Solicitar el RUN hasta que sea válido
        while (true) {
            System.out.print("Ingrese el RUN del cliente. Sin puntos ni guión y con dígito verificador: ");
            run = sc.nextLine();

            try {
                // Intentar crear un cliente con el RUN ingresado
                Cliente clientePrueba = new Cliente(nombre, apellido, run, year, CategoríaEnum.Activo); // El año y categoría se asignan temporalmente
                break; // Si no se lanza excepción, el RUN es válido
            } catch (IllegalArgumentException e) {
                System.out.println("RUN ingresado no es válido. Intente nuevamente.");
            }
        }

        // Solicitar el año del cliente
        System.out.print("Ingrese el año del cliente: ");
        year = sc.nextLine();

        // Solicitar la categoría del cliente
        System.out.print("Ingrese la categoría (Activo/Inactivo): ");
        categoria = sc.nextLine();
        try {
            categoríaEnum = CategoríaEnum.valueOf(categoria.trim());
        } catch (IllegalArgumentException e) {
            System.out.println("Categoría no válida. Asignando categoría por defecto.");
            categoríaEnum = CategoríaEnum.Inactivo; // Asignar una categoría por defecto o manejar de otra manera
        }

        // Agregar el cliente a la lista
        clienteServicio.agregarCliente(nombre, apellido, run, year, categoríaEnum);
        System.out.println("Cliente agregado exitosamente.");
    }

    //Método para modificar un cliente OK
    private void editarCliente() {
        String run;
        boolean runValido = false;
        do {
            System.out.println("------------------------");
            System.out.println("Modificar datos de clientes en Bon Bon Jovi.");
            System.out.println("------------------------");
            System.out.print("Ingrese el RUN del cliente a editar. Sin puntos ni guión y con dígito verificador: ");
            run = sc.nextLine();
            if (isValidRun(run)) {
                runValido = true;
            } else {
                System.out.println("RUN ingresado no es válido. Intente nuevamente.");
            }
        } while (!runValido);

        System.out.print("Ingrese el nuevo nombre: ");
        String nuevoNombre = sc.nextLine();
        System.out.print("Ingrese el nuevo apellido: ");
        String nuevoApellido = sc.nextLine();

        String nuevoRun;
        boolean nuevoRunValido = false;
        do {
            System.out.print("Ingrese el nuevo RUN del cliente. Sin puntos ni guión y con dígito verificador: ");
            nuevoRun = sc.nextLine();
            if (isValidRun(nuevoRun)) {
                nuevoRunValido = true;
            } else {
                System.out.println("Nuevo RUN ingresado no es válido. Intente nuevamente.");
            }
        } while (!nuevoRunValido);

        System.out.print("Ingrese el nuevo año: ");
        String nuevoYear = sc.nextLine();
        System.out.print("Ingrese la nueva categoría (Activo/Inactivo): ");
        String categoria = sc.nextLine();
        CategoríaEnum categoríaEnum;
        try {
            categoríaEnum = CategoríaEnum.valueOf(categoria.trim());
        } catch (IllegalArgumentException e) {
            System.out.println("Categoría no válida. Asignando categoría por defecto.");
            categoríaEnum = CategoríaEnum.Inactivo; // O asignar el valor por defecto que prefieras
        }

        boolean clienteEditado = clienteServicio.editarClientePorRun(run, nuevoNombre, nuevoApellido, nuevoRun, nuevoYear, categoríaEnum);
        if (clienteEditado) {
            System.out.println("Cliente editado exitosamente.");
        } else {
            System.out.println("No se encontró un cliente con el RUN: " + run);
        }
    }


    private void importarDatos() {
        System.out.println("------------------------");
        System.out.println("Importar nuevos clientes a Bon Bon Jovi.");
        System.out.println("------------------------");
        System.out.print("Ingrese el nombre del archivo CSV para importar: ");
        String nombreArchivoCsv = sc.nextLine();

        ArrayList<Cliente> listaClientes = archivoServicio.cargarDatos(nombreArchivoCsv);
        clienteServicio = new ClienteServicio(listaClientes);
        System.out.println("Datos importados exitosamente.");
    }


    //Método exportar datos
    private void exportarDatos() {

        System.out.println("------------------------");
        System.out.println("Exportar datos de clientes panadería Bon Bon Jovi.");
        System.out.println("------------------------");
        System.out.print("Ingrese el nombre para el archivo CSV: ");
        String nombreArchivoCsv = sc.nextLine();
        exportadorCsv.exportar(clienteServicio.getListaClientes(), nombreArchivoCsv);

        System.out.print("Ingrese el nombre para el archivo TXT: ");
        String nombreArchivoTxt = sc.nextLine();
        exportarTxt.exportar(clienteServicio.getListaClientes(), nombreArchivoTxt);

        System.out.println("Datos exportados exitosamente.");
    }


    private void terminarPrograma() {
        System.out.println("------------------------");
        System.out.println("¡Hasta luego!");
        System.out.println("------------------------");
        sc.close();
    }

    //Método isValidRun - editarCliente
    private boolean isValidRun(String run) {
        if (run == null || !run.matches("\\d{7,8}[Kk0-9]")) {
            return false;
        }
        // Implementar la validación del dígito verificador aquí, si es necesario
        return true;
    }

    // Método main
// Método main
    public static void main(String[] args) {
        // Crear instancias de los servicios necesarios
        ClienteServicio clienteServicio = new ClienteServicio(new ArrayList<>()); // Asumiendo que empieza con una lista vacía
        ArchivoServicio archivoServicio = new ArchivoServicio();

        ExportadorCsv exportadorCsv = new ExportadorCsv(); // Constructor sin argumentos
        ExportarTxt exportarTxt = new ExportarTxt(); // Constructor sin argumentos

        // Crear e iniciar el menú
        Menu menu = new Menu(clienteServicio, archivoServicio, exportadorCsv, exportarTxt);
        menu.iniciarMenu();
    }
}