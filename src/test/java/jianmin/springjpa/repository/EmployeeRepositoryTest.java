package jianmin.springjpa.repository;

import jianmin.springjpa.model.Department;
import jianmin.springjpa.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class EmployeeRepositoryTest {
    @Autowired
    EmployeeRepository empRepo;

    @Autowired
    DeportmentRepository deptRepo;

    @Test
    void saveEmployee() {
        Optional<Department> d = deptRepo.findById(2L);

        if(d.isPresent()) {
            Employee e = new Employee();
            e.setFirstName("Joe");
            e.setLastName("Shimel");
            e.setEmail("joe.shemel@gmail.com");
            e.setDepartment(d.get());

            Employee savedEmp = empRepo.save(e);
            log.info("Saved employee: " + savedEmp.toString());
        }else {
            log.info("Can't find department 2L");
        }
    }

    @Test
    void findEmployeeDept() {
        List<Employee> employees = empRepo.findAll();

        employees.stream().forEach(e -> {log.info(e.fullName() + ", " + e.getDepartment().toString());});
    }

}