package utils;

import domain.Departamento;
import domain.Empleado;
import domain.Proyecto;
import interfaz.IEmpresa;
import java.util.ArrayList;
import java.util.List;

public class Empresa implements IEmpresa {

    private List<Departamento> departamentos;
    private List<Proyecto> proyectos;
    private List<Empleado> empleados;

    public Empresa(List<Departamento> departamentos, List<Proyecto> proyectos, List<Empleado> empleados) {
        this.departamentos = new ArrayList<>();
        this.proyectos = new ArrayList<>();
        this.empleados = new ArrayList<>();
    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }

    public List<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(List<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    //Metodo para añadir un departamento
    @Override
    public boolean addDepartamento(Departamento departamentoAAñadir) {
        return departamentos.add(departamentoAAñadir);

    }

    //Metodo para añadir proyecto
    @Override
    public boolean adddProyecto(Proyecto proyectoAsignar) {
        return proyectos.add(proyectoAsignar);
    }

    //Metodo para añadir empleado
    @Override
    public boolean adddEmpleado(Empleado empleadoAsignar) {
        return empleados.add(empleadoAsignar);
    }

    //Metodo para conocer la lista de empleados sin proyecto asignado
    @Override
    public List<Empleado> empleadosSinProyectos(String departamento) {
        List<Empleado> listaEmpleadosSinProyecto = new ArrayList<>();

        if (buscarDepartamento(departamento) != null) {
            for (Empleado empleado : empleados) {
                if (empleado.getProyectoAsignado() == null && empleado.getDepartamentoTrabaja().getNombre().equals(departamento)) {
                    listaEmpleadosSinProyecto.add(empleado);            
                }
            }
            return listaEmpleadosSinProyecto;
        }
        return null;
    }

    //Metodo para asignarle un objeto de tipo proyecto a un empleado
    @Override
    public void asignarProyectoAEmpleado(Proyecto proyectoAsignar, List<Empleado> empleadosAAsignar) {

        for (Empleado empleado : empleadosAAsignar) {
            empleado.setProyectoAsignado(proyectoAsignar);
        }
    }

    //Metodo para buscar el nombre empleado con mayor salario de la empresa
    @Override
    public String trabajadorMayorSalario() {
        Empleado empleadoMayorSalario = empleados.get(0);

        for (Empleado e : empleados.subList(1, empleados.size())) {
            if (e.salario() > empleadoMayorSalario.salario()) {
                empleadoMayorSalario = e;
            }
        }
        return empleadoMayorSalario.getNombre();
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

    //Metodo para ver si un empleado tiene jaba de aseo
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

    //Metodo para saber el descuento de un trabajador por sus ausencias 
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

    //Metodo para buscar los datos de un Departamento
    @Override
    public Departamento buscarDepartamento(String departamentoBuscar) {

        for (Departamento departamento : departamentos) {
            if (departamentoBuscar.equals(departamento.getNombre())) {
                return departamento;
            }
        }
        return null;
    }
    
    @Override
    public Proyecto buscarProyecto(String proyectoBuscar) {

        for (Proyecto p : proyectos) {
            if (proyectoBuscar.equals(p.getNombre())) {
                return p;
            }
        }
        return null;
    }

}
