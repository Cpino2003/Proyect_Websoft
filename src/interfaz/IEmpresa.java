package interfaz;

import domain.Departamento;
import domain.Empleado;
import domain.Proyecto;
import java.util.List;

public interface IEmpresa {

    public boolean addDepartamento(Departamento departamentoAAñadir);

    public boolean addProyectoADepartamento(Proyecto proyectoAAñadir, String departamentoARecibirProyecto);

    public boolean addEmpleadoADepartamento(Empleado empleadoAAñadir, String departamentoTrabajaEmpleado);
    
    public List<Empleado> empleadosSinProyectos(String departamento);
    
    public boolean asignarEmpleadosAProyecto(List<Empleado> empleadosAAsignar, String nombreProyecto);

    public void asignarProyectoAEmpleado(Proyecto proyectoAsignar, List<Empleado> empleadosAAsignar);
    
    public String trabajadorMayorSalario();

    public double salarioTotal();

    public String proyectoMayorValor();

    public int trabajadorJabaAseo(String siEmpleadoTieneJavaAseo);

    public int trabajadorDescuentoAusencia(String EmpleadoABuscarSuCantidadAusencias);


}
