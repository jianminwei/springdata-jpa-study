package jianmin.springjpa.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
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
     * Create a OneToMany relation to Employee and specify "dept_id" is the join column.
     * From database implementation, there is no difference from ManyToOne relation from
     * the employee side. It's just that within java code, you navigate from Department to
     * employees.
     */
    @OneToMany
    @JoinColumn(name = "dept_id")
    private List<Employee> employees;
}
