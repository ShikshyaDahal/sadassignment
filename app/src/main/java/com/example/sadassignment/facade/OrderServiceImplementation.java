package com.example.sadassignment.facade;

import com.example.sadassignment.services.PaymentService;
import com.example.sadassignment.services.ShippingService;

public class OrderServiceImplementation implements OrderService {
    @Override
    public String placeOrder(String productid) {
        PaymentService.pay(productid);
        ShippingService.ship(productid);
        return "Payment and shipping done";
    }
}
