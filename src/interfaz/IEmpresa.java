package interfaz;

import domain.Departamento;
import domain.Empleado;
import domain.Proyecto;
import utils.Rol;

public interface IEmpresa {

    public boolean addDepartamento(Departamento departamentoAAñadir);

    public boolean addProyecto(Proyecto proyectoAAñadir);

    public boolean addEmpleado(Empleado empleadoAAñadir);

    public String trabajadorMayorSalario();

    public double salarioTotal();

    public boolean darBajaTrabajador(String empleadoBaja);

    public String proyectoMayorValor();

    public int trabajadorJabaAseo(String siEmpleadoTieneJavaAseo);

    public int trabajadorDescuentoAusencia(String EmpleadoABuscarSuCantidadAusencias);

    public int cantTrabajadoresPorRol(Rol rolABuscarCantidadTrabajadores);

    public void asignarProyectoTrabajador(String empleadoAAsignar, String proyectoAAsignar);

    public Empleado buscarEmpleado(String empleadoABuscar);

}
