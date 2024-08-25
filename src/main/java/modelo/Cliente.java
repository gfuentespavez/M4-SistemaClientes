package modelo;

public class Cliente {
    //Atributos
    private String nombreCliente;
    private String apellidoCliente;
    private String runCliente;
    private String yearCliente;

    //Constructores

    public Cliente(String nombreCliente, String apellidoCliente, String runCliente, String yearCliente) {
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.runCliente = runCliente;
        this.yearCliente = yearCliente;
    }

    //Getters y setters

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
        this.runCliente = runCliente;
    }

    public String getYearCliente() {
        return yearCliente;
    }

    public void setYearCliente(String yearCliente) {
        this.yearCliente = yearCliente;
    }

    //Método toString()

    @Override
    public String toString() {
        return "Cliente{" +
                "nombreCliente='" + nombreCliente + '\'' +
                ", apellidoCliente='" + apellidoCliente + '\'' +
                ", runCliente='" + runCliente + '\'' +
                ", yearCliente='" + yearCliente + '\'' +
                '}';
    }
}
