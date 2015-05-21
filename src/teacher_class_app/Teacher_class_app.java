/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teacher_class_app;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import tr.gov.ptt.teacher_class_app.entity.Teacher;
import tr.gov.ptt.teacher_class_app.entity.Class;

/**
 *
 * @author Administrator
 */
public class Teacher_class_app {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("teacher_class_appPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        Teacher t1 = new Teacher();
        //t1.setTid(1);
        t1.setTname("Murat");
        t1.setSubject("Matematik");
        
        Teacher t2 = new Teacher();
        //t2.setTid(2);
        t2.setTname("Umut");
        t2.setSubject("Fen");
        
        Teacher t3 = new Teacher();
        //t3.setTid(3);
        t3.setTname("Hasan");
        t3.setSubject("Türkçe");
        
        List<Teacher> tcList = new ArrayList<Teacher>();
        tcList.add(t3);
        tcList.add(t2);
        tcList.add(t1);
        
        Class c1 = new Class();
        //c1.setCid(1);
        c1.setCname("SNF-1");
        c1.setTeacherList(tcList);
        
        em.persist(t1);
        em.persist(t2);
        em.persist(t3);
        em.persist(c1);
        
        
        em.getTransaction().commit();
        
        em.close();
        emf.close();
    }
    
}
