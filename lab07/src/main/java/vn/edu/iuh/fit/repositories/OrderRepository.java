package vn.edu.iuh.fit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.models.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("select o.orderId from Order o order by o.orderId desc limit 1")
    public long getCurrentOrderID();
}
