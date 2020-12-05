package com.gabrielsantos.payment.dto;

import com.gabrielsantos.payment.entity.Product;
import com.gabrielsantos.payment.entity.Sell;
import com.gabrielsantos.payment.entity.SellProduct;
import lombok.*;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class SellProductDTO extends RepresentationModel<SellProductDTO> {

    private Long id;

    private Long idProduto;

    private Integer quantity;

    private Sell sell;

    public static SellProductDTO toDTO(SellProduct sellProduct) {
        return new ModelMapper().map(sellProduct, SellProductDTO.class);
    }
}
