package domain;

import utils.NivelEscolar;

public class Analista extends GraduadoUniversitario {

    private String metodologiaSoftwareUtilizada;
    private int aproxClasesXDia;

    public Analista(String metodologiaSoftwareUtilizada, int aproxClasesXDia, String titulo, String universidadEstudio, int añoGraduacion, String codigo, String nombre, String direccion, int telefono, int ausencias, int diasTrabajados, NivelEscolar nivelEscolar, Proyecto proyectoAsignado, Departamento departamentoTrabaja) {
        super(titulo, universidadEstudio, añoGraduacion, codigo, nombre, direccion, telefono, ausencias, diasTrabajados, nivelEscolar, proyectoAsignado, departamentoTrabaja);
        this.metodologiaSoftwareUtilizada = metodologiaSoftwareUtilizada;
        this.aproxClasesXDia = aproxClasesXDia;
    }

    public String getMetodologiaSoftwareUtilizada() {
        return metodologiaSoftwareUtilizada;
    }

    public void setMetodologiaSoftwareUtilizada(String metodologiaSoftwareUtilizada) {
        this.metodologiaSoftwareUtilizada = metodologiaSoftwareUtilizada;
    }

    public int getAproxClasesXDia() {
        return aproxClasesXDia;
    }

    public void setAproxClasesXDia(int aproxClasesXDia) {
        this.aproxClasesXDia = aproxClasesXDia;
    }

    //Metodo para calcular el salario del propio empleado
    @Override
    public double salario() {
        if (proyectoAsignado != null) {
            double salario = (((proyectoAsignado.getValorBase() * 3) / 10) / cantidadAnalista()) + aproxClasesXDia + (metodologiaSoftwareUtilizada.equals("UML") ? aproxClasesXDia / 10 : 0);

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

    private int cantidadAnalista() {
        int contador = 0;
        for (Empleado e : proyectoAsignado.getListaEmpleadosAsignados()) {
            if (e instanceof Analista) {
                contador++;
            }
        }
        return contador;
    }

}
