package com.gabrielsantos.payment.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Table(name = "sells")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Sell {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date", nullable = false)
    private ZonedDateTime date;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "sell", cascade = {CascadeType.REFRESH})
    private List<SellProduct> products;

    @Column(name = "value_total", nullable = false)
    private Double valueTotal;
}
