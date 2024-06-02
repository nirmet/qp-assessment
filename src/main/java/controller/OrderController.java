package controller;

import model.Order;
import model.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/user/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public Order placeOrder(@RequestBody List<OrderItem> items, @RequestParam Integer userId) {
        return orderService.placeOrder(items, userId);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }
}

