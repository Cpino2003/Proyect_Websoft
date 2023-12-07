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
    public void addDepartamento(Departamento departamentoAAñadir) {
        departamentos.add(departamentoAAñadir);
    }

    //Metodo para asignarle un proyecto a un departamento
    @Override
    public void addProyecto(Proyecto proyectoAAñadir, String departamentoARecibirProyecto) {
        for (Departamento d : departamentos) {
            if (departamentoARecibirProyecto.equals(d.getNombre())) {
                d.getListaProyectosAsignados().add(proyectoAAñadir);
            }
        }
    }

    //Metodo para asignarle un empleado a un departamento
    @Override
    public void addEmpleado(Empleado empleadoAAñadir, String departamentoTrabajaEmpleado) {
        for (Departamento d : departamentos) {
            if (departamentoTrabajaEmpleado.equals(d.getNombre())) {
                d.getListaEmpleados().add(empleadoAAñadir);
            }
        }
    }

    //metodo para asignarle Empleados a un proyecto
//    public void addEmpleadoProyecto(Empleado empleadoAsignarPRoyecto, String proyecto) {
//        for (Departamento d : departamentos) {
//            if (empleadoAsignarPRoyecto.getDepartamentoLabora().getNombre().equals(d.getNombre())) {
//                for (Proyecto p : d.getListaProyectosAsignados()) {
//                    if (p.getNombre().equals(proyecto)) {
//                        p.getListaEmpleadosAsignados().add(empleadoAsignarPRoyecto);
//                        empleadoAsignarPRoyecto.setValorAgregagdo(p.getValorBase());
//                    }
//                }
//            }
//        }
//    }
    
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
