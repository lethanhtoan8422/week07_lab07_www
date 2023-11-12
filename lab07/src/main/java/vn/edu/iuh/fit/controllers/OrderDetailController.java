package vn.edu.iuh.fit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.iuh.fit.services.OrderDetailService;

@RestController
@RequestMapping(path = "/order-detail")
@CrossOrigin(origins = "*")
public class OrderDetailController {
    @Autowired
    private OrderDetailService orderDetailService;

    @GetMapping("/current-order-detail-id")
    public long getCurrentOrderDetailID(){
        return orderDetailService.getCurrentOrderDetailID();
    }
}
