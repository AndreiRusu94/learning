package com.spring.cloud.cloud.controller;

import com.spring.cloud.cloud.model.Product;
import com.spring.cloud.cloud.model.ProductDto;
import com.spring.cloud.cloud.model.ProductInputDto;
import com.spring.cloud.cloud.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductInputDto input) {
        Product p = new Product();
        p.setName(input.getName());
        p.setPrice(input.getPrice());
        Product saved = productService.createProduct(p);
        return ResponseEntity.status(Response.SC_CREATED).body(new ProductDto(saved.getId(), saved.getName(), saved.getPrice()));
    }
}
