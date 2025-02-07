package com.assignment5.service.impl;

import com.assignment5.entities.Product;
import com.assignment5.exceptions.ProductNotFoundException;
import com.assignment5.repo.ProductRepo;
import com.assignment5.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;

    @Autowired
    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public Product addProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product updateProduct(int id, Product product) {
        product.setId(id);
        productRepo.save(product);
        return product;
    }

    @Override
    public void deleteProduct(int id) {
        productRepo.deleteById(id);
    }

    @Override
    public Product getProduct(int id) {
        return productRepo.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not in database"));
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public List<Product> getAllProductsStartingWithName(String name) {
        return productRepo.findByNameStartingWith(name);
    }

    @Override
    public List<Product> getAllProductsEndingWithName(String name) {
        return productRepo.findByNameEndingWith(name);
    }

    @Override
    public List<Product> getProductsByName(String name) {
        return productRepo.getListOfAllProductsBasedOnName(name);
    }

    @Override
    public List<Product> getAllProductSorted(String field) {
        return productRepo.findAll(Sort.by(Sort.Direction.DESC, field));
    }

    @Override
    public Page<Product> getAllProductPage(int offset, int pageSize) {
        return productRepo.findAll(PageRequest.of(offset, pageSize));
    }

    @Override
    public Page<Product> getAllProductPageSorted(String field, int offset, int pageSize) {
        return productRepo.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(Sort.Direction.DESC, field)));
    }
}
