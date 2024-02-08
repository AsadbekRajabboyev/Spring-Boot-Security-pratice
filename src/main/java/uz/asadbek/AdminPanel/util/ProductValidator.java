package uz.asadbek.AdminPanel.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import uz.asadbek.AdminPanel.models.Product;
import uz.asadbek.AdminPanel.service.ProductService;

public class ProductValidator implements Validator {
    private final ProductService productService;
@Autowired
    public ProductValidator(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Product.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Product product = (Product) o;
        if (product.getProductCount()<0){
            errors.rejectValue("count", "", "Product soni 0 dan kam bolmasligi kerak");

        }

    }
}
