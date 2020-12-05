package com.gabrielsantos.payment.dto;

import com.gabrielsantos.payment.entity.Product;
import com.gabrielsantos.payment.entity.Sell;
import lombok.*;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ProdutctDTO extends RepresentationModel<ProdutctDTO> {

    private Long id;

    private Integer storage;

    public static ProdutctDTO toDTO(Product product) {
        return new ModelMapper().map(product, ProdutctDTO.class);
    }
}
