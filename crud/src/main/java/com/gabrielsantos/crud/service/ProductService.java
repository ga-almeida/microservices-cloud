package com.gabrielsantos.crud.service;

import com.gabrielsantos.crud.dto.ProductDTO;
import com.gabrielsantos.crud.entity.Product;
import com.gabrielsantos.crud.exception.ResourceNotFoundException;
import com.gabrielsantos.crud.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProductService {

    private ProductRepository productRepository;

    public ProductDTO create(Product product) {
        Product saveProduct = productRepository.save(product);
        return ProductDTO.toDTO(saveProduct);
    }

    public Page<ProductDTO> findAll(Pageable pageable) {
        var page = productRepository.findAll(pageable);
        return page.map(product -> ProductDTO.toDTO(product));

    }

    public ProductDTO findById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID: " + id));

        return ProductDTO.toDTO(product);
    }

    public ProductDTO update(Long id, Product product) {
        productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID: " + id));

        Product saveProduct = productRepository.save(product);

        return ProductDTO.toDTO(saveProduct);
    }

    public void delete(Long id) {
        Product findProductById = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID: " + id));

        productRepository.delete(findProductById);
    }
}
