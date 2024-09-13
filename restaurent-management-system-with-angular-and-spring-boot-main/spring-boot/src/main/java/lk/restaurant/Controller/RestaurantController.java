package lk.restaurant.Controller;

import lk.restaurant.DTO.RestaurantDTO;
import lk.restaurant.Service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @GetMapping(value = "/restaurant")
    public List<RestaurantDTO> getAll(){
        List<RestaurantDTO> restaurants= null;
        try {
            restaurants = restaurantService.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return restaurants;
    }

}
