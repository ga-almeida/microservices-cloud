package com.gabrielsantos.payment.dto;

import com.gabrielsantos.payment.entity.Sell;
import com.gabrielsantos.payment.entity.SellProduct;
import lombok.*;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class SellDTO extends RepresentationModel<SellDTO> {

    private Long id;

    private ZonedDateTime date;

    private List<SellProduct> products;

    private Double valueTotal;

    public static SellDTO toDTO(Sell sell) {
        return new ModelMapper().map(sell, SellDTO.class);
    }
}
