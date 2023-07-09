package com.beratyesbek.cqrspatterntemplate.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

import static com.beratyesbek.cqrspatterntemplate.infrastructure.constants.HibernateColumnConstants.*;
import static com.beratyesbek.cqrspatterntemplate.infrastructure.constants.HibernateTableConstants.PRODUCT;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = PRODUCT)
public class Product extends BaseEntity {

    @Column(name = COL_NAME)
    private String name;

    @Column(name = COL_DESCRIPTION)
    private String description;

    @Column(name = COL_QUANTITY)
    private int quantity;

    @Column(name = COL_PRICE)
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = COL_CATEGORY_ID, referencedColumnName = COL_ID)
    private Category category;
}
