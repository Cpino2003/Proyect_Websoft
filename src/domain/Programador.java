package domain;

import utils.NivelEscolar;

public class Programador extends Empleado {

    private int aproxLineasCodigoXHora;
    private String plataformaEspecializada;
    private boolean cursoGraficoAprobado;

    public Programador(int aproxLineasCodigoXHora, String plataformaEspecializada, boolean cursoGraficoAprobado, String codigo, String nombre, String direccion, int telefono, int ausencias, int diasTrabajados, NivelEscolar nivelEscolar, Proyecto proyectoAsignado, Departamento departamentoTrabaja) {
        super(codigo, nombre, direccion, telefono, ausencias, diasTrabajados, nivelEscolar, proyectoAsignado, departamentoTrabaja);
        this.aproxLineasCodigoXHora = aproxLineasCodigoXHora;
        this.plataformaEspecializada = plataformaEspecializada;
        this.cursoGraficoAprobado = cursoGraficoAprobado;
    }

    public int getAproxLineasCodigoXHora() {
        return aproxLineasCodigoXHora;
    }

    public void setAproxLineasCodigoXHora(int aproxLineasCodigoXHora) {
        this.aproxLineasCodigoXHora = aproxLineasCodigoXHora;
    }

    public String getPlataformaEspecializada() {
        return plataformaEspecializada;
    }

    public void setPlataformaEspecializada(String plataformaEspecializada) {
        this.plataformaEspecializada = plataformaEspecializada;
    }

    public boolean isCursoGraficoAprobado() {
        return cursoGraficoAprobado;
    }

    public void setCursoGraficoAprobado(boolean cursoGraficoAprobado) {
        this.cursoGraficoAprobado = cursoGraficoAprobado;
    }

    //Metodo para calcular el salario del propio empleado
    @Override
    public double salario() {
        if (proyectoAsignado != null) {
            double salario = ((proyectoAsignado.getValorBase() / 2) / cantidadProgramador()) + (aproxLineasCodigoXHora / 10);

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

    private int cantidadProgramador() {
        int contador = 0;
        for (Empleado e : proyectoAsignado.getListaEmpleadosAsignados()) {
            if (e instanceof Programador && NivelEscolar.TecnicoMedio.equals(e.getNivelEscolar())) {
                contador++;
            }
        }
        return contador;
    }
}
