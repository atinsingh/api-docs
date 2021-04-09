package io.pragra.lms.lmsdemo.entitiy;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import java.time.Instant;

@Data
public abstract class BaseEntity {
    @Column
    protected Instant createDateTime = Instant.now();
    @Column
    protected Instant updateDateTime = Instant.now();
}
