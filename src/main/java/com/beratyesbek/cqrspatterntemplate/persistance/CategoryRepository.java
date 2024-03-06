package com.beratyesbek.cqrspatterntemplate.persistance;

import com.beratyesbek.cqrspatterntemplate.domain.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category findByName(String name);
}
