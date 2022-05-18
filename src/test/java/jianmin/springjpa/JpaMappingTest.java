package jianmin.springjpa;

import jianmin.springjpa.exception.ResourceNotFoundException;
import jianmin.springjpa.model.Department;
import jianmin.springjpa.model.Employee;
import jianmin.springjpa.repository.DeportmentRepository;
import jianmin.springjpa.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class JpaMappingTest {
    @Autowired
    DeportmentRepository deptRepo;

    @Autowired
    EmployeeRepository empRepo;

    @Test
    void findAllDepts() {
        List<Department> depts = deptRepo.findAll();

        //depts.stream().forEach(System.out::println);
        depts.stream().forEach(d -> {log.info(d.toString());});
    }

    @Test
    void findDeptById() {
        Department d = deptRepo.findById(2L).orElseThrow();
        log.info("Department: " + d.getId() + ", " + d.getDepartmentName());
    }

    @Test
    void deleteDeptById() {
        //can't delete a department due to referential integrity.
        //deptRepo.deleteById(2L);
    }

    @Test
    void findDeptByName() {
        Department d = deptRepo.findByDepartmentName("Sales").orElseThrow();
        log.info("Department: " + d.getId() + ", " + d.getDepartmentName());
    }

    @Test
    void saveDept() {
        Department d = new Department();

        d.setDepartmentName("Research");
        Department savedDept =  deptRepo.save(d);
        log.info("Department saved: " + savedDept.toString());
    }

    @Test
    void saveEmployee() {
        Department d = deptRepo.findByDepartmentName("Sales").orElseThrow();
        Employee e = new Employee();
        e.setFirstName("Joe");
        e.setLastName("Shimel");
        e.setEmail("joe.shimel@gmail.com");

        d.getEmployees().add(e);

        /**
         * Note: In order to make below save Employee working, two things you have to do:
         * 1. The deptRepo.findByDepartmentName() have to add the EntityGraph annotation.
         * 2. You have to save the employee with empRepo. You can't save the employee with the
         *    department d.
         */
        Employee savedEmp = empRepo.save(e);

        log.info("Employee saved: " + e.getId() + ", " + e.getFirstName() + "," + e.getLastName());
    }

    @Test
    void findAllEmployees() {
        List<Employee> employees = empRepo.findAll();

        employees.stream().forEach(e -> {log.info("employee: " + e.toString()  ) ; });
    }

}