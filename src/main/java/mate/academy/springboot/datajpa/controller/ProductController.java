package mate.academy.springboot.datajpa.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import mate.academy.springboot.datajpa.dto.ProductRequestDto;
import mate.academy.springboot.datajpa.dto.ProductResponseDto;
import mate.academy.springboot.datajpa.dto.mapper.DtoRequestMapper;
import mate.academy.springboot.datajpa.dto.mapper.DtoResponseMapper;
import mate.academy.springboot.datajpa.model.Product;
import mate.academy.springboot.datajpa.service.ProductService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final DtoResponseMapper<ProductResponseDto, Product> responseMapper;
    private final DtoRequestMapper<ProductRequestDto, Product> requestMapper;

    public ProductController(
            ProductService productService,
            DtoResponseMapper<ProductResponseDto, Product> responseMapper,
            DtoRequestMapper<ProductRequestDto, Product> requestMapper) {
        this.productService = productService;
        this.responseMapper = responseMapper;
        this.requestMapper = requestMapper;
    }

    @PostMapping
    public ProductResponseDto addProduct(@RequestBody ProductRequestDto requestDto) {
        return responseMapper.toResponseDto(
                productService.save(requestMapper.toModel(requestDto)));
    }

    @GetMapping("/{id}")
    public ProductResponseDto getById(@PathVariable Long id) {
        return responseMapper.toResponseDto(productService.getById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }

    @PutMapping("/{id}")
    public ProductResponseDto update(@PathVariable Long id,
                                     @RequestBody ProductRequestDto requestDto) {
        Product product = requestMapper.toModel(requestDto);
        product.setId(id);
        productService.update(product);
        return responseMapper.toResponseDto(product);
    }

    @GetMapping("/by-price")
    public List<ProductResponseDto> getAllByPrice(@RequestParam BigDecimal from,
                                                  @RequestParam BigDecimal to) {
        return productService.getProductsWherePriceBetween(from, to)
                .stream()
                .map(responseMapper::toResponseDto).collect(Collectors.toList());
    }

    @GetMapping("/by-categories")
    public List<ProductResponseDto> getAllByCategory(@RequestParam List<Long> categories) {
        return productService.findAllByCategoryIdIn(categories)
                .stream()
                .map(responseMapper::toResponseDto).collect(Collectors.toList());
    }

    @GetMapping("/by-categoriesName")
    public List<ProductResponseDto> getAllByCategoryName(@RequestParam List<String> categories) {
        return productService.findAllByCategory_NameIn(categories)
                .stream()
                .map(responseMapper::toResponseDto).collect(Collectors.toList());
    }

}
