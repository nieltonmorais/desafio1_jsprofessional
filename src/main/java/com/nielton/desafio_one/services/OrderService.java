package com.nielton.desafio_one.services;

import com.nielton.desafio_one.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    ShippingService shippingService;

    @Autowired
    Order order;

    public double total(Order order){
        return order.getBasic() - ((order.getDiscount()/100) * order.getBasic());
    }
}
