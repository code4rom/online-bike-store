package com.bikestore.online_bike_store.service;

import com.bikestore.online_bike_store.model.Product;
import com.bikestore.online_bike_store.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
        productRepository.findById(productId).ifPresent(product -> {
            product.setStockQuantity(product.getStockQuantity() - quantity);
            productRepository.save(product);
        });
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void updateProductStock(Long productId, Integer stockQuantity) {
        productRepository.findById(productId).ifPresent(product -> {
            product.setStockQuantity(stockQuantity);
            productRepository.save(product);
        });
    }

    @Override
    public void updateProductStockAndPrice(Long productId, Integer stockQuantity, BigDecimal price) {
        productRepository.findById(productId).ifPresent(product -> {
            product.setStockQuantity(stockQuantity);
            product.setPrice(price);
            productRepository.save(product);
        });
    }
}
