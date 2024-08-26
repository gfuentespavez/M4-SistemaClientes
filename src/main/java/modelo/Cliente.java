package modelo;

import utilidades.RunValidador;

public class Cliente {
    // Atributos
    private String nombreCliente;
    private String apellidoCliente;
    private String runCliente;
    private String yearCliente;
    private CategoríaEnum categoría; //Atributo para la categoría

    // Constructores
    public Cliente(String nombreCliente, String apellidoCliente, String runCliente, String yearClient, CategoríaEnum categoría) {
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        setRunCliente(runCliente);  // Se usa el setter para validar el RUT
        this.yearCliente = yearCliente;
        this.categoría = categoría;
    }

    public Cliente() {
    }

    // Getters y setters
    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getRunCliente() {
        return runCliente;
    }

    public void setRunCliente(String runCliente) {
        // Separar el RUN y el dígito verificador
        String rut = runCliente.substring(0, runCliente.length() - 1);
        char digitoVerificador = runCliente.charAt(runCliente.length() - 1);

        // Validar el RUN usando el método estático de la clase RunValidator
        if (RunValidador.verificarRUT(rut, digitoVerificador)) {
            this.runCliente = runCliente;
        } else {
            throw new IllegalArgumentException("El RUN ingresado no es válido.");
        }
    }

    public String getYearCliente() {
        return yearCliente;
    }

    public void setYearCliente(String yearCliente) {
        this.yearCliente = yearCliente;
    }

    public CategoríaEnum getCategoria() {
        return categoría;
    }

    public void setCategoria(CategoríaEnum categoría) {
        this.categoría = categoría;
    }

    // Método toString()
    @Override
    public String toString() {
        return "Cliente{" +
                "nombreCliente='" + nombreCliente + '\'' +
                ", apellidoCliente='" + apellidoCliente + '\'' +
                ", runCliente='" + runCliente + '\'' +
                ", yearCliente='" + yearCliente + '\'' +
                ", categoría=" + categoría +
                '}';
    }
}
