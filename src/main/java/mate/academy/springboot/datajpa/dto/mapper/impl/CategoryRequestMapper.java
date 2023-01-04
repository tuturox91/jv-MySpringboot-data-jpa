package mate.academy.springboot.datajpa.dto.mapper.impl;

import mate.academy.springboot.datajpa.dto.CategoryRequestDto;
import mate.academy.springboot.datajpa.dto.mapper.DtoRequestMapper;
import mate.academy.springboot.datajpa.model.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryRequestMapper implements DtoRequestMapper<CategoryRequestDto, Category> {
    @Override
    public Category toModel(CategoryRequestDto request) {
        Category category = new Category();
        category.setName(request.getName());
        return category;
    }
}
