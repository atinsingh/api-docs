package io.pragra.lms.lmsdemo.entitiy;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder(toBuilder = true)

public class Course extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String uuid;

    private String courseName;

    private String courseDescription;

    private String imageName;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Student> students;

}
