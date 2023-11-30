package domain;

import utils.Rol;
import utils.NivelEscolar;

public class JefeProyecto extends GraduadoUniversitario {

    private int añosExperiencia;
    private int proyectosDirigidos;

    public JefeProyecto(int añosExperiencia, int proyectosDirigidos, String titulo, String universidadEstudio, int añoGraduacion, String codigo, String nombre, String direccion, int telefono, int ausencias, int diasTrabajados, Rol rol, NivelEscolar nivelEscolar) {
        super(titulo, universidadEstudio, añoGraduacion, codigo, nombre, direccion, telefono, ausencias, diasTrabajados, rol, nivelEscolar);
        this.añosExperiencia = añosExperiencia;
        this.proyectosDirigidos = proyectosDirigidos;
    }

    public int getAñosExperiencia() {
        return añosExperiencia;
    }

    public void setAñosExperiencia(int añosExperiencia) {
        this.añosExperiencia = añosExperiencia;
    }

    public int getProyectosDirigidos() {
        return proyectosDirigidos;
    }

    public void setProyectosDirigidos(int proyectosDirigidos) {
        this.proyectosDirigidos = proyectosDirigidos;
    }

    @Override
    public double salario() {
        double salario = ((proyectoAsignado.getValorBase() * 2) / 10) + ((añosExperiencia / 2) + (añosExperiencia / 4));
        if (getAusencias() >= 3 && getAusencias() <= 7) {
            salario -= ((salario * 3) / 100);
        } else if (getAusencias() > 7 && getAusencias() <= 10) {
            salario -= ((salario * 5) / 100);
        } else {
            salario -= salario / 4;
        }
        return salario;
    }

}
