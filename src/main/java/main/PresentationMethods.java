package main;

import model.Department;
import model.Employee;
import model.Project;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Willi on 01.06.2015.
 */
public class PresentationMethods {

    SessionFactory sessionFactory = null;
    int departmentId = 21;
    int projectId = 19;

    private void loadSessionFactory(){
        sessionFactory = HibernateUtil.getSessionAnnotationFactory();
    }

    private SessionFactory getSessionFactory(){
        if(sessionFactory == null){
            loadSessionFactory();
        }
        return sessionFactory;
    }

    public void insertEmployee(){

        List<Employee> empList = new ArrayList<Employee>();



        empList.add(new Employee("David", "Developer", new Date(), getDepartment(departmentId)));
        empList.add(new Employee("Horst", "CEO", new Date(), getDepartment(departmentId)));
        empList.add(new Employee("Albert", "Assistent", new Date(), getDepartment(departmentId)));

        //Get Session
        SessionFactory sessionFactory = getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        //start transaction
        session.beginTransaction();
        //Save the Model object
        for(Employee employee : empList){
            session.save(employee);
        }
        //Commit transaction
        session.getTransaction().commit();
        //terminate session factory, otherwise program won't end
        sessionFactory.close();
    }

    public void insertDepartment(){
        Department dep = new Department("IT");
        SessionFactory sessionFactory = getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        //start transaction
        session.beginTransaction();
        //Save the Model object
        session.save(dep);
        //Commit transaction
        session.getTransaction().commit();
        System.out.println(dep);

        //terminate session factory, otherwise program won't end
        sessionFactory.close();
    }

    public void listEmployeeForDepartment(){
        Department dep = getDepartment(departmentId);
        for(Employee employee : dep.getEmployeeList()){
            System.out.println(employee);
        }
    }


    public void listAllEmployees(){

        Department department = getDepartment(departmentId);
        SessionFactory sessionFactory = getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        String hql = "SELECT E.name FROM Employee E, Department D where E.department = :department";


        Query query = session.createQuery(hql);
        query.setParameter("department",department);
        List results = query.list();
        session.getTransaction().commit();
        for(Object obj: results){
            System.out.println( (String) obj);
        }

    }


    public Department getDepartment(int id ){
        SessionFactory sessionFactory = getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Object object = session.get(Department.class, id);
        session.getTransaction().commit();
        return (Department) object;

    }

    public Project getProject(int id){
        SessionFactory sessionFactory = getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Object object = session.get(Project.class, id);
        session.getTransaction().commit();
        return (Project) object;
    }
}
