package domain;

import utils.Rol;
import utils.NivelEscolar;

public abstract class GraduadoUniversitario extends Empleado {

    protected String titulo;
    protected String universidadEstudio;
    protected int añoGraduacion;

    public GraduadoUniversitario(String titulo, String universidadEstudio, int añoGraduacion, String codigo, String nombre, String direccion, int telefono, int ausencias, int diasTrabajados, Rol rol, NivelEscolar nivelEscolar) {
        super(codigo, nombre, direccion, telefono, ausencias, diasTrabajados, rol, nivelEscolar);
        this.titulo = titulo;
        this.universidadEstudio = universidadEstudio;
        this.añoGraduacion = añoGraduacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUniversidadEstudio() {
        return universidadEstudio;
    }

    public void setUniversidadEstudio(String universidadEstudio) {
        this.universidadEstudio = universidadEstudio;
    }

    public int getAñoGraduacion() {
        return añoGraduacion;
    }

    public void setAñoGraduacion(int añoGraduacion) {
        this.añoGraduacion = añoGraduacion;
    }

}
