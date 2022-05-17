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
        Optional<Department> d = deptRepo.findById(2L);

        if(d.isPresent()) {
            log.info(d.get().toString());
        }
    }

    @Test
    void deleteDeptById() {
        deptRepo.deleteById(2L);
    }

    @Test
    void findDeptByName() {
        Department d = deptRepo.findByDepartmentName("Sales").orElseThrow();
        log.info(d.toString());
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
        Department d = deptRepo.findById(3L).orElseThrow();

        Employee e = new Employee();
        e.setFirstName("Joe");
        e.setLastName("Shimel");
        e.setEmail("joe.shemel@gmail.com");
        e.setDepartment(d);

        Employee savedEmp = empRepo.save(e);
        log.info("Saved employee: " + savedEmp.toString());

    }

    @Test
    void findEmployeeDept() {
        List<Employee> employees = empRepo.findAll();

        employees.stream().forEach(e -> {log.info(e.fullName() + ", " + e.getDepartment().toString());});
    }
}