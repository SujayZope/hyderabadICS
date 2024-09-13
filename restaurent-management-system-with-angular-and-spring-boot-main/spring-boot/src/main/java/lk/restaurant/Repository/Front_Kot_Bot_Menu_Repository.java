package lk.restaurant.Repository;

import lk.restaurant.Model.Front_kot_bot_menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Front_Kot_Bot_Menu_Repository extends JpaRepository<Front_kot_bot_menu,Long> {
}
