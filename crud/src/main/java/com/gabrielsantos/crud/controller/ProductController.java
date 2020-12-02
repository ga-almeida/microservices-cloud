package com.gabrielsantos.crud.controller;

import com.gabrielsantos.crud.dto.ProductDTO;
import com.gabrielsantos.crud.entity.Product;
import com.gabrielsantos.crud.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/products")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProductController {

    private ProductService productService;
    private PagedResourcesAssembler<ProductDTO> assembler;

    @GetMapping
    public ResponseEntity<?> findAll(@PageableDefault(
            sort = "name",
            direction = Sort.Direction.ASC,
            page = 0,
            size = 12) Pageable page){

        Page<ProductDTO> pageProductDTO = productService.findAll(page);

        pageProductDTO
                .stream()
                .forEach(product -> {
                    product.add(
                            linkTo(methodOn(ProductController.class)
                                    .findById(product.getId()))
                                    .withSelfRel());
                });

        PagedModel<EntityModel<ProductDTO>> pagedModel = assembler.toModel(pageProductDTO);

        return new ResponseEntity<>(pagedModel, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ProductDTO findById(@PathVariable Long id){
        ProductDTO productDTO = productService.findById(id);
        productDTO.add(linkTo(methodOn(ProductController.class).findById(id)).withSelfRel());
        return productDTO;
    }

    @PostMapping
    public ProductDTO create(@RequestBody ProductDTO productDTO) {
        Product product = Product.toModel(productDTO);

        ProductDTO createProductDTO = productService.create(product);

        createProductDTO.add(linkTo(methodOn(ProductController.class)
                .findById(createProductDTO.getId()))
                .withSelfRel());

        return createProductDTO;
    }

    @PutMapping("/{id}")
    public ProductDTO update(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        Product product = Product.toModel(productDTO);

        ProductDTO updateProductDTO = productService.update(id, product);

        updateProductDTO.add(linkTo(methodOn(ProductController.class)
                .findById(updateProductDTO.getId()))
                .withSelfRel());

        return updateProductDTO;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.ok().build();
    }
}
