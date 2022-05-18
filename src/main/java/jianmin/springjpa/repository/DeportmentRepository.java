package jianmin.springjpa.repository;

import jianmin.springjpa.model.Department;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DeportmentRepository extends JpaRepository<Department, Long> {

    /**
     * When define findBy repository method, the name has to match the getter name.
     * In this case, the getter is getDepartmentName(), so the findBy name is
     * findByDepartmentName()
     */
    @EntityGraph(attributePaths = "employees")
    Optional<Department> findByDepartmentName(String departmentName);


    @EntityGraph(attributePaths = "employees")
    List<Department> findAll() ;

}
