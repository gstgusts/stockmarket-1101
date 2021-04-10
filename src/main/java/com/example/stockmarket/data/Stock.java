package com.example.stockmarket.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "stock", uniqueConstraints = {
        @UniqueConstraint(columnNames = "STOCK_NAME"),
        @UniqueConstraint(columnNames = "STOCK_CODE") })
public class Stock implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "STOCK_ID", unique = true, nullable = false)
    private Integer stockId;

    @Column(name = "STOCK_CODE", unique = true, nullable = false, length = 10)
    private String stockCode;

    @Column(name = "STOCK_NAME", unique = true, nullable = false, length = 20)
    private String stockName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.stock", cascade=CascadeType.ALL)
    private Set<StockCategory> stockCategories = new HashSet<StockCategory>(0);
}
