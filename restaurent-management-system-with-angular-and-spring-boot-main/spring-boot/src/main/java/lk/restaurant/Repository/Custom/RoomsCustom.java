package lk.restaurant.Repository.Custom;

import lk.restaurant.Model.Rooms;

import java.util.List;

public interface RoomsCustom  {
    List<Rooms> getAll()throws Exception;
}
