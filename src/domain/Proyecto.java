package domain;

public class Proyecto {

    private String nombre;
    private String plataformaAProgramar;
    private String empresaContratista;
    private String fechaCulminacion;
    private double valorBase;

    public Proyecto(String nombre, String plataformaAProgramar, String empresaContratista, String fechaCulminacion, double valorBase) {
        this.nombre = nombre;
        this.plataformaAProgramar = plataformaAProgramar;
        this.empresaContratista = empresaContratista;
        this.fechaCulminacion = fechaCulminacion;
        this.valorBase = valorBase;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPlataformaAProgramar() {
        return plataformaAProgramar;
    }

    public void setPlataformaAProgramar(String plataformaAProgramar) {
        this.plataformaAProgramar = plataformaAProgramar;
    }

    public String getEmpresaContratista() {
        return empresaContratista;
    }

    public void setEmpresaContratista(String empresaContratista) {
        this.empresaContratista = empresaContratista;
    }

    public String getFechaCulminacion() {
        return fechaCulminacion;
    }

    public void setFechaCulminacion(String fechaCulminacion) {
        this.fechaCulminacion = fechaCulminacion;
    }

    public double getValorBase() {
        return valorBase;
    }

    public void setValorBase(double valorBase) {
        this.valorBase = valorBase;
    }

}
