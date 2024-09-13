package lk.restaurant.Repository;

import lk.restaurant.Model.Config_restaurant_room_table;
import lk.restaurant.Repository.Custom.ConfigRestaurantRoomTableCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfigRestaurantRoomTableRepository extends JpaRepository<Config_restaurant_room_table,Integer>, ConfigRestaurantRoomTableCustom {
}
