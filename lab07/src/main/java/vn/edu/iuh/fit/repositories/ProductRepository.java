package vn.edu.iuh.fit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.models.Product;
import vn.edu.iuh.fit.response.ResponseProduct;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT p.name, prm.path, od.price, od.quantity, o.order_date FROM customer AS c INNER JOIN orders AS o ON c.cust_id = o.cust_id INNER JOIN order_detail AS od ON o.order_id = od.order_id INNER JOIN product AS p ON od.product_id = p.product_id INNER JOIN product_image AS prm ON p.product_id = prm.product_id WHERE c.cust_id = ?", nativeQuery = true)
    public List<Object[]> getProductsOrderedByCustomerID(long id);

    @Query(value = "SELECT p.product_id, p.name, pm.path, pr.price FROM product AS p INNER JOIN product_image AS pm ON p.product_id = pm.product_id INNER JOIN ( SELECT price_id, note, MAX(price) AS price, MAX(price_date_time) AS price_date_time, product_id FROM product_price GROUP BY product_id )AS pr ON p.product_id = pr.product_id GROUP BY p.name, YEAR(o.order_date), MONTH(o.order_date)", nativeQuery = true)
    public List<Object[]> getInfoProducts();
}
