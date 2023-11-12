package vn.edu.iuh.fit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.response.ResponseProduct;
import vn.edu.iuh.fit.services.ProductService;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(path = "/products")
@CrossOrigin(origins = "*")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/ordered-by-cust-{id}")
    public List<ResponseProduct> getProductsOrderedByCustomerID(@PathVariable("id") long id){
        return productService.getProductsOrderedByCustomerID(id);
    }

    @GetMapping("/information-products")
    public List<Object[]> getInfoProducts(){
        return productService.getInfoProducts();
    }
}
