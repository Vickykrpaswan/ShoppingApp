package com.shoppingapp.controller;

import com.shoppingapp.model.Inventory;
import com.shoppingapp.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

//    get inventory
    @GetMapping("/product/{productId}/order/{orderedId}/inventory")
    public ResponseEntity<Inventory> getInventory(@PathVariable Long productId,
                                                  @PathVariable Long orderedId) {
        Inventory inventory = this.inventoryService.getInventory(productId, orderedId);
        return new ResponseEntity<>(inventory, HttpStatus.OK);
    }


}
