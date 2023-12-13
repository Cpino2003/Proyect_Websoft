package utils;

import domain.Departamento;
import domain.Empleado;
import domain.Proyecto;
import interfaz.IEmpresa;
import java.util.ArrayList;
import java.util.List;

public class Empresa implements IEmpresa {

    private List<Departamento> departamentos;

    public Empresa(List<Departamento> departamentos) {
        this.departamentos = new ArrayList<>();
    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }

    //Metodo para añadir un departamento
    @Override
    public boolean addDepartamento(Departamento departamentoAAñadir) {
        return departamentos.add(departamentoAAñadir);

    }

    //Metodo para asignarle un proyecto a un departamento
    @Override
    public boolean addProyectoADepartamento(Proyecto proyectoAAñadir, String departamentoARecibirProyecto) {
        if (buscarDepartamento(departamentoARecibirProyecto) != null) {
            buscarDepartamento(departamentoARecibirProyecto).getListaProyectosAsignados().add(proyectoAAñadir);
            return true;
        } else {
            return false;
        }
    }

    //Metodo para asignarle un empleado a un departamento
    @Override
    public boolean addEmpleadoADepartamento(Empleado empleadoAAñadir, String departamentoTrabajaEmpleado) {
        if (buscarDepartamento(departamentoTrabajaEmpleado) != null) {
            buscarDepartamento(departamentoTrabajaEmpleado).getListaEmpleados().add(empleadoAAñadir);
            return true;
        }
        return false;
    }

    //Metodo para conocer la lista de empleados sin proyecto asignado
    @Override
    public List<Empleado> empleadosSinProyectos(String departamento) {
        List<Empleado> listaEmpleadosSinProyecto = new ArrayList<>();
        
        if (buscarDepartamento(departamento) != null) {
            for (Empleado empleado : buscarDepartamento(departamento).getListaEmpleados()) {
                if (empleado.getProyectoAsignado() == null) {
                    listaEmpleadosSinProyecto.add(empleado);
                    return listaEmpleadosSinProyecto;
                }
            }
        }
        return null;
    }
    
    @Override
    public boolean asignarEmpleadosAProyecto(List<Empleado> empleadosAAsignar, String nombreProyecto) {
        if (buscarEmpleado(nombreProyecto) != null) {
            buscarProyecto(nombreProyecto).getListaEmpleadosAsignados().addAll(empleadosAAsignar);
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public void asignarProyectoAEmpleado(Proyecto proyectoAsignar, List<Empleado> empleadosAAsignar){
        for(Empleado empleado: empleadosAAsignar)
            empleado.setProyectoAsignado(proyectoAsignar);
    }

    //Metodo para buscar el nombre empleado con mayor salario de la empresa
    @Override
    public String trabajadorMayorSalario() {
        Empleado empleadoMayorSalario = todosEmpleadosEmpresa().get(0);
        for (Empleado e : todosEmpleadosEmpresa().subList(1, todosEmpleadosEmpresa().size())) {
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

        for (Empleado e : todosEmpleadosEmpresa()) {
            salarioTotal += e.salario();
        }
        return salarioTotal;
    }

    //Metodo para obtener el nombre del proyecto de mayor valor
    @Override
    public String proyectoMayorValor() {
        Proyecto proyectoMasValor = todosProyectosEmpresa().get(0);

        for (Proyecto p : todosProyectosEmpresa()) {
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
    private Empleado buscarEmpleado(String empleadoABuscar) {

        for (Empleado empleado : todosEmpleadosEmpresa()) {
            if (empleadoABuscar.equals(empleado.getNombre())) {
                return empleado;
            }
        }
        return null;
    }

    private Proyecto buscarProyecto(String proyectoABuscar) {

        for (Proyecto proyecto : todosProyectosEmpresa()) {
            if (proyectoABuscar.equals(proyecto.getNombre())) {
                return proyecto;
            }
        }
        return null;
    }

    private Departamento buscarDepartamento(String departamentoBuscar) {

        for (Departamento departamento : departamentos) {
            if (departamentoBuscar.equals(departamento.getNombre())) {
                return departamento;
            }
        }
        return null;
    }

    private List<Empleado> todosEmpleadosEmpresa() {
        List<Empleado> empleadosEmpresa = new ArrayList<>();

        for (Departamento d : departamentos) {
            empleadosEmpresa = d.getListaEmpleados();
        }

        return empleadosEmpresa;
    }

    private List<Proyecto> todosProyectosEmpresa() {
        List<Proyecto> proyectosEmpresa = new ArrayList<>();

        for (Departamento d : departamentos) {
            proyectosEmpresa = d.getListaProyectosAsignados();
        }

        return proyectosEmpresa;
    }

}
