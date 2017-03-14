package by.ayupov.grid;

import by.ayupov.entity.Product;
import lombok.Data;

import java.util.List;

@Data
public class ProductGrid {
    private int totalPage;
    private int currentPage;
    private long totalRecords;
    private List<Product> productData;
}
