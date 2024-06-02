package service;

import model.GroceryItem;
import model.Order;
import model.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.GroceryItemRepository;
import repository.OrderItemRepository;
import repository.OrderRepository;

import java.sql.Timestamp;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private GroceryItemRepository groceryItemRepository;

    public Order placeOrder(List<OrderItem> items, Integer userId) {
        Order order = new Order();
        order.setUserId(userId);
        order.setOrderDate(new Timestamp(System.currentTimeMillis()));
        order = orderRepository.save(order);

        for (OrderItem item : items) {
            item.setOrder(order);
            GroceryItem groceryItem = groceryItemRepository.findById(item.getGroceryItem().getId()).orElseThrow();
            groceryItem.setQuantity(groceryItem.getQuantity() - item.getQuantity());
            groceryItemRepository.save(groceryItem);
            orderItemRepository.save(item);
        }
        return order;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
