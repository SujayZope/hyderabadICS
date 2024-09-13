package lk.restaurant.Repository.Custom;

import lk.restaurant.Model.M_Restaurant_Room;

import java.util.List;

public interface M_Restaurant_Rooms_Custom {

    List<M_Restaurant_Room> getResRooms(Integer id);
}
