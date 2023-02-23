package com.vitali;

import com.vitali.entity.*;
import org.hibernate.Hibernate;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {

        Person person2 = Person.builder().build();

        Person person = Person.builder()
                .age(20)
                .name("Вася32")
                .build();

        EntityManager em = HibernateUtil.getEntityManager();


        // использование Native Hibarnate
        Session session = em.unwrap(Session.class);


        // этот код на Native Hibarnete
        // работаем через транзакцию
 /*       Transaction transaction = session.beginTransaction();
        session.save(person);
        transaction.commit();*/

        // без транзакции
        session.save(person);
        person.setAge(87);
//        session.flush();

/*        em.getTransaction().begin();
        Person person2 = em.merge(person);

        person2.setAge(23);
        em.refresh(person2); // помещает (возвращает) в объект person2 значение что есть в базе

        em.merge(person2); // обновляет
        em.getTransaction().commit();

//        em.persist(person); // сохраняет

        em.getTransaction().begin();
        Person person1 = em.find(Person.class, 1);
        System.out.println(person1);
//        em.remove(person1);  // удаляет объект
        em.getTransaction().commit();*/

        Department department = new Department("Department");

        EmployeeDetails employeeDetails = new EmployeeDetails(null,
                "City", "Country", "State", "Street", null);

        Meeting meeting = new Meeting("Jack", null);
        Set<Meeting> setMeeting = new HashSet<>();
        setMeeting.add(meeting);

        Employee employee = new Employee("First Name",
                "Last Name", "Cell Phone", employeeDetails, department, setMeeting);

        Set<Employee> setEmployee = new HashSet<>();
        setEmployee.add(employee);
        meeting.setEmployees(setEmployee);

        employeeDetails.setEmployee(employee);

        em.getTransaction().begin();
        em.persist(employeeDetails);
        em.getTransaction().commit();

//        System.out.println(employee);


//        em.getTransaction().begin();
//        Employee employee1 = em.find(Employee.class, 1);
//        em.getTransaction().commit();
//
//        HibernateUtil.close();
//
//        em = HibernateUtil.getEntityManager();
//        em.getTransaction().begin();
//        Employee employee2 = em.find(Employee.class, 2);
//        em.getTransaction().commit();
//        employee2.getDepartment(); // департамент может достать пока есть соединение с бд


        em = HibernateUtil.getEntityManager();

//        javax.persistence.Query query = em.createQuery(
//                "from Employee e where e.firstName= :name");
//
//        query.setParameter("name", "First Name")
//                        .getResultList().forEach(System.out::println);


        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
        Root<Employee> root = criteria.from(Employee.class);
        criteria.select(root).where(builder.equal(root.get("firstName"), "First Name"));
        List<Employee> resultList = em.createQuery(criteria).getResultList();
        resultList.forEach(System.out::println);


        HibernateUtil.close();


    }
}
