package jianmin.springjpa.repository;

import jianmin.springjpa.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeportmentRepository extends JpaRepository<Department, Long> {
}
