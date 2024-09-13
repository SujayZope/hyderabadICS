package lk.restaurant.Repository;

import lk.restaurant.Model.Rooms;

import java.util.List;


public interface RoomsRepository{

    List<Rooms> getAll()throws Exception;
}
