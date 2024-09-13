package lk.restaurant.Repository;

import lk.restaurant.Model.M_Restaurant_Room;
import lk.restaurant.Repository.Custom.M_Restaurant_Rooms_Custom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface M_Restaurant_Rooms_Repository extends JpaRepository<M_Restaurant_Room,Integer>, M_Restaurant_Rooms_Custom {
}
