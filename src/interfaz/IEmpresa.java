package interfaz;

import domain.Departamento;
import domain.Empleado;
import domain.Proyecto;

public interface IEmpresa {

    public void addDepartamento(Departamento departamentoAAñadir);

    public void addProyecto(Proyecto proyectoAAñadir, String departamentoARecibirProyecto);

    public void addEmpleado(Empleado empleadoAAñadir, String departamentoTrabajaEmpleado);

    public String trabajadorMayorSalario();

    public double salarioTotal();

    public String proyectoMayorValor();

    public int trabajadorJabaAseo(String siEmpleadoTieneJavaAseo);

    public int trabajadorDescuentoAusencia(String EmpleadoABuscarSuCantidadAusencias);


}
