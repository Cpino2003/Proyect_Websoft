package domain;

import utils.NivelEscolar;

public class Empleado {

    protected String codigo;
    protected String nombre;
    protected String direccion;
    protected int telefono;
    protected int ausencias;
    protected int diasTrabajados;
    protected NivelEscolar nivelEscolar;
    protected Proyecto proyectoAsignado;

    public Empleado(String codigo, String nombre, String direccion, int telefono, int ausencias, int diasTrabajados, NivelEscolar nivelEscolar, Proyecto proyectoAsignado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.ausencias = ausencias;
        this.diasTrabajados = diasTrabajados;
        this.nivelEscolar = nivelEscolar;
        this.proyectoAsignado = proyectoAsignado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getAusencias() {
        return ausencias;
    }

    public void setAusencias(int ausencias) {
        this.ausencias = ausencias;
    }

    public int getDiasTrabajados() {
        return diasTrabajados;
    }

    public void setDiasTrabajados(int diasTrabajados) {
        this.diasTrabajados = diasTrabajados;
    }

    public NivelEscolar getNivelEscolar() {
        return nivelEscolar;
    }

    public void setNivelEscolar(NivelEscolar nivelEscolar) {
        this.nivelEscolar = nivelEscolar;
    }

    public Empleado(Proyecto proyectoAsignado) {
        this.proyectoAsignado = proyectoAsignado;
    }

    public double salario() {
        double descuento = 1.3 * getDiasTrabajados();
        if (NivelEscolar.Estudiante.equals(nivelEscolar)) {
            return 0;
        } else 
            if (ausencias < 4) {
                descuento += 10;
        }
        return descuento;
    }

}
