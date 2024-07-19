package com.devsuperior.mpcommerce.Services;

import com.devsuperior.mpcommerce.dto.CategoryDTO;
import com.devsuperior.mpcommerce.entities.Category;
import com.devsuperior.mpcommerce.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Page<CategoryDTO> findAllCategories(Pageable pageable){

        Page<Category> result= categoryRepository.searchAllCategory(pageable);

        return result.map(x->new CategoryDTO(x));    }
}
