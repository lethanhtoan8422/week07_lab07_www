package vn.edu.iuh.fit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.models.Order;
import vn.edu.iuh.fit.services.OrderService;

@RestController
@RequestMapping(path = "/orders")
@CrossOrigin(origins = "*")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public boolean create(@RequestBody Order order){
        return orderService.create(order) != null;
    }

    @GetMapping("/{id}")
    public Order getByID(@PathVariable("id") long id){
        return orderService.getByID(id).orElse(null);
    }

    @GetMapping("/current-order-id")
    public long getCurrentOrderID(){
        return orderService.getCurrentOrderID();
    }
}
