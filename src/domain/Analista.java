package domain;

import utils.NivelEscolar;
import vista.FormMain;


public class Analista extends GraduadoUniversitario{

    private String metodologiaSoftwareUtilizada;
    private int aproxClasesXDia;

    public Analista(String metodologiaSoftwareUtilizada, int aproxClasesXDia, String titulo, String universidadEstudio, int añoGraduacion, String codigo, String nombre, String direccion, int telefono, int ausencias, int diasTrabajados, NivelEscolar nivelEscolar, Proyecto proyectoAsignado) {
        super(titulo, universidadEstudio, añoGraduacion, codigo, nombre, direccion, telefono, ausencias, diasTrabajados, nivelEscolar, proyectoAsignado);
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
    
    @Override
    public double salario(){
            FormMain e = new FormMain();                   
            double salario = (((proyectoAsignado.getValorBase()*3)/10) / e.getEmpresa().cantidadAnalista()) + getAproxClasesXDia() + (getMetodologiaSoftwareUtilizada().equals("UML")?getAproxClasesXDia()/10:0);
            if(getAusencias() >= 3 && getAusencias() <= 7)
                salario -= ((salario * 3)/100);
            else 
                if(getAusencias() > 7 && getAusencias() <= 10)
                    salario -= ((salario * 5)/100);
                else
                    salario -= salario /4 ;
            return salario;
    }

}
