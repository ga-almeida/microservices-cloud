package com.gabrielsantos.crud.dto;


import com.gabrielsantos.crud.entity.Product;
import lombok.*;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ProductDTO extends RepresentationModel<ProductDTO> {

    private Long id;

    @NonNull
    private String name;

    @NonNull
    private Integer storage;

    @NonNull
    private Double price;

    public static ProductDTO toDTO(Product product) {
        return new ModelMapper().map(product, ProductDTO.class);
    }
}
