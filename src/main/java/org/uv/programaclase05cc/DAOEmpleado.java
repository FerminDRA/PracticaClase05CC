/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.programaclase05cc;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author fermin
 */
public class DAOEmpleado implements IDAOGeneral<Empleado, Integer>{

    @Override
    public Empleado create(Empleado p) {
        Session session=HibernateUtil.getSession();
        Transaction t=session.beginTransaction();
        
        session.save(p);
        
        t.commit();
        session.close();
        return p;
    }

    @Override
    public boolean delete(Integer id) {
        Session session=HibernateUtil.getSession();
        Transaction t=session.beginTransaction();
        boolean res=false;
        Empleado emp=findById(id);
        if(emp==null){
            Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, "No existe el id......");
            res= false;
        }
        else{
            session.delete(emp);
            Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, "Se ha borrado....");
            
            res= true;
        }
        
        t.commit();
        session.close();
        return res;
    }

    @Override
    public Empleado update(Integer id, Empleado p) {
        Session session=HibernateUtil.getSession();
        Transaction t=session.beginTransaction();
        Empleado emp=findById(id);
        
        if(emp!=null && p.getClave()==id){
            session.update(p);
            
        }
        t.commit();
        session.close();
        return emp;
    }

    @Override
    public List<Empleado> findAll() {
        List<Empleado> empleados=null;
        try (Session session = HibernateUtil.getSession()) {
            Transaction t=session.beginTransaction();
            empleados=session.createQuery("from Empleado").list();
            t.commit();
        }
        return empleados;
    }

    @Override
    public Empleado findById(Integer id) {
        Session session=HibernateUtil.getSession();
        Transaction t=session.beginTransaction();
        Empleado emp=session.get(Empleado.class, id);
        
        if(emp!=null){
            t.commit();
            session.close();
            return emp;
        }
        else{
            return null;
        }
    }
    
}
