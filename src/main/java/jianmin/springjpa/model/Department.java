package jianmin.springjpa.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "department")
public class Department {


    /**
     * @GeneratedValue(strategy = GenerationType.IDENTITY)
     * In this configuration, Hibernate will use database AUTO_INCREMENT for the id column.
     * This configuration is fully controlled by the database.
     * It is a better approach then the @GeneratedValue(strategy = GenerationType.AUTO)
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dept_id")
    private long id;

    @Column(name = "dept_name")
    private String deptName;

}
