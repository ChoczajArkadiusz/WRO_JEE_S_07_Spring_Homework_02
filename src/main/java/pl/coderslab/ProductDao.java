package pl.coderslab;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ProductDao {
    List<Product> products = new ArrayList (Arrays.asList(
            new Product(10L,"telewizor", 2222.50),
            new Product(11L,"kaczka", 12.50),
            new Product(12L,"książka", 10.50),
            new Product(13L,"piłka", 25.00),
            new Product(14L,"telefon", 1299.99),
            new Product(15L,"krzesło", 222.99)
    ));

    public List<Product> getList() {
        return products;
    }

    public Product getById(Long id) {
        for (Product product : products) {
            if(product.getId() == id) {
                return product;
            }
        }
        return null;
    }


}
