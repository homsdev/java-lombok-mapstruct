package com.imrhoms.main.mapper;

import com.imrhoms.main.dto.GetCategory;
import com.imrhoms.main.entity.Category;
import com.imrhoms.main.repository.CategoryRepository;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Using an abstract class to define custom mapping
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class CategoryMapper {
    @Autowired
    CategoryRepository categoryRepository;

    @Mappings({
            @Mapping(source = "id",target = "categoryId"),
            @Mapping(source = "name",target="categoryName")
    })
    abstract GetCategory toDTOGetCategory(Category category);

    /**
     * Custom mapper, uses repository to find category because getCategory does not have status
     * @param getCategory dto
     * @return category entity
     */
    Category toEntityCategory(GetCategory getCategory){
        if(getCategory==null) return null;

        Category category = categoryRepository.findById(getCategory.getCategoryId()).orElse(null);

        if(category == null) return null;

        return category;
    };

    abstract List<GetCategory> toDTOGetCategoryList(List<Category> categoryList);
    abstract List<Category> toCategoryList(List<GetCategory> getCategoryList);
}
