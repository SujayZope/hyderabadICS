package lk.restaurant.Controller;


import lk.restaurant.Service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api")
public class InventoryController {

    @Autowired(required=true)
    InventoryService inventoryService;

        @GetMapping(value = "/updateInventory/{itemCode}")
        public boolean updateInventory(@PathVariable Integer itemCode){
           // inventoryService.selectCurrentId(itemCode);
            return true;
        }
}
