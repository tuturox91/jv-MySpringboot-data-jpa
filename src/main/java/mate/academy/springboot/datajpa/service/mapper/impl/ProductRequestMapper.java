package mate.academy.springboot.datajpa.service.mapper.impl;

import mate.academy.springboot.datajpa.dto.ProductRequestDto;
import mate.academy.springboot.datajpa.service.mapper.DtoRequestMapper;
import mate.academy.springboot.datajpa.model.Product;
import mate.academy.springboot.datajpa.service.CategoryService;
import org.springframework.stereotype.Component;

@Component
public class ProductRequestMapper implements DtoRequestMapper<ProductRequestDto, Product> {

    private final CategoryService categoryService;

    public ProductRequestMapper(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public Product toModel(ProductRequestDto requestDto) {
        Product product = new Product();
        product.setPrice(requestDto.getPrice());
        product.setTitle(requestDto.getTitle());
        product.setCategory(categoryService.getById(requestDto.getCategory()));
        return product;
    }
}
