/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.uv.programaclase05cc;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fermin
 */
public class ProgramaClase05CC {

    public static void main(String[] args) {
        
        DAOEmpleado dao=new DAOEmpleado();
/**
//        
//        Empleado empleado=new Empleado();
//        empleado.setDireccion("Avenida1");
//        empleado.setNombre("Fermin");
//        empleado.setTelefono("1122334455");
//        
//        
//        dao.create(empleado);
//        
//        System.out.println("Hello World!");

//        //Delete
//        dao.delete(1);
        
//        //Find by Id
//        Empleado emp=dao.findById(2);
//        System.out.println(emp.getNombre()+"\n"+emp.getDireccion());

//        //Update
//        Empleado emp=new Empleado();
//        emp.setNombre("Juan");
//        emp.setDireccion("Avenida 9");
//        emp.setTelefono("10192837465");
//        
//        Empleado emp2= dao.update(3, emp);
//        System.out.println(emp2.getNombre()+"\n"+emp2.getDireccion());

        //FindAll
**/
        List<Empleado> empleados=dao.findAll();
        
        for (Empleado empleado : empleados) {
            Logger.getLogger(ProgramaClase05CC.class.getName()).log(Level.SEVERE, null, empleado.getNombre()+"\n"+empleado.getDireccion()+"\n");
        }
    }
}
