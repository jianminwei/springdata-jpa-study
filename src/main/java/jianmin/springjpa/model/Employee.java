package jianmin.springjpa.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="employee_id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String email;

    /**
     * Declare a Unidirectional Many-to-One relationship.
     * Employee own this relationship.
     *
     * Note: Specify @JoinColumn is almost a have to. The join column name should be the foreign key
     * column name, in this case, it is dept_id. Otherwise, Hibernate will use "department_dept_id" name
     * which is always not the convention people used.
     */
    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Department department;

    @Transient
    public String fullName() {
        return firstName + ", " + lastName;
    }
}
