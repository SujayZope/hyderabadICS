package lk.restaurant.Service;


import lk.restaurant.DTO.RestaurantTablesDTO;

import java.util.List;

public interface Restaurant_Tables_Service{

    List<RestaurantTablesDTO> getAll(Integer id);

//    List<RestaurantTablesDTO> getAllRoomsTables(Integer reId,Integer roId);

}
