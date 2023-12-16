package domain;

import utils.NivelEscolar;

public class JefeProyecto extends GraduadoUniversitario {

    private int añosExperiencia;
    private int proyectosDirigidos;

    public JefeProyecto(int añosExperiencia, int proyectosDirigidos, String titulo, String universidadEstudio, int añoGraduacion, String codigo, String nombre, String direccion, int telefono, int ausencias, int diasTrabajados, NivelEscolar nivelEscolar, Proyecto proyectoAsignado, Departamento departamentoTrabaja) {
        super(titulo, universidadEstudio, añoGraduacion, codigo, nombre, direccion, telefono, ausencias, diasTrabajados, nivelEscolar, proyectoAsignado, departamentoTrabaja);
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

    //Metodo para calcular el salario del propio empleado
    @Override
    public double salario() {
        if (proyectoAsignado != null) {
            double salario = (proyectoAsignado.getValorBase() * 2) / 10 + añosExperiencia / 2 + añosExperiencia / 4;

            if (ausencias >= 3 || ausencias <= 7) {
                salario -= ((salario * 3) / 100);
            } else if (ausencias > 7 || ausencias <= 10) {
                salario -= ((salario * 5) / 100);
            } else if (ausencias > 10 || ausencias <= 15) {
                salario -= (salario / 4);
            }

            salario = salario - super.salario();

            return salario;
        } else {
            return 0;
        }
    }

}
