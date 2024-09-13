package lk.restaurant.Repository;

import lk.restaurant.Model.Front_kot_bot_item;
import lk.restaurant.Repository.Custom.Front_Kot_Bot_Item_Custom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Front_Kot_Bot_Item_Repository extends JpaRepository<Front_kot_bot_item,Integer>, Front_Kot_Bot_Item_Custom {


}
