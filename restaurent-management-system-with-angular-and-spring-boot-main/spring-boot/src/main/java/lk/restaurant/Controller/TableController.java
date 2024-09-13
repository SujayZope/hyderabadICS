package lk.restaurant.Controller;

import lk.restaurant.DTO.M_Restaurant_RoomsDTO;
import lk.restaurant.DTO.RestaurantTablesDTO;
import lk.restaurant.Service.M_Restaurant_Rooms_Service;
import lk.restaurant.Service.Restaurant_Tables_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api")
public class TableController {

    @Autowired
    Restaurant_Tables_Service restaurant_tables_service;

    @Autowired
    M_Restaurant_Rooms_Service m_restaurant_rooms_service;

    @GetMapping(value = "/numberOfTables/{reId}")
    public List<RestaurantTablesDTO> getRestaurantTables(@PathVariable Integer reId){
        List<RestaurantTablesDTO> tablesDTOS = restaurant_tables_service.getAll(reId);
        return tablesDTOS;
    }

    @GetMapping(value = "/numberOfRooms/{id}")
    public List<M_Restaurant_RoomsDTO>getRestaurantRooms(@PathVariable Integer id){
        List<M_Restaurant_RoomsDTO> roomsDTOS=m_restaurant_rooms_service.getAllResRooms(id);
        return roomsDTOS;
    }

}
