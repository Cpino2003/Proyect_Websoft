package domain;

import utils.NivelEscolar;
import vista.FormMain;

public class Programador extends Empleado {

    private int aproxLineasCodigoXHora;
    private String plataformaEspecializada;
    private boolean cursoGraficoAprobado;

    public Programador(int aproxLineasCodigoXHora, String plataformaEspecializada, boolean cursoGraficoAprobado, String codigo, String nombre, String direccion, int telefono, int ausencias, int diasTrabajados, NivelEscolar nivelEscolar, Proyecto proyectoAsignado) {
        super(codigo, nombre, direccion, telefono, ausencias, diasTrabajados, nivelEscolar, proyectoAsignado);
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

    @Override
    public double salario() {
        if (super.salario() != 0) {
            FormMain e = new FormMain();
            double salario = ((proyectoAsignado.getValorBase() / 2) / e.getEmpresa().cantidadProgramadores()) + (getAproxLineasCodigoXHora() / 10);
            if (getAusencias() >= 3 && getAusencias() <= 7) {
                salario -= ((salario * 3) / 100);
            } else if (getAusencias() > 7 && getAusencias() <= 10) {
                salario -= ((salario * 5) / 100);
            } else {
                salario -= salario / 4;
            }
            salario -= super.salario();
               return salario;
        } else {
            return 0;
        }
    }

}
