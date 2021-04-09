package io.pragra.lms.lmsdemo.entitiy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder(toBuilder = true)
@ApiModel
public class Course extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(name = "id", example = "123", required = false)
    private Long id;
    @ApiModelProperty(name = "uuid", notes = "this wil be a unique id given", example = "aab2-293nsj-29jddhhd")
    private String uuid;

    @ApiModelProperty(name = "courseName", notes = "name of course", example = "java full stack")

    private String courseName;
}
