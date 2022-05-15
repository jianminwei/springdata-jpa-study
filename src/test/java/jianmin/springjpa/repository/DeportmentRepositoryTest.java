package jianmin.springjpa.repository;

import jianmin.springjpa.model.Department;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class DeportmentRepositoryTest {
    @Autowired
    DeportmentRepository deptRepo;

    @Test
    void findAll() {
        List<Department> depts = deptRepo.findAll();

        //depts.stream().forEach(System.out::println);
        depts.stream().forEach(d -> {log.info(d.toString());});
    }

    @Test
    void findById() {
        Optional<Department> d = deptRepo.findById(2L);

        if(d.isPresent()) {
            log.info(d.get().toString());
        }
    }

    @Test
    void deleteById() {
        deptRepo.deleteById(3L);
    }

    @Test
    void findByName() {
        Optional<Department> d = deptRepo.findByDepartmentName("Sales");

        if(d.isPresent()) {
            log.info(d.get().toString());
        } else {
            log.info("can't find Sales department");
        }

    }
}