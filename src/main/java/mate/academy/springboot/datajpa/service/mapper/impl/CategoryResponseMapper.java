package mate.academy.springboot.datajpa.service.mapper.impl;

import mate.academy.springboot.datajpa.dto.CategoryResponseDto;
import mate.academy.springboot.datajpa.service.mapper.DtoResponseMapper;
import mate.academy.springboot.datajpa.model.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryResponseMapper implements DtoResponseMapper<CategoryResponseDto, Category> {

    @Override
    public CategoryResponseDto toResponseDto(Category category) {
        CategoryResponseDto responseDto = new CategoryResponseDto();
        responseDto.setName(category.getName());
        responseDto.setId(category.getId());
        return responseDto;
    }
}
