/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package utils;

import domain.Departamento;
import domain.Empleado;
import domain.Proyecto;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Roiber
 */
public class EmpresaTest {
    
    public EmpresaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

   @Test
    public void testAddDepartamento() {
        Departamento departamento = new Departamento ("departamento 1", "Diseño", 3);
        Empresa empresa = new Empresa(new ArrayList<Departamento>(),new ArrayList<Proyecto>(), new ArrayList<Empleado>());
        assertTrue(empresa.addDepartamento(departamento));
        assertEquals(1, empresa.getDepartamentos().size());
        assertTrue(empresa.getDepartamentos().contains(departamento));

    }

   
    @Test
    public void testAdddProyecto() {
        
        Proyecto proyecto = new Proyecto ("Websoft", "Java", "Solutel", "5 de diciembre", 25.0, new ArrayList<Empleado>(), null );
        Empresa empresa = new Empresa (new ArrayList<Departamento>(),new ArrayList<Proyecto>(), new ArrayList<Empleado>());
        assertTrue(empresa.adddProyecto(proyecto));
        assertEquals(1, empresa.getProyectos().size());
        assertTrue(empresa.getProyectos().contains(proyecto));
        
    }

    @Test
    public void testAdddEmpleado() {
        Empleado empleado = new Empleado ("01", "Jorge", "CalleE", 53545556, 1, 30, NivelEscolar.GraduadoUniversitario, null, null);
        Empresa empresa = new Empresa (new ArrayList<Departamento>(),new ArrayList<Proyecto>(), new ArrayList<Empleado>());
        assertTrue(empresa.adddEmpleado(empleado));
        assertEquals(1, empresa.getEmpleados().size());
        assertTrue(empresa.getEmpleados().contains(empleado));
    }

}
