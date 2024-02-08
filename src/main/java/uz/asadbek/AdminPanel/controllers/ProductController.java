package uz.asadbek.AdminPanel.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import uz.asadbek.AdminPanel.models.Product;
import uz.asadbek.AdminPanel.service.ProductService;
import uz.asadbek.AdminPanel.util.ProductValidator;

public class ProductController {
    private final ProductService productService;
    private final ProductValidator productValidator;
    @Autowired
    public ProductController(ProductService productService, ProductValidator productValidator) {
        this.productService = productService;
        this.productValidator = productValidator;
    }
    @GetMapping("/new")
    public String newProduct(Model model){
        model.addAttribute("person", new Product());
        return "product/new";
    }
    @PatchMapping("/{id}")
    public String updateProduct(@ModelAttribute("product")@Valid Product product, BindingResult bindingResult, @PathVariable("id") int id){
        productValidator.validate(product, bindingResult);
        if (bindingResult.hasErrors()){
            return "product/edit";
        }
        productService.edit(id,product);
        return "redirect:/product";
    }
    @DeleteMapping("{id}/delete")
    public String deleteProduct(@PathVariable("id") int id){
        productService.delete(id);
        return "redirect:/product";
    }
}
