package com.example.stockmarket.data;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@Data
public class StockCategoryId implements Serializable {

    @ManyToOne
    private Stock stock;

    @ManyToOne
    private Category category;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StockCategoryId that = (StockCategoryId) o;

        if (stock != null ? !stock.equals(that.stock) : that.stock != null) return false;
        if (category != null ? !category.equals(that.category) : that.category != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        result = (stock != null ? stock.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        return result;
    }
}
