package vn.edu.iuh.fit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.repositories.ProductRepository;
import vn.edu.iuh.fit.response.ResponseProduct;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public List<ResponseProduct> getProductsOrderedByCustomerID(long id){
        List<ResponseProduct> responseProducts = new ArrayList<>();
        for(Object[] o : productRepository.getProductsOrderedByCustomerID(id)){
            ResponseProduct responseProduct = new ResponseProduct((String) o[0], (String) o[1], (Double) o[2],(Integer) o[3],(String) o[4]);
            responseProducts.add(responseProduct);
        }
        return responseProducts;
    }

    public List<Object[]> getInfoProducts(){
        return productRepository.getInfoProducts();
    }
}
