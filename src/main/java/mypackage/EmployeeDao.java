package mypackage;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class EmployeeDao {

	public void AddEmployee() {
		
		Session s=HibernateUtils.getSessionFactory().openSession();
		Transaction tr=s.beginTransaction();
		Employee e=new Employee( "Ajay","Developer", 42000);
		s.persist(e);
		tr.commit();
//		s.close();
		System.out.println("Student Added Successfully");
	}
	
	public void Display() {
		Session s= HibernateUtils.getSessionFactory().openSession();
		List<Employee> lst=s.createQuery("from Employee").list();
		for(Employee e : lst) {
			System.out.println(e.getEmployee_id()+" "+e.getEmployee_name()+" "+e.getDesignation()+" "+e.getSalary());
		}
	}
}
