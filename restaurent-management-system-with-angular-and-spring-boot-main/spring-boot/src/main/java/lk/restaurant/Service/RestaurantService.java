package lk.restaurant.Service;

import lk.restaurant.DTO.RestaurantDTO;

import java.util.List;

public interface RestaurantService {

    List<RestaurantDTO> getAll()throws Exception;
}
