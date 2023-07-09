package com.beratyesbek.cqrspatterntemplate.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

import static com.beratyesbek.cqrspatterntemplate.infrastructure.constants.HibernateColumnConstants.COL_NAME;
import static com.beratyesbek.cqrspatterntemplate.infrastructure.constants.HibernateTableConstants.CATEGORY;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = CATEGORY)
public class Category extends BaseEntity {

    @Column(name = COL_NAME)
    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Product> products;
}
