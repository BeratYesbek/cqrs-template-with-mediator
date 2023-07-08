package com.beratyesbek.cqrspatterntemplate.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.OffsetDateTime;
import java.util.Date;

import static com.beratyesbek.cqrspatterntemplate.infrastructure.constants.HibernateColumnConstants.*;

@Getter
@MappedSuperclass
public abstract class BaseEntity {

    private final boolean DEFAULT_DELETED_VALUE = false;


    @Id
    @Column(name = COL_ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    @Version
    @Column(name = COL_VERSION)
    protected int version;

    @Column(name = COL_DELETED)
    protected Boolean deleted = DEFAULT_DELETED_VALUE;

    @CreationTimestamp
    @Column(name = COL_CREATED_AT)
    private Date createdAt;
}
