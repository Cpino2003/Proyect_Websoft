package interfaz;

import domain.Departamento;
import domain.Empleado;
import domain.Proyecto;
import java.util.List;

public interface IEmpresa {

    public boolean addDepartamento(Departamento departamentoAAñadir);
    
    public boolean adddProyecto(Proyecto proyectoAsignar);
    
    public boolean adddEmpleado(Empleado empleadoAsignar);
            
    public List<Empleado> empleadosSinProyectos(String departamento);

    public void asignarProyectoAEmpleado(Proyecto proyectoAsignar, List<Empleado> empleadosAAsignar);
    
    public String trabajadorMayorSalario();

    public double salarioTotal();

    public String proyectoMayorValor();

    public int trabajadorJabaAseo(String siEmpleadoTieneJavaAseo);

    public int trabajadorDescuentoAusencia(String EmpleadoABuscarSuCantidadAusencias);


}
