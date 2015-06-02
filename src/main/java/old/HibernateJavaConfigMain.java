package old;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Employee;
import util.HibernateUtil;

public class HibernateJavaConfigMain {

	public static void main(String[] args) {
		Employee emp = new Employee();
		emp.setName("Lisa");
		emp.setRole("Manager");
		emp.setInsertTime(new Date());
		
		//Get Session
		SessionFactory sessionFactory = HibernateUtil.getSessionJavaConfigFactory();
		Session session = sessionFactory.getCurrentSession();
		//start transaction
		session.beginTransaction();
		//Save the Model object
		session.save(emp);
		//Commit transaction
		session.getTransaction().commit();
		System.out.println("Employee ID="+emp.getId());
		
		//terminate session factory, otherwise program won't end
		sessionFactory.close();
	}

}
