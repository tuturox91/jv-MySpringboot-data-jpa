package mate.academy.springboot.datajpa.service.mapper.impl;

import mate.academy.springboot.datajpa.dto.ProductResponseDto;
import mate.academy.springboot.datajpa.service.mapper.DtoResponseMapper;
import mate.academy.springboot.datajpa.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductResponseMapper implements DtoResponseMapper<ProductResponseDto, Product> {

    public ProductResponseDto toResponseDto(Product product) {
        ProductResponseDto responseDto = new ProductResponseDto();
        responseDto.setId(product.getId());
        responseDto.setPrice(product.getPrice());
        responseDto.setTitle(product.getTitle());
        responseDto.setCategory(product.getCategory().getId());
        return responseDto;
    }
}
