package jianmin.springjpa.repository;

import jianmin.springjpa.model.Employee;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Override
    /**
     * Note: Even you can do a Query to SELECT both Employee and Department,
     * you still can't reference them in the Employee entity because JPA has
     * nowhere to put the Department data in the Employee entity.
     */
    @Query("SELECT e, d FROM Employee e , Department d WHERE e.dept_id = d.id")
    List<Employee> findAll();

}
