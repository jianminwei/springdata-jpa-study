package jianmin.springjpa.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "department")
public class Department {

    /**
     * @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dept_seq_generator")
     * In this configuration, Hibernate will create a sequence based on the same specified. And use
     * the sequence for the Entity ID.
     * In practical, this is the best approach for controlling the IDs.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dept_seq_generator")
    @GenericGenerator(name = "dept_seq_generator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator")
    @Column(name = "dept_id")
    private long id;

    @Column(name = "dept_name")
    private String departmentName;

}
