package service;

import model.GroceryItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.GroceryItemRepository;

import java.util.List;

@Service
public class GroceryItemService {

    @Autowired
    private GroceryItemRepository groceryItemRepository;

    public GroceryItem addGroceryItem(GroceryItem item) {
        return groceryItemRepository.save(item);
    }

    public List<GroceryItem> getAllGroceryItems() {
        return groceryItemRepository.findAll();
    }

    public GroceryItem updateGroceryItem(Long id, GroceryItem itemDetails) {
        GroceryItem item = groceryItemRepository.findById(id).orElseThrow();
        item.setName(itemDetails.getName());
        item.setPrice(itemDetails.getPrice());
        item.setQuantity(itemDetails.getQuantity());
        return groceryItemRepository.save(item);
    }

    public void deleteGroceryItem(Long id) {
        groceryItemRepository.deleteById(id);
    }
}
