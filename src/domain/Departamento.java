package domain;

import java.util.ArrayList;
import java.util.List;

public class Departamento {

    private String nombre;
    private String especialidad;
    private int cantidadTrabajadores;
    private List<Proyecto> listaProyectosAsignados;
    private List<Empleado> listaEmpleados;

    public Departamento(String nombre, String especialidad, int cantidadTrabajadores, List<Proyecto> listaProyectosAsignados, List<Proyecto> listaEmpleados) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.cantidadTrabajadores = cantidadTrabajadores;
        this.listaProyectosAsignados = new ArrayList<>();
        this.listaEmpleados = new ArrayList<>();
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getCantidadTrabajadores() {
        return cantidadTrabajadores;
    }

    public void setCantidadTrabajadores(int cantidadTrabajadores) {
        this.cantidadTrabajadores = cantidadTrabajadores;
    }

    public List<Proyecto> getListaProyectosAsignados() {
        return listaProyectosAsignados;
    }

    public void setListaProyectosAsignados(List<Proyecto> listaProyectosAsignados) {
        this.listaProyectosAsignados = listaProyectosAsignados;
    }

    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

}
