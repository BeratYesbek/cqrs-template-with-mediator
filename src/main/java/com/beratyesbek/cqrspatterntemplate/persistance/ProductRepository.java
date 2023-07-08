package com.beratyesbek.cqrspatterntemplate.persistance;

import com.beratyesbek.cqrspatterntemplate.domain.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
