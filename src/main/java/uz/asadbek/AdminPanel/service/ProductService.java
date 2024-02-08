package uz.asadbek.AdminPanel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.asadbek.AdminPanel.models.Product;
import uz.asadbek.AdminPanel.repository.ProductRepo;

@Service
@Transactional(readOnly = true)
public class ProductService {
    private final ProductRepo productRepo;
    @Autowired
    public ProductService(ProductRepo debtRepository) {
        this.productRepo = debtRepository;
    }
    @Transactional
    public void save(Product product){
        productRepo.save(product);
    }
    @Transactional
    public void edit(int id, Product yangiProduct) {
        yangiProduct.setId(id);
        productRepo.save(yangiProduct);
    }
    @Transactional
    public void delete(int id) {
        productRepo.deleteById(id);
    }
}
