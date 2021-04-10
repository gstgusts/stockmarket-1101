package com.example.stockmarket.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "stock_category")
@AssociationOverrides({
        @AssociationOverride(name = "pk.stock",
                joinColumns = @JoinColumn(name = "STOCK_ID")),
        @AssociationOverride(name = "pk.category",
                joinColumns = @JoinColumn(name = "CATEGORY_ID")) })
public class StockCategory {
    @EmbeddedId
    private StockCategoryId pk = new StockCategoryId();

    @Temporal(TemporalType.DATE)
    @Column(name = "CREATED_DATE", nullable = false, length = 10)
    private Date createdDate;

    @Column(name = "CREATED_BY", nullable = false, length = 10)
    private String createdBy;

    @Transient
    public Stock getStock() {
        return getPk().getStock();
    }

    public void setStock(Stock stock) {
        getPk().setStock(stock);
    }

    @Transient
    public Category getCategory() {
        return getPk().getCategory();
    }

    public void setCategory(Category category) {
        getPk().setCategory(category);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        StockCategory that = (StockCategory) o;

        if (getPk() != null ? !getPk().equals(that.getPk())
                : that.getPk() != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (getPk() != null ? getPk().hashCode() : 0);
    }
}
