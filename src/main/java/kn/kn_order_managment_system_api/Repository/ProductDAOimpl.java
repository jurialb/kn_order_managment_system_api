package kn.kn_order_managment_system_api.Repository;

import jakarta.persistence.*;
import kn.kn_order_managment_system_api.Repository.interfaces.ProductDAO;
import kn.kn_order_managment_system_api.dto.ProductDTO;
import kn.kn_order_managment_system_api.entity.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ProductDAOimpl implements ProductDAO {
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<ProductDTO> getAllProducts() {
        Query query = entityManager.createQuery("from Product ");
        List<ProductDTO> allProducts= query.getResultList();
        return allProducts;
    }

    @Override
    public void saveProduct(ProductDTO productDTO) {
        Product NewProduct = modelMapper.map(productDTO, Product.class);
        entityManager.persist(NewProduct);
    }

    @Override
    public ProductDTO getProduct(int product_id) {
        Product DBproduct =  entityManager.find(Product.class,product_id);
        if (DBproduct != null) {
            return modelMapper.map(DBproduct, ProductDTO.class);
        } else {
            return null;
        }
    }

    @Override
    public void deleteProduct(int product_id) {
        Query query = entityManager.createQuery("delete from Product where productId=:product_id");
        query.setParameter("product_id", product_id);
        query.executeUpdate();
        entityManager.clear();
    }
}