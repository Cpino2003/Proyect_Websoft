package domain;

import java.util.ArrayList;
import java.util.List;

public class Proyecto {

    private String nombre;
    private String plataformaAProgramar;
    private String empresaContratista;
    private String fechaCulminacion;
    private double valorBase;
    private List<Empleado> listaEmpleadosAsignados;
    private Departamento departamentoAsignado;

    public Proyecto(String nombre, String plataformaAProgramar, String empresaContratista, String fechaCulminacion, double valorBase, List<Empleado> listaEmpleadosAsignados, Departamento departamentoAsignado) {
        this.nombre = nombre;
        this.plataformaAProgramar = plataformaAProgramar;
        this.empresaContratista = empresaContratista;
        this.fechaCulminacion = fechaCulminacion;
        this.valorBase = valorBase;
        this.listaEmpleadosAsignados = new ArrayList<>();
        this.departamentoAsignado = departamentoAsignado;
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

    public List<Empleado> getListaEmpleadosAsignados() {
        return listaEmpleadosAsignados;
    }

    public void setListaEmpleadosAsignados(List<Empleado> listaEmpleadosAsignados) {
        this.listaEmpleadosAsignados = listaEmpleadosAsignados;
    }

    public Departamento getDepartamentoAsignado() {
        return departamentoAsignado;
    }

    public void setDepartamentoAsignado(Departamento departamentoAsignado) {
        this.departamentoAsignado = departamentoAsignado;
    }
    
    

}
