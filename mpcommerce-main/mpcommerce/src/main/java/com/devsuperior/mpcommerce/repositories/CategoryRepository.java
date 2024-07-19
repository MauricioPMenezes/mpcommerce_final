package com.devsuperior.mpcommerce.repositories;

import com.devsuperior.mpcommerce.dto.CategoryDTO;
import com.devsuperior.mpcommerce.entities.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepository extends JpaRepository<Category,Long> {

    @Query("SELECT obj " +
            "FROM Category obj ")
    Page<Category> searchAllCategory(Pageable pageable);
}
