package lk.restaurant.Repository.Custom;

import lk.restaurant.Model.Config_restaurant_room_table;

import java.util.List;

public interface ConfigRestaurantRoomTableCustom {

    List<Config_restaurant_room_table> getAllTables(Integer reId);

//    List<Config_restaurant_room_table> getAllTables(Integer reId,Integer roId);
}
