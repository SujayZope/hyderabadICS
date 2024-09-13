package lk.restaurant.Repository.Custom.Impl;

import lk.restaurant.Model.Config_restaurant_room_table;
import lk.restaurant.Repository.Custom.ConfigRestaurantRoomTableCustom;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ConfigRestaurantRoomTableCustomImpl implements ConfigRestaurantRoomTableCustom {

    @Autowired
    EntityManager entityManager;

    @Override
    public List<Config_restaurant_room_table> getAllTables(Integer reId) {
        Query q=entityManager.createNativeQuery("SELECT configid,RestrauntId,Room_Id,table_Id FROM config_restaurant_room_table WHERE RestrauntId='"+reId+"'",Config_restaurant_room_table.class);
        return q.getResultList();
    }

//    @Override
//    public List<Config_restaurant_room_table> getAllTables(Integer reId) {
//        Query q=entityManager.createNativeQuery("SELECT configid,RestrauntId,Room_Id,table_Id FROM config_restaurant_room_table WHERE RestrauntId='"+reId+"'",Config_restaurant_room_table.class);
//        return q.getResultList();
//    }
}
