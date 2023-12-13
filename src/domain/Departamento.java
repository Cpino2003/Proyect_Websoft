package domain;



public class Departamento {

    private String nombre;
    private String especialidad;
    private int cantidadTrabajadores;

    public Departamento(String nombre, String especialidad, int cantidadTrabajadores) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.cantidadTrabajadores = cantidadTrabajadores;
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

}
