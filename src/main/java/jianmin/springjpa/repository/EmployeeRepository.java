package jianmin.springjpa.repository;

import jianmin.springjpa.model.Employee;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    /**
     * By default, Hibernate use "LAZY" fetching for the ManyToOne Employee to Deportment
     * relationship. That means each time when you get Department data from Employee object,
     * you will incur a SQL query.
     * To avoid that, you can tell Hibernate to do a join with Department using @EntityGraph
     *
     * @return List<Employee>
     */
    @Override
    //@EntityGraph(attributePaths = "department")
    List<Employee> findAll();

}
