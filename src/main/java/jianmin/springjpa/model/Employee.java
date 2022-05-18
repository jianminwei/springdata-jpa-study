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

    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Department department;

    @Transient
    public String fullName() {
        return firstName + ", " + lastName;
    }
}
