package interfaz;

import domain.Departamento;
import domain.Empleado;
import domain.Proyecto;

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

    public int cantidadProgramadores();
            
    public int cantidadAnalista();
            
    public Proyecto asignarProyectoTrabajador(String proyectoAAsignar);

    public Empleado buscarEmpleado(String empleadoABuscar);

}
