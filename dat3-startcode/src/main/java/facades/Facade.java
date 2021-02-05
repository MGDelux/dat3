package facades;

import entities.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class Facade {

    private static Facade instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private Facade() {}
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static Facade getFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new Facade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    public Employee getEmployeeById(int id){
             EntityManager em = emf.createEntityManager();
  try {
            Employee cust = em.find(Employee.class, id);
            return cust;
        } finally {
            em.close();
        }
    }
  public Employee getEmployeesByName(String name){
     EntityManager em = emf.createEntityManager();
        try {
            Employee cust = em.find(Employee.class, name);
            return cust;
        } finally {
            em.close();
        }
  }
   public List<Employee> getAllEmployees(){
     EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Employee> query = em.createQuery("Select employee from Employee employee", Employee.class);
            return query.getResultList();

        } finally {
            em.close();
        }
  }
  public double getEmployeesWithHighestSalary(Employee employee){
      return 0;
  }
   public  List<Employee> createEmployee(String name, String Address, double Salary){
       EntityManager em = emf.createEntityManager();

      try{
         TypedQuery<Employee> q = em.createQuery("Select e from EMPLOYEE where SALARY=(select max(SALARY) from Employee)",Employee.class);
      return q.getResultList();
      } finally {
            em.close();
        }
   }
   
   
    public static void main(String[] args) {
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        Employee c1 = new Employee("J.K. Rowling", "xd",2500);
        Employee c2 = new Employee("Georg R. R. Martin", "lol",4000);
        try {
            em.getTransaction().begin();
            em.persist(c1);
            em.persist(c2);
            em.getTransaction().commit();
            //Verify that books are managed and has been given a database id
             TypedQuery<Employee> query = em.createQuery("Select employee from Employee employee", Employee.class);
            System.out.println("FUCKING SHIT " +query.getResultList().toString());
        } finally {
            em.close();
        }
    }

}
