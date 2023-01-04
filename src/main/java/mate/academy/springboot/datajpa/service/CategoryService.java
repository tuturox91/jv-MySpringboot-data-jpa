package mate.academy.springboot.datajpa.service;

import mate.academy.springboot.datajpa.model.Category;
import java.math.BigDecimal;
import java.util.List;

public interface CategoryService {
    Category save(Category category);

    Category getById(Long id);

    void deleteById(Long id);

    Category update(Category category);

}
