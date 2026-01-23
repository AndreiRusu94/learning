package com.spring.cloud.cloud.service;

import com.spring.cloud.cloud.model.Product;
import com.spring.cloud.cloud.model.ProductInputDto;
import com.spring.cloud.cloud.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional
    public Product updateProduct(Long id, ProductInputDto productInputDto) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        product.setName(productInputDto.getName());
        product.setPrice(productInputDto.getPrice());

        return productRepository.save(product);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
}
