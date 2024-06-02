package controller;

import model.GroceryItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.GroceryItemService;

import java.util.List;

@RestController
@RequestMapping("/grocery-items")
public class GroceryItemController {

    @Autowired
    private GroceryItemService groceryItemService;

    @PostMapping("/add-items")
    public GroceryItem addGroceryItem(@RequestBody GroceryItem item) {

        return groceryItemService.addGroceryItem(item);
    }

    @GetMapping("/get-items")
    public List<GroceryItem> getAllGroceryItems() {

        return groceryItemService.getAllGroceryItems();
    }

    @PutMapping("/{id}")
    public GroceryItem updateGroceryItem(@PathVariable Long id, @RequestBody GroceryItem itemDetails) {
        return groceryItemService.updateGroceryItem(id, itemDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteGroceryItem(@PathVariable Long id) {
        groceryItemService.deleteGroceryItem(id);
    }
}

