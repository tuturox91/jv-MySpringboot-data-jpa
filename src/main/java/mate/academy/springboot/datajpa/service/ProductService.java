package mate.academy.springboot.datajpa.service;

import mate.academy.springboot.datajpa.model.Product;
import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    Product save(Product product);

    Product getById(Long id);

    void deleteById(Long id);

    Product update(Product product);

    List<Product> getProductsWherePriceBetween(BigDecimal from, BigDecimal to);

    List<Product> findAllByCategoryIdIn(List<Long> categoryIds);

    List<Product> findAllByCategory_NameIn(List<String> categoryName);
}
