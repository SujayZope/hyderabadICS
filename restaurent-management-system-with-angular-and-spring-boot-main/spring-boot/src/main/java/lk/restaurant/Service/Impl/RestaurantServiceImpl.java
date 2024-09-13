package lk.restaurant.Service.Impl;

import lk.restaurant.Builder.DtoBulder;
import lk.restaurant.DTO.RestaurantDTO;
import lk.restaurant.Model.M_Restaurant;
import lk.restaurant.Repository.RestaurantRepository;
import lk.restaurant.Service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    DtoBulder dtoBulder;

    @Override
    public List<RestaurantDTO> getAll() throws Exception {
        List<RestaurantDTO> restaurantDTOS=new ArrayList<>();
        for (M_Restaurant restaurants: restaurantRepository.getAllRestaurant()) {
            restaurantDTOS.add(dtoBulder.buildRestaurants(restaurants));
        }
        return restaurantDTOS;
    }
}
