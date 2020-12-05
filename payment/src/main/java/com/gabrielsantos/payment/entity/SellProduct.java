package com.gabrielsantos.payment.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "sell_products")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class SellProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_produto", nullable = false, length = 10)
    private Long idProduto;

    @Column(nullable = false, length = 10)
    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sell")
    private Sell sell;

}
