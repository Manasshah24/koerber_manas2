package com.assignment5.service;

import com.assignment5.entities.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    public Product addProduct(Product product);
    public Product updateProduct(int id, Product product);
    public void deleteProduct(int id);
    public Product getProduct(int id);
    public List<Product> getAllProducts();

    public List<Product> getAllProductsStartingWithName(String name);
    public List<Product> getAllProductsEndingWithName(String name);
    public List<Product> getProductsByName(String name);

    public List<Product> getAllProductSorted(String field);
    public Page<Product> getAllProductPage(int offset, int pageSize);
    public Page<Product> getAllProductPageSorted(String field,int offset, int pageSize);
}
