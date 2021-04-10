package io.pragra.lms.lmsdemo.entitiy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student extends BaseEntity{

    @Id
    private Integer id;
    private String firstName;
    private String lastName;

}
