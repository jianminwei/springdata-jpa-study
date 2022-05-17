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

}