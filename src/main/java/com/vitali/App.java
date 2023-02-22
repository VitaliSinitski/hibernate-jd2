package com.vitali;

import com.vitali.entity.*;
import org.hibernate.Hibernate;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import java.util.HashSet;
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

        Meeting meeting = new Meeting(null, "Jack", null);
        Set<Meeting> setMeeting = new HashSet<>();
        setMeeting.add(meeting);

        Employee employee = new Employee(null, "First Name",
                "Last Name", "Cell Phone", employeeDetails, department, setMeeting);

        Set<Employee> setEmployee = new HashSet<>();
        setEmployee.add(employee);
        meeting.setEmployees(setEmployee);

        employeeDetails.setEmployee(employee);

        em.getTransaction().begin();
        em.persist(employeeDetails);
        em.getTransaction().commit();

        System.out.println(employee);


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
        HibernateUtil.close();


    }
}
