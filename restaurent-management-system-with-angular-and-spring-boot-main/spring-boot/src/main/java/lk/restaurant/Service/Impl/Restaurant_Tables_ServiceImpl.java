package lk.restaurant.Service.Impl;

import lk.restaurant.Builder.DtoBulder;
import lk.restaurant.DTO.RestaurantTablesDTO;
import lk.restaurant.Model.Config_restaurant_room_table;
import lk.restaurant.Repository.ConfigRestaurantRoomTableRepository;
import lk.restaurant.Repository.Restaurant_Table_Repository;
import lk.restaurant.Service.Restaurant_Tables_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Restaurant_Tables_ServiceImpl implements Restaurant_Tables_Service {

    @Autowired
    Restaurant_Table_Repository restaurant_table_repository;

    @Autowired
    ConfigRestaurantRoomTableRepository configRestaurantRoomTableRepository;

    @Autowired
    DtoBulder dtoBulder;

    @Override
    public List<RestaurantTablesDTO> getAll(Integer reId) {
        List<RestaurantTablesDTO> tablesDTOS = new ArrayList<>();
        try {
            for (Config_restaurant_room_table tables : configRestaurantRoomTableRepository.getAllTables(reId)) {
                tablesDTOS.add(dtoBulder.buildRestaurantTables(tables));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return tablesDTOS;
    }

//    @Override
//    public List<RestaurantTablesDTO> getAllRoomsTables(Integer reId, Integer roId) {
//        List<RestaurantTablesDTO> tablesDTOS = new ArrayList<>();
//        try {
//            for (Config_restaurant_room_table tables : configRestaurantRoomTableRepository.getAllTables(reId,roId)) {
//                tablesDTOS.add(dtoBulder.buildRestaurantTables(tables));
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return tablesDTOS;
//    }

}
