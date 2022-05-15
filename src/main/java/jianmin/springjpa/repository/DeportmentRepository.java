package jianmin.springjpa.repository;

import jianmin.springjpa.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DeportmentRepository extends JpaRepository<Department, Long> {

    /**
     * When define findBy repository method, the name has to match the getter name.
     * In this case, the getter is getDepartmentName(), so the findBy name is
     * findByDepartmentName()
     */
    Optional<Department> findByDepartmentName(String departmentName);
}
