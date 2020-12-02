package com.gabrielsantos.crud.entity;

import com.gabrielsantos.crud.dto.ProductDTO;
import lombok.*;
import org.modelmapper.ModelMapper;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(nullable = false, length = 10)
    private Integer storage;

    @Column(nullable = false, length = 10)
    private Double price;

    public static Product toModel(ProductDTO productDTO) {
        return new ModelMapper().map(productDTO, Product.class);
    }
}
