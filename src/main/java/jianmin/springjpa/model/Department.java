package jianmin.springjpa.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dept_id")
    private long id;

    @Column(name = "dept_name")
    private String departmentName;

    /**
     * Note: you have to specify @JoinColumn on the employee table, otherwise Hibernate
     * creates an association table in the middle. But for One to Many relationship, you never
     * do that.
     */
    @OneToMany
    @JoinColumn(name = "dept_id")
    private List<Employee> employees = new ArrayList<>();

}
