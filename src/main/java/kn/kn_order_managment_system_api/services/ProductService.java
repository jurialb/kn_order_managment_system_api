package kn.kn_order_managment_system_api.services;

import kn.kn_order_managment_system_api.dto.ProductDTO;
import kn.kn_order_managment_system_api.entity.Product;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getAllProducts();
    void saveProduct(ProductDTO productDTO);
    ProductDTO getProduct(int product_id);
    void deleteProduct(int product_id);
}
