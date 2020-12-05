package com.gabrielsantos.payment.entity;

import com.gabrielsantos.payment.dto.ProdutctDTO;
import lombok.*;
import org.modelmapper.ModelMapper;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Product {

    @Id
    private Long id;

    @Column(nullable = false, length = 10)
    private Integer storage;

    public static Product toDTO(ProdutctDTO produtctDTO) {
        return new ModelMapper().map(produtctDTO, Product.class);
    }
}
