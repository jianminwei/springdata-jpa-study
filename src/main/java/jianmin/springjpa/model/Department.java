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
     * When using @GeneratedValue, it's equivalent to @GeneratedValue(strategy = GenerationType.AUTO)
     * The default value for @GeneratedValue is strategy = GenerationType.AUTO.
     *
     * In this configuration, Hibernate will generate a "hibernate_sequence" table. All entities will be
     * using the same sequence table. So you can imagine that each table will have scattered IDs.
     * In practical applications, this is not desirable.
     */

    @Id
    @GeneratedValue
    @Column(name = "dept_id")
    private long id;

    @Column(name = "dept_name")
    private String deptName;

}
