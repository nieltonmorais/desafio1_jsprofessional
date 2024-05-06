package com.nielton.desafio_one.services;

import com.nielton.desafio_one.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    private final double FAIXA_ZERO = 0.0;
    private final double FAIXA_ONE = 20.0;
    private final double FAIXA_TWO = 12.00;

    public double shipment(Order order){
        if(order.getBasic() < 100.00) {
            return FAIXA_ONE;
        } else if (order.getBasic() >= 100.00 && order.getBasic() < 200.00){
            return FAIXA_TWO;
        } else {
            return FAIXA_ZERO;
        }
    }
}
