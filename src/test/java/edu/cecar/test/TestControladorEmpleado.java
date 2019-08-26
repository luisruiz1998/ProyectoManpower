/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cecar.test;

import edu.cecar.controladores.ControladorEmpleado;
import edu.cecar.modelos.Empleado;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 1102881540
 */
public class TestControladorEmpleado {
    
   
    
    
    @Test
    
    public void testConexionBaseDatos(){
        
        try {
            ControladorEmpleado controladorEmpleado = new ControladorEmpleado();
            System.out.println("Conexión exitosa");
        } catch (SQLException ex) {
            fail("Error de conexión");
            Logger.getLogger(TestControladorEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
    @Test
    public void testConsulta(){
        try {
            ControladorEmpleado controladorEmpleado = new ControladorEmpleado();
            controladorEmpleado.consultar("1102881540");
        } catch (SQLException ex) {
            Logger.getLogger(TestControladorEmpleado.class.getName()).log(Level.SEVERE, null, ex);
         
        }
    }
    
    @Test
    public void testGuardar(){
        try {
            Empleado empleado = new Empleado("111","Luis","Ruiz","1998-21-21");
            ControladorEmpleado controladorEmpleado = new ControladorEmpleado();
            controladorEmpleado.guardar(empleado);
            Empleado empleadoBaseDatos = controladorEmpleado.consultar(empleado.getCodigo());
            assertEquals("El codigo esperado no coincide con el insertado", empleado.getCodigo(), empleadoBaseDatos.getCodigo());
            assertEquals("Los apellidos esperado no coincide con los insertados", empleado.getApellidos(), empleadoBaseDatos.getApellidos());
                    assertEquals("La fecha nacimiento esperado no coincide con el insertado", empleado.getFechaNacimiento(), empleadoBaseDatos.getFechaNacimiento());
                    assertEquals("Los nombres esperados no coincide con los insertados", empleado.getNombres(), empleadoBaseDatos.getNombres());
        } catch (SQLException ex) {
            System.out.println("Error: "+ ex.getMessage());
        }
    }
    
    @Test
    public void testEliminar() {
        try {
            Empleado empleado = new Empleado ();
            empleado.setCodigo("1102881");
            ControladorEmpleado controladorEmpleado = new ControladorEmpleado();
            controladorEmpleado.eliminar(empleado.getApellidos());
        } catch (SQLException ex) {
            Logger.getLogger(TestControladorEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("error");
        }
                }
  /*public void testActualizar(){
        ControladorEmpleado controladorEmpleado = new ControladorEmpleado();

    */
    
   /* @BeforeClass
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
*/
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
