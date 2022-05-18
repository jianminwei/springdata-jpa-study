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
     * Create a bi-direction ManyToOne association. Normally the Many side own the relationship,
     * and the One side just reference it using @OneToMany(mappedBy = "department"). In this case,
     * "department" is the private property in the Employee entity.
     */
    @OneToMany(mappedBy = "department")
    private List<Employee> employees;


    /**
     * This is a utility method for adding an employee in the bi-directional ManyToOne
     * situation.
     *
     * @param employee
     * @return Employee
     */
    public Employee addEmployee(Employee employee) {
        this.employees.add(employee);
        employee.setDepartment(this);

        return employee;
    }
}
