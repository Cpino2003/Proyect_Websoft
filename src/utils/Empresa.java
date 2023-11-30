package utils;

import domain.Departamento;
import domain.Empleado;
import domain.Proyecto;
import interfaz.IEmpresa;
import java.util.ArrayList;
import java.util.List;

public class Empresa implements IEmpresa {

    private List<Departamento> departamentos;
    private List<Empleado> empleados;
    private List<Proyecto> proyectos;

    public Empresa(List<Departamento> departamentos, List<Empleado> empleados, List<Proyecto> proyectos) {
        departamentos = new ArrayList<>();
        empleados = new ArrayList<>();
        proyectos = new ArrayList<>();
    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public List<Proyecto> getProyectos() {
        return proyectos;
    }

    //Metodo para añadir un departamento
    @Override
    public boolean addDepartamento(Departamento departamentoAAñadir) {
        return departamentos.add(departamentoAAñadir);
    }

    //Metodo para añadir un proyecto
    @Override
    public boolean addProyecto(Proyecto proyectoAAñadir) {
        return proyectos.add(proyectoAAñadir);
    }

    //Metodo para añadir un empleado
    @Override
    public boolean addEmpleado(Empleado empleadoAAñadir) {
        return this.empleados.add(empleadoAAñadir);
    }

    //Metodo para buscar el nombre empleado con mayor salario
    @Override
    public String trabajadorMayorSalario() {
        Empleado empleado = empleados.get(0);

        for (Empleado e : empleados.subList(1, empleados.size())) {
            if (e.salario() > empleado.salario()) {
                empleado = e;
            }
        }
        return empleado.getNombre();
    }

    //Metodo obtener el salario total
    @Override
    public double salarioTotal() {
        double salarioTotal = 0;

        for (Empleado e : empleados) {
            salarioTotal += e.salario();
        }
        return salarioTotal;
    }

    //Metodo para dar baja a un trabajador
    @Override
    public boolean darBajaTrabajador(String empleadoBaja) {
        return empleados.remove(buscarEmpleado(empleadoBaja));
    }

    //Metodo para obtener el nombre del proyecto de mayor valor
    @Override
    public String proyectoMayorValor() {
        Proyecto proyectoMasValor = proyectos.get(0);

        for (Proyecto p : proyectos) {
            if (p.getValorBase() > proyectoMasValor.getValorBase()) {
                proyectoMasValor = p;
            }
        }
        return proyectoMasValor.getNombre();
    }

    //Metodo para ver si un empleado tiene jaba de aseo (si devuelve 1 es V, si devuelve 0 es F, si devuelve -1 el empleado no existe)
    @Override
    public int trabajadorJabaAseo(String siEmpleadoTieneJavaAseo) {

        if (buscarEmpleado(siEmpleadoTieneJavaAseo) != null) {
            if (buscarEmpleado(siEmpleadoTieneJavaAseo).getAusencias() < 4) {
                return 1;
            } else {
                return 0;
            }
        }
        return -1;
    }

    //Metodo para saber el descuento de un trabajador por sus ausencias(Si devuelve -1 no existe el empleado)
    @Override
    public int trabajadorDescuentoAusencia(String EmpleadoABuscarSuCantidadAusencias) {
        if (buscarEmpleado(EmpleadoABuscarSuCantidadAusencias) != null) {
            if (buscarEmpleado(EmpleadoABuscarSuCantidadAusencias).getAusencias() < 3) {
                return 0;
            }
            if (buscarEmpleado(EmpleadoABuscarSuCantidadAusencias).getAusencias() >= 3 && buscarEmpleado(EmpleadoABuscarSuCantidadAusencias).getAusencias() <= 7) {
                return 3;
            } else if (buscarEmpleado(EmpleadoABuscarSuCantidadAusencias).getAusencias() > 7 && buscarEmpleado(EmpleadoABuscarSuCantidadAusencias).getAusencias() <= 10) {
                return 5;
            } else if (buscarEmpleado(EmpleadoABuscarSuCantidadAusencias).getAusencias() > 10 && buscarEmpleado(EmpleadoABuscarSuCantidadAusencias).getAusencias() <= 15) {
                return 25;
            }
        }
        return -1;
    }

    //Metodo para saber la cantidad de trabajadores que hay por rol
    @Override
    public int cantTrabajadoresPorRol(Rol rolABuscarCantidadTrabajadores) {
        int contador = 0;
        for (Empleado e : empleados) {
            if (rolABuscarCantidadTrabajadores.equals(e.getRol())) {
                if (e.getNivelEscolar().equals(NivelEscolar.GraduadoUniversitario) || e.getNivelEscolar().equals(NivelEscolar.TecnicoMedio)) {
                    contador++;
                }
            }
        }
        return contador;
    }

    //Metodo para asignar un proyecto a un trabajador
    @Override
    public void asignarProyectoTrabajador(String empleadoAAsignar, String proyectoAAsignar) {
        for (Proyecto proyecto : proyectos) {
            if (proyectoAAsignar.equals(proyecto.getNombre())) {
                buscarEmpleado(empleadoAAsignar).setProyectoAsignado(proyecto);
            }
        }
    }

    //Metodo para buscar los datos de un empleado
    @Override
    public Empleado buscarEmpleado(String empleadoABuscar) {
        for (Empleado empleado : empleados) {
            if (empleadoABuscar.equals(empleado.getNombre())) {
                return empleado;
            }
        }
        return null;
    }

}
