package jianmin.springjpa.repository;

import jianmin.springjpa.model.Department;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.EntityGraph;

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
        //depts.stream().forEach(d -> {log.info(d.toString());});
        depts.stream().forEach(d -> {log.info(d.getId() + ", " + d.getDepartmentName());});
    }

    @Test
    void findById() {
         Department d = deptRepo.findById(6L).orElseThrow();

         log.info(d.toString());
     }

    @Test
    void deleteById() {
        deptRepo.deleteById(2L);
    }


    @Test
    void saveDept() {
        Department d = new Department();

        d.setDepartmentName("Research");
        deptRepo.save(d);
    }
}