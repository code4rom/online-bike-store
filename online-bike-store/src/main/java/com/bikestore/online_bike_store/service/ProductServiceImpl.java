package com.bikestore.online_bike_store.service;

import com.bikestore.online_bike_store.model.Product;
import com.bikestore.online_bike_store.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void addProductToCart(Long productId, int quantity) {
        ProductServiceImpl cartService = null;
        cartService.addProductToCart(productId, quantity);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

}
