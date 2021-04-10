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
@Table(name = "category")
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "CATEGORY_ID", unique = true, nullable = false)
    private Integer categoryId;

    @Column(name = "NAME", nullable = false, length = 10)
    private String name;

    @Column(name = "DESC", nullable = false)
    private String desc;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.category")
    private Set<StockCategory> stockCategories = new HashSet<StockCategory>(0);
}
