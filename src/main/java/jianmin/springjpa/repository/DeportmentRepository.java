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
    Optional<Department> findByDepartmentName(String departmentName);

    /**
     * Note: For a One to Many relationship, Hibernate use LAZY fetching by default.
     *       But when you try to fetch anything from the One side, it tries to get the
     *       Many associated list, and it would fail. More precisely, if you do a toString()
     *       for the Department, it will try to fetch its employees because employee list is
     *       part of the object. But if you only need Department info, like ID and name, it won't
     *       try to fetch employees. It's OK in this case.
     *
     *       The solution is to add @EntityGraph to the method when it's needed.
     * @return List<Department>
     */

//    @Override
//    @EntityGraph(attributePaths = "employees")
//    List<Department> findAll();

    @Override
    @EntityGraph(attributePaths = "employees")
    Optional<Department> findById(Long aLong);

}
